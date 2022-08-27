package com.example.models;

import com.example.enums.BookStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserBookModel {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private LocalDate creationDate;
    private Integer status;


    public UserBookModel(Integer userId, Integer bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
}
