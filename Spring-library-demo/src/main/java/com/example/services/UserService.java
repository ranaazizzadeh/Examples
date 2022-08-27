package com.example.services;

import com.example.entities.UserEntity;
import com.example.mappers.UserMapper;
import com.example.models.UserModel;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserModel create(UserModel userModel){
        //check if exist
        UserEntity userEntity = userRepository.getByNameAndLastname(userModel.getName(),userModel.getLastname());
        if (userEntity.getId() != null) throw new RuntimeException("user " + userModel.getName() + " " + userModel.getLastname() +" is already exist");

        userEntity= userRepository
                .create(UserMapper.modelToEntity(userModel));
        if(userEntity.getId() == null) throw new RuntimeException("error in creating user in DB");
        return UserMapper.entityToModel(userEntity);

    }

    public List<UserModel> getUsers(){
        List<UserEntity> userEntityList = userRepository.getUsers();
        List<UserModel> userModelList = userEntityList
                                            .stream()
                                            .map(x -> UserMapper.entityToModel(x))
                                            .collect(Collectors.toList());
        return userModelList;
    }
}
