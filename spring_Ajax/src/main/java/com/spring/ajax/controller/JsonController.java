package com.spring.ajax.controller;

import com.spring.ajax.dto.ProductDTO;
import com.spring.ajax.dto.SearchDTO;
import com.spring.ajax.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class JsonController {
    // 주소값이 아닌 값을 넘길때 @RequestMapping를 추가한다.
    // pom.xml에 추가 : json 변환기(jackson-databind 필수, jackson-mapper-asl 옵션) 추가
    // mvnrepository.com에서 검색어 : jackson-databind
    // 만약 jackson-databind가 없거나, 스프링버전이나 자바설정 안한 경우 "HTTP Status 406 - Not Acceptable" 에러 발생
    /*
     * @RequestMapping("product") public @ResponseBody ProductVO product() throws
     * Exception { logger.info("url : product 호출중");
     *
     * return new ProductVO("노트북", 1300000); // {"name" : "노트북", "price" :
     * "13000000"} }
     */
    /*
     * @RequestBody : HTTP 요청의 body 내용을 자바객체로 매핑하는 역할
     * @ResponseBody : 주소가 아닌 값을 리턴할 때 @ResponseBody를 추가한다.
     * Json 데이터를 받을 때 @requestBody, 리턴타입은 @ResponseBody
     * 안드로이드랑 스프링이랑 연계할 때
     * pom.xml에 추가 : json 변환기(jackson-databind 필수, jackson-mapper-asl 옵션) 추가
     */

    @Autowired
    SearchService service;

    @RequestMapping("htmldata")
    public String htmldata() throws Exception {
        System.out.println("url : htmldata 호출중");

        return "ch05_JSON/ajax_htmldata";
    }

    @RequestMapping("htmldata_sub")
    public String htmldata_sub() throws Exception {
        System.out.println("url : htmldata_sub 호출중");

        return "ch05_JSON/ajax_htmldata_sub";
    }

    @RequestMapping("paramdata")
    public String paramdata() throws Exception {
        System.out.println("url : paramdata 호출중");

        return "ch05_JSON/ch02_ajax_paramdata";
    }

    @RequestMapping("paramdata_sub")
    public String paramdata_sub() throws Exception {
        System.out.println("url : paramdata_sub 호출중");

        return "ch05_JSON/ch02_ajax_paramdata_sub";
    }

    @RequestMapping("paramdata2")
    public String paramdata2() throws Exception {
        System.out.println("url : paramdata2 호출중");

        return "ch05_JSON/ch03_ajax_paramdata2";
    }

    @RequestMapping("state")
    public @ResponseBody List<ProductDTO> state(@RequestParam String data) throws Exception {
        System.out.println("url : state 호출중");
        List<ProductDTO> list = new ArrayList<ProductDTO>();

        if(data.equals("0")) {
            list.add(new ProductDTO("상품매입", 20000));
            list.add(new ProductDTO("상품판매", 20000));
            list.add(new ProductDTO("비품판매", 20000));
            list.add(new ProductDTO("차량주유", 20000));
            list.add(new ProductDTO("거래처접대", 20000));
            list.add(new ProductDTO("소모품사용", 20000));
        } else if(data.equals("1")) {
            list.add(new ProductDTO("현금지급", 20000));
            list.add(new ProductDTO("외상허용", 20000));
            list.add(new ProductDTO("어음지급", 20000));
            list.add(new ProductDTO("신용카드 지불", 20000));
            list.add(new ProductDTO("계좌이체", 20000));
        } else {
            list.add(new ProductDTO("내용이 없습니다.", 20000));
        }

        return list;
    }

    @RequestMapping("statelist")
    public @ResponseBody Integer statelist(@RequestParam String datalist) throws Exception {
        System.out.println("url : statelist 호출중");
        List<ProductDTO> list = new ArrayList<>();

        switch (datalist) {
            case "상품매입" :
                return 20000;
            case "비품판매" :
                return 10000;
            case "차량주유" :
                return 30000;
            case "거래처접대" :
                return 40000;
            case "소모품사용" :
                return 50000;
            case "현금지급" :
                return 60000;
            case "외상허용" :
                return 70000;
            case "어음지급" :
                return 80000;
            case "신용카드 지불" :
                return 90000;
            case "계좌이체" :
                return 100000;
            case "내용이 없습니다." :
                return 20000;
            default:
                return 0;
        }
    }

    @RequestMapping("jsondata")
    public String jsondata() throws Exception {
        System.out.println("url : jsondata 호출중");

        return "ch05_JSON/ch04_ajax_jsondata";
    }

    @RequestMapping("jsondata2")
    public String jsondata2() throws Exception {
        System.out.println("url : jsondata2 호출중");

        return "ch05_JSON/ch05_ajax_jsondata2";
    }

    @RequestMapping("jsondata2_sub")
    public @ResponseBody String jsondata2_sub(@RequestBody Map<String, Object> map) throws Exception {
        System.out.println("url : jsondata2_sub 호출중");

        String id = map.get("id").toString();
        String name = map.get("name").toString();

        return id + " " + name;
    }

    @RequestMapping("paramdata3")
    public String paramdata3() throws Exception {
        System.out.println("url : paramdata3 호출중");

        return "ch05_JSON/ch06_ajax_paramdata3";
    }

    @RequestMapping("paramdata3_sub")
    public @ResponseBody String paramdata3_sub(@RequestParam String data) {
        System.out.println("url : paramdata3_sub 호출중");

        data += ": im a good day";

        return data;
    }

    @RequestMapping("xmldata")
    public String xmldata() throws Exception {
        System.out.println("url : xmldata 호출중");

        return "ch05_JSON/ch07_ajax_xmldata";
    }

    // 검색
    @RequestMapping("search")
    public String search() throws Exception {
        System.out.println("url : search 호출중");

        return "ch06_JQuery/search";
    }

    @RequestMapping("search_sub")
    public String search_sub(@RequestParam String keyword, Model model) throws Exception {
        System.out.println("url : search_sub 호출중");
        List<SearchDTO> list = service.searchList(keyword);

        model.addAttribute("list", list);
        System.out.println("keyword : " + keyword);
        return "ch06_JQuery/search_sub";
    }

}
