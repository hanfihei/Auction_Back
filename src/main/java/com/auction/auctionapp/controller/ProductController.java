package com.auction.auctionapp.controller;

import com.auction.auctionapp.domain.Product;
import com.auction.auctionapp.domain.User;
import com.auction.auctionapp.dto.ProductEntryDTO;
import com.auction.auctionapp.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.auction.auctionapp.repository.UserRepository;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;


import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {


    private final ProductService productService;
    private final UserRepository userRepository;

    //상품등록
    @GetMapping("/entry")
    public String productEntry(HttpSession session, Model model) {

        //연결 후 주석 해제
        User loginUser = (User) session.getAttribute("loginUser");


        //사용자 x
        if (loginUser == null) {
            return "Login/login"; //임시로 로그인창이랑 연결
        }
        //성공시 연결
        return "Exhibit/ProductEntry";
    }


    @PostMapping("/entry")
    public String productEntryComplete(@ModelAttribute ProductEntryDTO dto,
                                       @RequestParam("image") MultipartFile imageFile,
                                       HttpSession session) {

        User loginUser = (User) session.getAttribute("loginUser");
        String userId = loginUser.getUserId();

        String uploadDir = "C:/upload/images";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        try {
            String fileName = imageFile.getOriginalFilename();
            File dest = new File(uploadDir + "/" + fileName);
            imageFile.transferTo(dest);
            dto.setProductImage("/images/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return "error-page"; // 실패 시 보여줄 페이지
        }

        productService.productEntry(dto, userId);
        return "redirect:/api/product/entry";
    }


    //상품관리
    @GetMapping("/management")
    public String productManagement(Model model) {
        List<Product> products = productService.findAllByUserId("1"); // 예: 현재 로그인된 유저 ID
        model.addAttribute("products", products);
        return "Exhibit/ProductManagement";
    }
}

