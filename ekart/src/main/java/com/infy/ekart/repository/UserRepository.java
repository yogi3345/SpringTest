package com.infy.ekart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.ekart.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findById(long id);
}
