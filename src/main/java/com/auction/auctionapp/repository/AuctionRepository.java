package com.auction.auctionapp.repository;

import com.auction.auctionapp.domain.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
