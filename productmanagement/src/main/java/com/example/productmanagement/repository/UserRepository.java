package com.example.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productmanagement.modal.User;

public interface UserRepository extends JpaRepository<User,Long>{
    boolean existsByEmail(String email);
    User findByEmailAndRole(String email, String role);
}
