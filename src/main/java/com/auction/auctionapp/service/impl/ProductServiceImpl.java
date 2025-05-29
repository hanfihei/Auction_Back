package com.auction.auctionapp.service.impl;

import com.auction.auctionapp.converter.ProductConverter;
import com.auction.auctionapp.domain.Product;
import com.auction.auctionapp.dto.ProductEntryDTO;
import com.auction.auctionapp.repository.ProductRepository;
import com.auction.auctionapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public void productEntry(ProductEntryDTO dto, String userId) {
        Product product = productConverter.toEntity(dto, userId);
        productRepository.save(product);
        System.out.println("상품 등록 완료: " + product.getName() + ", 등록자 ID: " + userId);
    }
    //상품검색기능
    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    public List<Product> findAllByUserId(String userId) {
        return productRepository.findAllByUserUserId(userId);
    }
}
