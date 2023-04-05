package com.security.encrypt.controller;

import com.security.encrypt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final BCryptPasswordEncoder passwordEncoder; // 비밀번호 암호화 객체
    private final UserRepository userRepository;

    @GetMapping("/")
    public String home(HttpServletRequest req){
        System.out.println("경로 ==> home");

        return "home";
    }

    @PostMapping("/")
    public String posthome(){
        System.out.println("경로 ==> posthome");

        return "home";
    }

    // 로그인 페이지
    @GetMapping("/user/login.do")
    public String login() {
        System.out.println("경로 : login");

        return "user/login";
    }

    // 회원가입 페이지
    @GetMapping("/user/join.do")
    public String join() {
        System.out.println("경로 : join");

        return "user/join";
    }

    // 권한이 없는 사용자에게 안내 페이지 출력 - 403 에러
    @GetMapping("/user/denied")
    public String denied(HttpServletRequest req, Model model, Authentication auth) {
        System.out.println("경로 : denied");
        AccessDeniedException ade = (AccessDeniedException) req.getAttribute(WebAttributes.ACCESS_DENIED_403);

        model.addAttribute("errMsg", ade);
        return "user/denied";
    }

    // 관리자 페이지로 이동
    @GetMapping("/admin/")
    public String admin() {
        System.out.println("경로 : admin");
        return "admin/main";
    }

    // 회원가입 처리
    @PostMapping("/user/insertUser.do")
    public String insertUser(@RequestParam String userid, @RequestParam String passwd,
                             @RequestParam String name, @RequestParam String authority) {
        System.out.println("경로 : insertUser");
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        System.out.println("암호화 전의 비밀번호: " + passwd);

        // 비밀번호 암호화
        String encryptPassword = passwordEncoder.encode(passwd);
        map.put("passwd", encryptPassword);
        System.out.println("암호화 후의 비밀번호: " + encryptPassword);
        map.put("name", name);
        map.put("authority", authority);
        userRepository.insertUser(map);

        return "user/login";
    }

    // 로그아웃 처리
    @GetMapping("/user/logout.do")
    public String logout(HttpSession session) {
        session.invalidate();
        System.out.println("경로 : logout");

        // 홈으로 가거라 jsp가 아닌
        return "redirect:/";
    }
}
