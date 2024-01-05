package com.example.productmanagement.service;

import com.example.productmanagement.modal.User;
import com.example.productmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        validateUser(user);
        // Your registration logic here
        userRepository.save(user);
    }

    public void loginUser(String email, String password) {
        // Your actual login logic here, for example:
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user == null) {
            throw new AuthenticationException("Invalid email or password");
        }
        // You can return the user or perform other actions based on successful login
    }

    private void validateUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExistsException("User already exists");
        }
    }
}
