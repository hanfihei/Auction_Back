package com.auction.auctionapp.service;

public interface UserService {

    boolean login(String userId, String password);

    void signup(String userId, String password, String email);

    void updateProfile(String userId, String newEmail, String newPassword);
}
