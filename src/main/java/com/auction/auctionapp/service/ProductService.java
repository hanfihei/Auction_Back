package com.auction.auctionapp.service;

import com.auction.auctionapp.domain.Product;
import com.auction.auctionapp.dto.DetailsPageDTO;
import com.auction.auctionapp.dto.ProductEntryDTO;
import com.auction.auctionapp.dto.ProductListDTO;
import com.auction.auctionapp.dto.PurchaseCompleteDTO;

import java.util.List;

public interface ProductService {

    void productEntry(ProductEntryDTO dto, String userId);

    List<Product> searchProducts(String keyword);

    List<Product> findAllByUserId(String userId);

    DetailsPageDTO getProductDetails(Long productId);

    PurchaseCompleteDTO getPurchaseComplete(Long productId);

    List<ProductListDTO> getProductList();
}
