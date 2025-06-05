package com.auction.auctionapp.service.impl;

import com.auction.auctionapp.converter.ProductConverter;
import com.auction.auctionapp.domain.Product;
import com.auction.auctionapp.dto.DetailsPageDTO;
import com.auction.auctionapp.dto.ProductEntryDTO;
import com.auction.auctionapp.dto.ProductListDTO;
import com.auction.auctionapp.dto.PurchaseCompleteDTO;
import com.auction.auctionapp.repository.ProductRepository;
import com.auction.auctionapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public void productEntry(ProductEntryDTO dto, String userId) {
        Product product = productConverter.toEntity(dto, userId);
        product.setCreatedAt(LocalDateTime.now()); // 이렇게 수정
        productRepository.save(product);
        System.out.println("상품 등록 완료: " + product.getName() + ", 등록자 ID: " + userId);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<Product> findAllByUserId(String userId) {
        return productRepository.findAllByUserUserId(userId);
    }

    //구매자 상품 상세조회
    @Override
    public DetailsPageDTO getProductDetails(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        return DetailsPageDTO.builder()
                .productId(product.getProductId())
                .productName(product.getName())
                .productDescription(product.getDescription())
                .productImage(product.getImagePath())
                .productPrice(product.getProductPrice())
                .productStatus(product.getStatus().name())
                .build();
    }

    @Override
    public PurchaseCompleteDTO getPurchaseComplete(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));

        return PurchaseCompleteDTO.builder()
                .productImage(product.getImagePath())
                .productPrice(product.getProductPrice())
                .createdAt(product.getCreatedAt())
                .build();
    }

    //상품리스트
    public List<ProductListDTO> getProductList() {
        List<Product> products = productRepository.findAll(); // 필요에 따라 정렬 등 가능

        return products.stream()
                .map(product -> ProductListDTO.builder()
                        .productImage(product.getImagePath())
                        .categoryName(product.getCategory().getCategoryName()) // 연관관계 주의
                        .productName(product.getName())
                        .productPrice(product.getProductPrice())
                        .build()
                ).collect(Collectors.toList());
    }




}
