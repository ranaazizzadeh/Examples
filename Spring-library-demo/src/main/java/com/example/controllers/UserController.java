package com.example.controllers;

import com.example.models.UserModel;
import com.example.services.BookService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/showAddUserForm")
    public String showAddUserForm(Model model){
        model.addAttribute("user",new UserModel());
        return "forms/add-user";
    }

    @RequestMapping("/processAddUser")
    public String addUser(@ModelAttribute("user") UserModel userModel,Model model){
        try{
            userService.create(userModel);
        }catch (RuntimeException ex){
            model.addAttribute("userCreationError",ex.getMessage());
            return "errors/add-user";
        }
        return "confirmation/add-user";
    }

    @RequestMapping("showUsers")
    public String showListOfBooks(Model model) {

        model.addAttribute("userList", userService.getUsers());
        return "forms/show-users";
    }

}
