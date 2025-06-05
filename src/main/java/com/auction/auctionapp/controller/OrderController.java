package com.auction.auctionapp.controller;

import com.auction.auctionapp.dto.PurchaseCompleteDTO;
import com.auction.auctionapp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final ProductService productService;

    @GetMapping("/{productId}/purchaseComplete")
    public String purchaseComplete(@PathVariable("productId") long productId, Model model) {

        PurchaseCompleteDTO dto = productService.getPurchaseComplete(productId);

        model.addAttribute("dto", dto);

        return "purchaseComplete";
    }



}
