package com.example.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.productmanagement.modal.User;
import com.example.productmanagement.service.UserService;

@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> RegisterUser(@RequestBody User user) {
        try {
            userService.RegisterUser(user);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<String> LoginUser(@RequestBody User user)
    {
        try{
            userService.LoginUser(user);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
    }

}
