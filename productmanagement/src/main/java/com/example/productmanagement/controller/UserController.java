package com.example.productmanagement.controller;

import com.example.productmanagement.modal.User;
import com.example.productmanagement.service.UserService;
import com.example.productmanagement.service.AuthenticationException;
import com.example.productmanagement.service.UserAlreadyExistsException;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("success", HttpStatus.OK);
        } catch (UserAlreadyExistsException e) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestHeader("Authorization") String authHeader) {
        try {
            String credentials = new String(Base64.getDecoder().decode(authHeader.split(" ")[1]));
            String[] splitCredentials = credentials.split(":");
            String email = splitCredentials[0];
            String password = splitCredentials[1];

            User user = userService.getUserByEmailAndPassword(email, password);

            if (user != null) {
                String role = user.getRole();
                String encodedCredentials = userService.encodeCredentials(email, password);
                System.out.println("Encoded Credentials: " + encodedCredentials);
                return new ResponseEntity<>("Login successful. Role: " + role, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error during login", HttpStatus.BAD_REQUEST);
        }
    }

}
