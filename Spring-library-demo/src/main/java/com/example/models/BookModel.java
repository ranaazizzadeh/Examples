package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {
    private Integer id;
    private String name;
    private String author;
    private Integer status;

    public BookModel(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
