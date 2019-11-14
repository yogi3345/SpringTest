package com.infy.ekart.service;

import com.infy.ekart.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    User findById(long id);
}
