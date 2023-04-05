package spring.mvc.mybatis.ch02.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.mybatis.ch02.dto.User2DTO;
import spring.mvc.mybatis.ch02.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class UserService {

	private final MemberRepository userRepository;
	public void getUserPostInfo1(HttpServletRequest req, Model model) {
		List<User2DTO> list = userRepository.getUserPostInfo1();
		
		model.addAttribute("list", list);
		
	}

	public void getUserPostInfo2(HttpServletRequest req, Model model) {
		List<User2DTO> list = userRepository.getUserPostInfo2();
		
		model.addAttribute("list", list);
		
	}

}
