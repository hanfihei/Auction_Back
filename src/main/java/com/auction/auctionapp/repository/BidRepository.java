package com.auction.auctionapp.repository;

import com.auction.auctionapp.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
