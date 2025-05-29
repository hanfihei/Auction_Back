package com.auction.auctionapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionId;

    // 상품과 일대일 관계
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // 주문과 일대일 관계
    @OneToOne(mappedBy = "auction")
    private Order order;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int currentPrice;
    private String status;
}