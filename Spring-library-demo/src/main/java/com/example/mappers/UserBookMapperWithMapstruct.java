package com.example.mappers;

import com.example.entities.UserBookEntity;
import com.example.models.UserBookModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserBookMapperWithMapstruct {
    UserBookModel convertToEntity (UserBookEntity userBookEntity);
    UserBookEntity convertToModel (UserBookModel userBookModel);


}
