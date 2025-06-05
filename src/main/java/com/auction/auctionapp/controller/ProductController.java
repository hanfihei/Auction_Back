package com.auction.auctionapp.controller;

import com.auction.auctionapp.domain.User;
import com.auction.auctionapp.dto.DetailsPageDTO;
import com.auction.auctionapp.dto.ProductEntryDTO;
import com.auction.auctionapp.dto.ProductListDTO;
import com.auction.auctionapp.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.auction.auctionapp.repository.UserRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    private final UserRepository userRepository;

    // 상품 등록 페이지로 이동
    @GetMapping("/createProduct")
    public String productEntry(HttpSession session, Model model) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "Login/login";
        }
        return "Product/createProduct.";
    }

    // 상품 등록 처리
    @PostMapping("/createProduct")
    public String productEntryComplete(@ModelAttribute ProductEntryDTO dto,
                                       HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        String userId = loginUser.getUserId();

        String uploadDir = "C:/upload/images";

        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        try {
            // DTO에서 MultipartFile 꺼내기
            String fileName = dto.getImageFile().getOriginalFilename();
            File dest = new File(uploadDir + "/" + fileName);
            dto.getImageFile().transferTo(dest);
            dto.setProductImage("/images/" + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return "error-page";
        }

        productService.productEntry(dto, userId);
        return "redirect:/api/product/createProduct";
    }

    // 상품 관리 페이지
    /*@GetMapping("/management")
    public String productManagement(Model model) {
        List<Product> products = productService.findAllByUserId("1"); // 현재 로그인 유저 ID로 수정 예정
        model.addAttribute("products", products);
        return "Exhibit/ProductManagement";
    }*/

    // 구매자용 상품 상세 조회
    @GetMapping("/productDetailBuyer/{productId}")
    public String productDetailBuyer(@PathVariable Long productId, Model model) {
        DetailsPageDTO dto = productService.getProductDetails(productId);
        model.addAttribute("dto", dto);
        return "Product/productDetailBuyer";
    }

    @GetMapping("/productList")
    public String productList(Model model) {
        List<ProductListDTO> productList = productService.getProductList();
        model.addAttribute("productList", productList);
        return "Product/productList";
    }

}
