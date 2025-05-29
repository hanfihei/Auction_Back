package com.auction.auctionapp.domain;

import com.auction.auctionapp.domain.enums.ProductCondition;
import com.auction.auctionapp.domain.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    // 경매와 양방향 일대일 관계
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Auction auction;

    //@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<Product_Images> images = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    //@ManyToOne
    //@JoinColumn(name = "seller_id")
    //private User seller;

    private LocalDate deadline;

    @Column(length = 100)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "product_price", precision = 10, scale = 2)
    private BigDecimal productPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category categoryId;


    @Column(name = "image_path", length = 255)
    private String imagePath;


    @Enumerated(EnumType.STRING)
    @Column(name = "conditon", length = 20)
    private ProductCondition condition;

    @Column(name="created_at")
    private LocalDateTime createdAt;
}
