package com.infy.ekart.service;

import java.util.List;

import com.infy.ekart.entity.Address;
import com.infy.ekart.entity.User;

public interface UserService {
    void save(User user);

    User getByUsername(String username);
    User getById(long id);
}
