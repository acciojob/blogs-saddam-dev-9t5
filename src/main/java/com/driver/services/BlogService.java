package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    @Autowired
    ImageRepository imageRepository;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(content);

        Optional<User> optionalUser = userRepository1.findById(userId);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            blog.setUser(user);
        }
        blog = blogRepository1.save(blog);

        return blog;
    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Optional<Blog> optionalBlog = blogRepository1.findById(blogId);
        if(optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            Image image = blog.getImage();
            blogRepository1.deleteById(blogId);
            imageRepository.deleteById(image.getId());
        }
        return;
    }
}
