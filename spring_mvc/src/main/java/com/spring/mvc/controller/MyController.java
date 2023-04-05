package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    /*
    * 1. 컨트롤러의 클래스 제작
    *
    * (1) 프로세스
    * 최초 클라이언트로부터 요청이 들어왔을 때 DispatcherServlet(web.xml)을 통해 컨트롤러로 진입
    * 컨트롤러는 요청에 대한 작업을 처리한 후, 뷰쪽으로 데이터를 전달한다.
    * web.xml -> DispatcherServlet -> servlet-context.xml(component-scan)
    *                              -> @Controller -> @Service -> @Repository
    *                              -> servlet-context.xml(ViewResolver) -> view(경로 + jsp명 + .jsp)
    *
    * (2) 컨트롤러 클래스 제작 순서
    * ㄱ. @Controller를 이용한 클래스 생성
    * ㄴ. @GetMapping, @PostMapping을 이용한 요청경로 지정
    * ㄷ. 서비스 호출
    * ㄹ. 뷰이름 리턴
    *
    * 2. 서비스 클래스 제작
    *    클라이언트의 요청처리 메소드 구현(비즈니스로직 구현)
    *
    * 3. 뷰에 데이터를 전달
    *    서비스에서 로직을 수행한 후 뷰 페이지로 반환한다.
    *    이 때 뷰에서 사용하게 될 데이터를 객체로 전달(Model1)할 수 있다.
    *    -> JSP에서 EL태그 - ${}로 값을 전달받는다.
    *
    *    방법1. Model 클래스를 이용한 데이터 전달
    *    방법2. ModelAndView 클래스를 이용한 데이터 전달
    * */

    @GetMapping("/content")
    public String content(Model model){
        System.out.println("model = " + model);

        model.addAttribute("id", "park");
        model.addAttribute("pwd", "1234");
        model.addAttribute("address", "대한민국");
        model.addAttribute("travel", "집");

        return "content";
    }

    // 방법2. ModelAndView 클래스를 이용한 데이터 전달
    @GetMapping("/student")
    public ModelAndView student() {
        System.out.println("student");
        ModelAndView mv = new ModelAndView();

        // 뷰쪽으로 데이터를 넘기기 위해 모델 객체에 데이터를 설정
        // mv.addObject("key", "value")
        mv.addObject("stdno", "19880000");
        mv.addObject("stdname", "대한민국만세");
        mv.addObject("major", "computer");
        mv.addObject("email", "집@gkgkgk.com");

        // 뷰이름 설정
        mv.setViewName("student");

        return mv;
    }
}
