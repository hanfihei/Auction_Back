package com.auction.auctionapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "`user`") // user는 MySQL 예약어이므로 백틱으로 감쌈
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", nullable = false)
    private Long userNo;

    @Column(name = "nickname", length = 50, unique = true)
    private String nickname;

    @Column(name = "user_id", length = 50, unique = true)
    private String userId;

    @Column(length = 100)
    private String password;

    @Column (columnDefinition = "TEXT")
    private String intro;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "category", length = 255)
    private String category;

    @Column(length = 100)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "bank")
    private String bank;

    @Column(name = "account_no", length = 100)
    private String accountNo;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Product> products = new ArrayList<>();

    //@OneToMany(mappedBy = "seller")
    //private List<Product> products; // 판매한 상품들


    @OneToMany(mappedBy = "user")
    private List<Interest> interests; // 관심상품

    @OneToMany(mappedBy = "buyer")
    private List<Order> orders; // 구매한 주문들

    @OneToMany(mappedBy = "user")
    private List<Seller_Inquiry> sellerInquiries; // 판매자 문의들

//    @OneToMany(mappedBy = "user")

}
