package com.auction.auctionapp.service;

public interface OrderService {

    void createOrder(Long auctionId, String buyerId);

    void completePayment(Long orderId);

    void viewOrderHistory(String userId);
}
