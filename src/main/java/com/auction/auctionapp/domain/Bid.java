package com.auction.auctionapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bidId;

    // 경매와 다대일 관계
    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    // 입찰자 (User)와 다대일 관계
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int bidAmount;
    private LocalDateTime bidTime;
}
