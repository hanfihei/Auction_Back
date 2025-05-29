package com.auction.auctionapp.controller;

import com.auction.auctionapp.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/auctions")
public class AuctionController {

    private final AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    // 경매 목록 조회
    @GetMapping
    public String getAuctionList() {
        // TODO: 경매 목록 로직
        return "경매 목록 반환";
    }

    // 경매 상세 조회
    @GetMapping("/{auctionId}")
    public String getAuctionDetail(@PathVariable Long auctionId) {
        // TODO: 상세 조회 로직
        return "경매 상세 정보 반환: ID = " + auctionId;
    }

    // 입찰하기
    @PostMapping("/{auctionId}/bid")
    public String placeBid(@PathVariable Long auctionId,
                           @RequestParam String bidderId,
                           @RequestParam int bidAmount) {
        auctionService.placeBid(auctionId, bidderId, bidAmount);
        return "입찰 완료";
    }

    // 출품하기 (상품 등록)
    @PostMapping("/register")
    public String registerAuction(@RequestParam Long productId,
                                  @RequestParam int startingPrice,
                                  @RequestParam String sellerId) {
        auctionService.registerAuction(productId, startingPrice, sellerId);
        return "경매 등록 완료";
    }
}