package com.example.controllers;


import com.example.models.BookModel;
import com.example.models.UserBookModel;
import com.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping("/showAddBookForm")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new BookModel());
        return "forms/add-book";
    }

    @RequestMapping("/processAddBook")
    public String addBook(@ModelAttribute("book") BookModel bookModel, Model model) {

        try {
            bookService.create(bookModel);
        } catch (RuntimeException ex) {
            model.addAttribute("bookCreationError", ex.getMessage());
            return "errors/add-book";
        }
        return "confirmation/add-book";
    }

    @RequestMapping("/showBooks")
    public String showListOfBooks(Model model) {

        model.addAttribute("bookList", bookService.getBooks());
        return "forms/show-books";
    }

    @RequestMapping("/borrowBook")
    public String showBorrowBookForm(Model model) {

        model.addAttribute("borrowBookModel",new UserBookModel());
        model.addAttribute("availableBooksMap",bookService.getAvailableBooksMap());
        model.addAttribute("usersMap",bookService.getUsersMap());
        return "forms/borrow-book";
    }

    @RequestMapping("/processBorrowBook")
    public String borrowBook(@ModelAttribute("borrowBookModel") UserBookModel userBookModel){
        if(bookService.borrowBook(userBookModel))
            return "confirmation/borrow-book";
        return "errors/borrow-book";
    }

    @RequestMapping("/returnBook")
    public String showReturnBookForm(Model model) {

        model.addAttribute("returnBookModel",new UserBookModel());
        model.addAttribute("borrowedBooksMap",bookService.getBorrowedBooksMap());
        model.addAttribute("usersMap",bookService.getUsersMap());
        return "forms/return-book";
    }

    @RequestMapping("/processReturnBook")
    public String returnBook(@ModelAttribute("returnBookModel") UserBookModel userBookModel,Model model){
        //check if user is correct
        if(bookService.checkUserBorrowedBook(userBookModel)){
            if( bookService.returnBook(userBookModel))
                return "confirmation/return-book";
            else   model.addAttribute("returnErrorMessage","an error occurred");
        }
        else {
            model.addAttribute("returnErrorMessage","the book is not borrowed by the selected user");
        }
        return "errors/return-book";
    }
}
