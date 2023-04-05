package com.spring.ajax.controller;

import com.spring.ajax.dto.ProductDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonRestController {
    /*
     * 뷰를 리턴하는 것이 아닌 json을 리턴
     * @RestController : ajax 처리 전용 컨트롤러(빽그라운드에서 실행되며, 스프링 4.0이상부터 사용가능)
     * @RestController를 사용하면 @ResponseBody를 빼도 된다.
     */
    @RequestMapping("product")
    public ProductDTO product() throws Exception {
        System.out.println("url : product 호출중");

        return new ProductDTO("노트북", 1300000); // {"name" : "노트북", "price" : "13000000"}
    }
}
