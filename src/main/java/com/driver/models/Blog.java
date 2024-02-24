package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int blogId;

    private String title;

    private String content;

    @JoinColumn
    @OneToOne
    private User user;

    @JoinColumn
    @OneToOne
    private Image image;

}