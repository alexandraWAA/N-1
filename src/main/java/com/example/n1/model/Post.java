package com.example.n1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    @ManyToOne
    private Users user;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;
}
