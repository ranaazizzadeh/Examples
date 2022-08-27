package com.example.repositories;

import com.example.dbconnection.DB;
import com.example.entities.BookEntity;
import com.example.enums.BookStatus;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    public BookEntity create(BookEntity book){
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("insert into book(book_name,author,status) values(?,?,?)",
                                            Statement.RETURN_GENERATED_KEYS
                    );
            ps.setString(1, book.getName());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getStatus().ordinal());

            int affectedRows= ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating book failed, no rows affected.");
            }
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        book.setId(generatedKeys.getInt(1));
                    }
                    else {
                        throw new SQLException("Creating book failed, no ID obtained.");
                    }
                }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return book;
    }

    public BookEntity getByName(String name)  {
        BookEntity bookEntity = new BookEntity();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("select * from book where book_name = ?");
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                bookEntity.setId(resultSet.getInt(1));
                bookEntity.setName(resultSet.getString(2));
                bookEntity.setAuthor(resultSet.getString(3));
                bookEntity.setStatus(BookStatus.values()[resultSet.getInt(4)]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookEntity;


    }

    public BookEntity get(Integer id)  {
        BookEntity bookEntity = new BookEntity();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("select * from book where book_id = ?");
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                bookEntity.setId(resultSet.getInt(1));
                bookEntity.setName(resultSet.getString(2));
                bookEntity.setAuthor(resultSet.getString(3));
                bookEntity.setStatus(BookStatus.values()[resultSet.getInt(4)]);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return bookEntity;


    }

    public List<BookEntity> getBooks(){
        List<BookEntity> bookEntityList = new ArrayList<>();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("select * from book");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                bookEntityList.add(
                        new BookEntity(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        BookStatus.values()[resultSet.getInt(4)])
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bookEntityList;
    }

    public List<BookEntity> getAvailableBooks(){
        List<BookEntity> bookEntityList = new ArrayList<>();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("select * from book where status = 0");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                bookEntityList.add(
                        new BookEntity(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                BookStatus.values()[resultSet.getInt(4)])
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bookEntityList;
    }

    public List<BookEntity> getBorrowedBooks(){
        List<BookEntity> bookEntityList = new ArrayList<>();
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("select * from book where status = 1");

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                bookEntityList.add(
                        new BookEntity(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                BookStatus.values()[resultSet.getInt(4)])
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return bookEntityList;
    }

    public BookEntity updateBookStatus(Integer id,BookStatus status) throws SQLException {
            Connection con = DB.getConnection();
            PreparedStatement ps = con
                    .prepareStatement("update book set status = ?  where book_id = ?");
            ps.setInt(1,status.ordinal());
            ps.setInt(2, id);


            int affectedRows= ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating book failed, no rows affected.");
            }

            con.close();
        return get(id);
    }


}
