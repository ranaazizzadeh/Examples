package com.example.entities;

import com.example.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    private Integer id;
    private String name;
    private String author;
    private BookStatus status;

    public BookEntity(String name, String author, BookStatus status) {
        this.name = name;
        this.author = author;
        this.status = status;
    }


}
