package com.auction.auctionapp.repository;

import com.auction.auctionapp.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
