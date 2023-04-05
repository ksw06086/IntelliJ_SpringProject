package spring.mvc.mybatis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.mvc.mybatis.ch01.dto.UserDTO;
import spring.mvc.mybatis.ch01.service.UserService1;
import spring.mvc.mybatis.ch02.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService1 service1;
    private final UserService service2;
    private final spring.mvc.mybatis.ch03.service.UserService service3;
    private final spring.mvc.mybatis.ch04.service.UserService service4;
    private final spring.mvc.mybatis.ch05.service.UserService service5;
    private final spring.mvc.mybatis.ch06.service.UserService service6;

    @GetMapping("/userAddressInfo1")
    public String userAddressInfo1(Model model){
        System.out.println("model = " + model);
        List<UserDTO> userDTOList = service1.addressInfo1();
        model.addAttribute("list",userDTOList);

        return "member/userAddressInfo";
    }

    @GetMapping("/userPostInfo1")
    public String userPostInfo1(HttpServletRequest req, Model model) {
        service2.getUserPostInfo1(req, model);

        return "member/userPostInfo";
    }

    // ch02 1 : 다
    @GetMapping("/userPostInfo2")
    public String userPostInfo2(HttpServletRequest req, Model model) {
        service2.getUserPostInfo2(req, model);

        return "member/userPostInfo";
    }

    @GetMapping("/getSearch1")
    public String getSearch1(HttpServletRequest req, Model model) {
        service3.getSearch1(model);

        return "member/getSearch";
    }

    @GetMapping("/getSearch2")
    public String getSearch2(HttpServletRequest req, Model model) {
        service3.getSearch2(model);

        return "member/getSearch";
    }

    @GetMapping("/getSearch3")
    public String getSearch3(HttpServletRequest req, Model model) {
        service3.getSearch3(model);

        return "member/getSearch";
    }

    @GetMapping("/updateUser")
    public String updateUser(HttpServletRequest req, Model model) {
        service3.updateUser(model);

        return "member/updateUser";
    }

    @GetMapping("/getUserSearchInfo")
    public String getUserSearchInfo(HttpServletRequest req, Model model) {
        service3.getUserSearchInfo(model);

        return "member/getUserSearchInfo";
    }

    // ch04. 배열, List
    @GetMapping("/getUserInfo1")
    public String getUserInfo1(HttpServletRequest req, Model model) {
        service4.getUserInfo1(model);

        return "array/array1";
    }

    @GetMapping("/getUserInfo2")
    public String getUserInfo2(HttpServletRequest req, Model model) {
        service4.getUserInfo2(req, model);

        return "array/array2";
    }

    @GetMapping("/getUserInfo3")
    public String getUserInfo3(HttpServletRequest req, Model model) {
        service4.getUserInfo3(req, model);

        return "array/array3";
    }

    @GetMapping("/getUsers")
    public String getUsers(HttpServletRequest req, Model model) {
        service5.getUsers(req, model);

        return "user/userList";
    }

    @GetMapping("/getUser")
    public String getUser(HttpServletRequest req, Model model) {
        service5.getUser(req, model);

        return "user/user";
    }

    @GetMapping("/addUser")
    public String addUser(HttpServletRequest req, Model model) {
        service5.addUser(req, model);

        return "user/addUser";
    }

    @GetMapping("/updateUser1")
    public String updateUser1(HttpServletRequest req, Model model) {
        service5.updateUser(req, model);

        return "user/addUser";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(HttpServletRequest req, Model model) {
        service5.deleteUser(req, model);

        return "user/addUser";
    }

    // ch06. 어노테이션을 이용한 CRUD
    @GetMapping("/ch6_getUsers")
    public String ch6_getUsers(HttpServletRequest req, Model model) {
        service6.getUsers(req, model);

        return "user/userList";
    }

    @GetMapping("/ch6_getUser")
    public String ch6_getUser(HttpServletRequest req, Model model) {
        service6.getUser(req, model);

        return "user/user";
    }

    @GetMapping("/ch6_addUser")
    public String ch6_addUser(HttpServletRequest req, Model model) {
        service6.addUser(req, model);

        return "user/addUser";
    }

    @GetMapping("/ch6_updateUser1")
    public String ch6_updateUser1(HttpServletRequest req, Model model) {
        service6.updateUser(req, model);

        return "user/addUser";
    }

    @GetMapping("/ch6_deleteUser")
    public String ch6_deleteUser(HttpServletRequest req, Model model) {
        service6.deleteUser(req, model);

        return "user/addUser";
    }

}
