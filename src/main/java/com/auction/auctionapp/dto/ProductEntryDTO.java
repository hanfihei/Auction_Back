package com.auction.auctionapp.dto;

import com.auction.auctionapp.domain.Category;
import com.auction.auctionapp.domain.UserInterestCategory;
import com.auction.auctionapp.domain.enums.ProductCondition;
import com.auction.auctionapp.domain.enums.ProductStatus;
import lombok.*;

import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductEntryDTO {


    private Long productId;

    private String productName;

    private String productDescription;

    private int productPrice;

    private String productImage;

    private ProductCondition productCondition;

    private Long categoryId;

    private ProductStatus productStatus;

    private LocalDate deadline;




}
