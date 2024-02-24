package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    public User createUser(String username, String password){
        User newUser = new User(username, password);
        newUser = userRepository3.save(newUser);
        return newUser;
    }

    public void deleteUser(int userId){
        userRepository3.deleteById(userId);
        return;
    }

    public User updateUser(Integer id, String password){
        User user = new User();
        Optional<User> optionalUser = userRepository3.findById(id);
        if(optionalUser.isPresent()) {
            user = optionalUser.get();
            user.setPassword(password);
            userRepository3.save(user);
        }
        return user;
    }
}
