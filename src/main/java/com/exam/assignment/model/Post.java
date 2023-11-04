package com.exam.assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    private int id;
    private int views;
    private String title;
    private String content;
    private String author;
}
