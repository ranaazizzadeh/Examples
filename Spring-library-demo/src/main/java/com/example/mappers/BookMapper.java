package com.example.mappers;

import com.example.entities.BookEntity;
import com.example.enums.BookStatus;
import com.example.models.BookModel;

public class BookMapper {
    public static BookModel entityToModel(BookEntity bookEntity){
        BookModel bookModel = new BookModel();
        bookModel.setId(bookEntity.getId());
        bookModel.setName(bookEntity.getName());
        bookModel.setAuthor(bookEntity.getAuthor());
        bookModel.setStatus(bookEntity.getStatus().ordinal());
        return bookModel;
    }

    public static BookEntity modelToEntity(BookModel bookModel){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookModel.getId());
        bookEntity.setName(bookModel.getName());
        bookEntity.setAuthor(bookModel.getAuthor());
        bookEntity.setStatus(BookStatus.values()[bookModel.getStatus()]);
        return bookEntity;
    }
}
