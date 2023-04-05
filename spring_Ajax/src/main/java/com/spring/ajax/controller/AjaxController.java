package com.spring.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {
    @RequestMapping("/simple")
    public String simple(){
        System.out.println("url ===> simple");

        return "ch01_basic/simple";
    }

    // Main 페이지
    @RequestMapping("/responseNews")
    public String responseNews(){
        System.out.println("url ===> responseNews");

        return "ch02_news/responseNews";
    }

    /// ajax를 활용한 callback 함수 사용 용도
    // news
    @RequestMapping("news1")
    public String news1(){
        System.out.println("url ===> news1");

        return "ch02_news/news1";
    }

    // news
    @RequestMapping("news2")
    public String news2(){
        System.out.println("url ===> news2");

        return "ch02_news/news2";
    }

    // news
    @RequestMapping("news3")
    public String news3(){
        System.out.println("url ===> news3");

        return "ch02_news/news3";
    }

    // Book
    @RequestMapping("responseBook")
    public String responseBook() throws Exception{  // Main Page

        return "ch03_book/responseBook";
    }

    @RequestMapping("bookInfo")
    public String bookInfo() throws Exception{      // CallBack Method

        return "ch03_book/bookInfo";
    }

    // search-----------------------------------
    @RequestMapping("responseSearch")
    public String responseSearch() {

        return "ch04_search/responseSearch";
    }

    @RequestMapping("search_next")
    public String ajaxSearch_sub() {

        return "ch04_search/search_next";
    }
}
