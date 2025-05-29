package com.auction.auctionapp.controller;

import com.auction.auctionapp.domain.User;
import com.auction.auctionapp.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// 회원가입과 로그인 컨트롤러
@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 회원가입 폼 페이지
    @GetMapping("/join")
    public String showJoin() {
        return "Login/join";  // ✅ 정상 경로
    }

    // 로그인 폼 페이지
    @GetMapping("/login")
    public String showLogin() {
        return "Login/login";  // ✅ 오타 수정: . 대신 /, ogin → login
    }

    // 회원가입 처리 POST 요청
    @PostMapping("/join")
    public String registerCustomer(@ModelAttribute User user, Model model) {
        Optional<User> existingUser = userRepository.findByUserId(user.getUserId());
        if (existingUser.isPresent()) {
            model.addAttribute("error", "이미 사용 중인 아이디입니다.");
            return "Login/join";  // ✅ 정상 경로
        }
        userRepository.save(user);
        return "Login/joinSuccess";  // ✅ 정상 경로
    }

    // 회원가입 성공 페이지
    @GetMapping("/joinSuccess")
    public String showJoinSuccess() {
        return "Login/joinSuccess";  // ✅ 정상 경로
    }

    // 로그인 처리
    @PostMapping("/login")
    public String doLogin(@RequestParam String id,
                          @RequestParam String password,
                          Model model,
                          HttpSession session) {

        Optional<User> user = userRepository.findByUserIdAndPassword(id, password);

        if (user.isPresent()) {
            session.setAttribute("loginUser", user.get());
            model.addAttribute("nickname", user.get().getNickname());
            return "Login/loginSuccess";  // ✅ 정상 경로
        } else {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "Login/login";  // ✅ 정상 경로
        }
    }
}
