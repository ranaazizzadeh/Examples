package com.example.entities;

import com.example.enums.BookStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserBookEntity {
    private Integer id;
    private LocalDate createDate;
    private BookStatus status;
    private Integer userId;
    private Integer bookId;

    public UserBookEntity(LocalDate createDate, BookStatus status, Integer userId, Integer bookId) {
        this.createDate = createDate;
        this.status = status;
        this.userId = userId;
        this.bookId = bookId;
    }
}
