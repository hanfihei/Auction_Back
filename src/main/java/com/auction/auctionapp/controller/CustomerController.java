package com.auction.auctionapp.controller;

import com.auction.auctionapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // 1:1 문의 등록
    @PostMapping("/inquiry")
    public String createInquiry(@RequestParam String userId,
                                @RequestParam String title,
                                @RequestParam String content) {
        customerService.createInquiry(userId, title, content);
        return "문의가 등록되었습니다.";
    }

    // FAQ 목록 조회
    @GetMapping("/faqs")
    public String viewFAQList() {
        customerService.viewFAQList();
        return "FAQ 목록 반환 완료";
    }

    // 공지사항 목록 조회
    @GetMapping("/notices")
    public String viewNoticeList() {
        customerService.viewNoticeList();
        return "공지사항 목록 반환 완료";
    }
}