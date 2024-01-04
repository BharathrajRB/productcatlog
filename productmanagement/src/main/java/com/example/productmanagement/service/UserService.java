package com.example.productmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productmanagement.modal.User;
import com.example.productmanagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void RegisterUser(User user) {
        validateUser(user);
        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // String encodedPassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(encodedPassword);
        userRepository.save(user);

    }

    private void validateUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("User already exists");
        }
    }

    public void LoginUser(User user)
    {
        validateUserLogin(user);

    }
    private void validateUserLogin(User user)
    {
        //if(userRepository.)
    }
}
