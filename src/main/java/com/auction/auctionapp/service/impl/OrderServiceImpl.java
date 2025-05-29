package com.auction.auctionapp.service.impl;

import com.auction.auctionapp.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public void createOrder(Long auctionId, String buyerId) {
        // TODO: 주문 생성 로직
        System.out.println("주문 생성: 경매 ID = " + auctionId + ", 구매자 ID = " + buyerId);
    }

    @Override
    public void completePayment(Long orderId) {
        // TODO: 결제 완료 로직
        System.out.println("결제 완료: 주문 ID = " + orderId);
    }

    @Override
    public void viewOrderHistory(String userId) {
        // TODO: 주문 내역 조회 로직
        System.out.println("주문 내역 조회: 사용자 ID = " + userId);
    }
}
