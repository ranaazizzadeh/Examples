package com.example.mappers;


import com.example.entities.UserBookEntity;
import com.example.enums.BookStatus;
import com.example.models.UserBookModel;
import com.example.models.UserModel;

public class UserBookMapper {
    public static UserBookModel entityToModel(UserBookEntity userBookEntity){
       UserBookModel userBookModel = new UserBookModel();
        userBookModel.setId(userBookEntity.getId());
        userBookModel.setBookId(userBookEntity.getBookId());
        userBookModel.setUserId(userBookEntity.getUserId());
        userBookModel.setStatus(userBookEntity.getStatus().ordinal());
        userBookModel.setCreationDate(userBookEntity.getCreateDate());
        return userBookModel;
    }

    public static UserBookEntity modelToEntity(UserBookModel userBookModel){
        UserBookEntity userBookEntity = new UserBookEntity();
        userBookEntity.setId(userBookModel.getId());
        userBookEntity.setBookId(userBookModel.getBookId());
        userBookEntity.setUserId(userBookModel.getUserId());
        userBookEntity.setStatus(BookStatus.values()[userBookModel.getStatus()]);
        userBookEntity.setCreateDate(userBookModel.getCreationDate());
        return userBookEntity;
    }
}
