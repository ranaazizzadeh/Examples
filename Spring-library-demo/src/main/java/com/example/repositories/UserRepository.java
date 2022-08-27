package com.example.repositories;

import com.example.dbconnection.DB;
import com.example.entities.UserEntity;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {

    public UserEntity create(UserEntity user){
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("insert into user(name,lastname) values(?,?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastname());
           

            int affectedRows= ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public UserEntity getByNameAndLastname(String name,String lastname){
        UserEntity userEntity = new UserEntity();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("select * from user where name = ? and lastname = ?");
            ps.setString(1, name);
            ps.setString(2,lastname);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                userEntity.setId(resultSet.getInt(1));
                userEntity.setName(resultSet.getString(2));
                userEntity.setLastname(resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userEntity;

    }

    public List<UserEntity> getUsers(){
        List<UserEntity> userEntityList = new ArrayList<>();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("select * from user");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                userEntityList.add(
                        new UserEntity(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3))
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userEntityList;
    }
}
