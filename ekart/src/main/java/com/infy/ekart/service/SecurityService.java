package com.infy.ekart.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
