package com.auction.auctionapp.domain;

import com.auction.auctionapp.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    // 구매자 (User)와 다대일 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id") // 기본 키 user_no 기준으로 매핑
    private User buyer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 20)
    private OrderStatus orderStatus;

    @Column(name = "shipping_address", length = 255)
    private String shippingAddress;

    @Column(name = "total_price", precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "receiver_name", length = 50)
    private String receiverName;

    @Column(name = "receiver_phone", length = 20)
    private String receiverPhone;

    @Column(name = "ordered_at")
    private LocalDateTime orderAt;

    // 경매 상품과 일대일 관계
    @OneToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
}
