package com.auction.auctionapp.service.impl;

import com.auction.auctionapp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean login(String userId, String password) {
        return true;
    }

    @Override
    public void signup(String userId, String password, String email) {
    }

    @Override
    public void updateProfile(String userId, String newEmail, String newPassword) {
    }
}
