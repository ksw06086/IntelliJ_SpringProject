package com.sunwo.member.controller;

import com.sunwo.member.dto.MemberDTO;
import com.sunwo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
// 객체를 사용하기 위해서는 의존성을 주입해야함
@RequiredArgsConstructor        // 객체 생성시 생성자를 뒤에 안넣어도 자동으로 해주는 것 / final이 붙은 필드만 생성자 주입시켜줌
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/index")
    public String indexForm(){
        return "index";
    }

    @GetMapping("/save")        // Get방식의 메소드
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")       // Post방식의 메소드
    public String save(@ModelAttribute MemberDTO memberDTO){    // jsp의 name과 DTO의 필드 이름이 똑같아야 함
        int saveResult = memberService.save(memberDTO);
        if(saveResult > 0){
            return "login";
        } else {
            return "save";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        boolean loginResult = memberService.login(memberDTO);
        if(loginResult){
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            return "main";
        } else {
            return "login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<MemberDTO> membetDTOList = memberService.findAll();
        model.addAttribute("memberList", membetDTOList);
        return "list";
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model){
        MemberDTO memberDTO = memberService.findById(id);
        model.addAttribute("member", memberDTO);
        return "detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        memberService.delete(id);
        return "redirect:/member/";
    }

    // 수정화면 요청
    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model){
        // 세션에 저장된 나의 이메일 가져오기
        String loginEmail = (String) session.getAttribute("loginEmail");
        MemberDTO memberDTO = memberService.findByMemberEmail(loginEmail);
        model.addAttribute("member", memberDTO);
        return "update";
    }

    // 수정처리
    @PostMapping("/update")
    public String update(@ModelAttribute MemberDTO memberDTO){
        // 세션에 저장된 나의 이메일 가져오기
        boolean updateResult = memberService.update(memberDTO);
        if(updateResult){
            return "redirect:/member?id=" + memberDTO.getId();
        } else {
            return "index";
        }
    }

    // 이메일 중복체크
    @PostMapping("/email-check")    // jsp 형태의 결과가 날라가지 않도록 해당형태의 값이 나가게 하기 위해 @ResponseBody, @ResponseEntity 입력
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail){
        System.out.println("memberEmail = " + memberEmail);
        String checkReuslt = memberService.emailCheck(memberEmail);
        return checkReuslt;
    }
}
