package com.example.services;


import com.example.entities.BookEntity;
import com.example.enums.BookStatus;
import com.example.mappers.BookMapper;
import com.example.mappers.UserBookMapper;
import com.example.models.BookModel;
import com.example.models.UserBookModel;
import com.example.repositories.BookRepository;
import com.example.repositories.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserBookRepository userBookRepository;

    @Autowired
    private UserService userService;

    public BookModel create(BookModel bookModel) {
        //check if exist
        BookEntity bookEntity = bookRepository.getByName(bookModel.getName());
        if (bookEntity.getId() != null) throw new RuntimeException("book " + bookModel.getName() + " is already exist");

        //when add a book the status should be available
        bookModel.setStatus(0);
        bookEntity = bookRepository
                .create(BookMapper.modelToEntity(bookModel));
        if (bookEntity.getId() == null) throw new RuntimeException("error in creating book in DB");
        return BookMapper.entityToModel(bookEntity);
    }

    public List<BookModel> getBooks() {

        List<BookEntity> bookEntityList = bookRepository.getBooks();
        return bookEntityList
                .stream()
                .map(x -> BookMapper.entityToModel(x))
                .collect(Collectors.toList());
    }

    public List<BookModel> getAvailableBooks(){
        List<BookEntity> bookEntityList = bookRepository.getAvailableBooks();
        return bookEntityList
                .stream()
                .map(x -> BookMapper.entityToModel(x))
                .collect(Collectors.toList());
    }

    public Map<Integer,String> getAvailableBooksMap(){
        List<BookModel> availableBooks = getAvailableBooks();
        Map<Integer, String> bookModelStringMap = availableBooks
                .stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
        return bookModelStringMap;
    }

    public List<BookModel> getBorrowedBooks(){
        List<BookEntity> bookEntityList = bookRepository.getBorrowedBooks();
        return bookEntityList
                .stream()
                .map(x -> BookMapper.entityToModel(x))
                .collect(Collectors.toList());
    }

    public Map<Integer,String> getBorrowedBooksMap(){
        List<BookModel> borrowedBooks = getBorrowedBooks();
        Map<Integer, String> bookModelStringMap = borrowedBooks
                .stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x.getName()));
        return bookModelStringMap;
    }
    public Map<Integer,String> getUsersMap(){
        Map<Integer, String> userModelStringMap = userService
                .getUsers()
                .stream()
                .collect(Collectors.toMap(x -> x.getId(), x -> x.getName() + " " + x.getLastname()));
        return userModelStringMap;
    }


    public boolean borrowBook(UserBookModel userBookModel){
        userBookModel.setCreationDate(LocalDate.now());
        userBookModel.setStatus(BookStatus.BORROWED.ordinal());

        try {
            userBookRepository.create(UserBookMapper.modelToEntity(userBookModel));
            bookRepository.updateBookStatus(userBookModel.getBookId(),BookStatus.BORROWED);
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    public boolean returnBook(UserBookModel userBookModel){
        userBookModel.setCreationDate(LocalDate.now());
        userBookModel.setStatus(BookStatus.AVAILABLE.ordinal());

        try {
            userBookRepository.create(UserBookMapper.modelToEntity(userBookModel));
            bookRepository.updateBookStatus(userBookModel.getBookId(),BookStatus.AVAILABLE);
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public boolean checkUserBorrowedBook(UserBookModel userBookModel){
        try {
            Integer theLastUserBorrowBook = userBookRepository.getTheLastUserBorrowBook(userBookModel.getBookId());
            if(theLastUserBorrowBook.equals(userBookModel.getUserId())) return true;
            return false;
        } catch (SQLException exception) {
            return false;
        }
    }
}
