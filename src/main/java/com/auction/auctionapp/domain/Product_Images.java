package com.auction.auctionapp.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Product_Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "product_id", nullable = false)
    //private Product product;

    



}
