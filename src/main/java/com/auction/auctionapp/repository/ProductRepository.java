package com.auction.auctionapp.repository;

import com.auction.auctionapp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
    List<Product> findByNameContainingIgnoreCase(String keyword);
    List<Product> findAllByUserUserId(String userId);

}
