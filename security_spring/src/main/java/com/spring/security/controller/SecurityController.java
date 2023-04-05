package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String start(){
        return "index";
    }

    @GetMapping("home/homeMain")
    public String homeMain() {
        System.out.println("url => home/homeMain");

        return "home/homeMain";
    }

    @GetMapping("member/memberMain")
    public String memberMain() {
        System.out.println("url => member/memberMain");

        return "member/memberMain";
    }

    @GetMapping("manager/managerMain")
    public String managerMain() {
        System.out.println("url => manager/managerMain");

        return "manager/managerMain";
    }

    @GetMapping("admin/adminMain")
    public String adminMain() {
        System.out.println("url => admin/adminMain");

        return "admin/adminMain";
    }

    @GetMapping("/j_spring_security_logout")
    public String j_spring_security_logout() {
        System.out.println("url => /j_spring_security_logout");

        return "/index";
    }
}
