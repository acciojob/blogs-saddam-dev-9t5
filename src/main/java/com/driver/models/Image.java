package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;

    private String imageUrl;

    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private Blog blog;

}