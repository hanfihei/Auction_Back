package com.auction.auctionapp.service;


import com.auction.auctionapp.domain.Product;
import com.auction.auctionapp.dto.ProductEntryDTO;

import java.util.List;

public interface ProductService {

    void productEntry(ProductEntryDTO dto, String userId);
    List<Product> searchProducts(String keyword);

    List<Product> findAllByUserId(String l);
}