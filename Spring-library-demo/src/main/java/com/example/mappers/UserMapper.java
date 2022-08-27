package com.example.mappers;

import com.example.entities.UserEntity;
import com.example.models.UserModel;

public class UserMapper {
    public static UserEntity modelToEntity(UserModel userModel){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userModel.getId());
        userEntity.setName(userModel.getName());
        userEntity.setLastname(userModel.getLastname());
        return userEntity;
    }
    public static UserModel entityToModel(UserEntity userEntity){
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        userModel.setLastname(userEntity.getLastname());
        return userModel;
    }

}
