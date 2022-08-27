package com.example.repositories;

import com.example.dbconnection.DB;
import com.example.entities.BookEntity;
import com.example.entities.UserBookEntity;
import com.example.enums.BookStatus;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserBookRepository {
    public UserBookEntity create(UserBookEntity userBookEntity) throws SQLException {

            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("insert into user_book(create_date,status,user_id,book_id) values(?,?,?,?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
            ps.setDate(1, Date.valueOf(userBookEntity.getCreateDate()));
            ps.setInt(2, userBookEntity.getStatus().ordinal());
            ps.setInt(3, userBookEntity.getUserId());
            ps.setInt(4, userBookEntity.getBookId());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user_book failed, no rows affected.");
            }
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    userBookEntity.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating book failed, no ID obtained.");
                }
            }

            con.close();

        return userBookEntity;
    }

    public Integer getTheLastUserBorrowBook(Integer book_id) throws SQLException {

            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("select * from user_book where status = 1 and book_id = ? order by id desc");
            ps.setInt(1,book_id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
              return resultSet.getInt("user_id");
            }
            throw new SQLException();
    }
}
