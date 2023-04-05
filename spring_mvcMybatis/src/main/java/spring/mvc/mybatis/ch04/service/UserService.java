package spring.mvc.mybatis.ch04.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import spring.mvc.mybatis.ch04.dto.Search4;
import spring.mvc.mybatis.ch04.dto.User4;
import spring.mvc.mybatis.ch04.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

	private final UserRepository userRepository;

	public void getUserInfo1(Model model) {
		Search4 search = new Search4();
		System.out.println("[getUsers-방법1]");
		
		// int[] userIds = new int[] {1,2}
		search.setUserIds(new int[] {1,2}); // userIds 변수에 배열로 userId인 1,2를 set
		List<User4> list = userRepository.getUserInfo1(search);
		model.addAttribute("list", list);
		
		System.out.println("[getUsers-방법2]");
		
		search.setUserIds(null);
		search.setUserNames(Arrays.asList("join"));
		
		List<User4> list1 = userRepository.getUserInfo1(search);
		model.addAttribute("list1", list1);
	}

	public void getUserInfo2(HttpServletRequest req, Model model) {
		List<User4> list = userRepository.getUserInfo2(new int[] {1,2});
		model.addAttribute("list", list);
	}

	public void getUserInfo3(HttpServletRequest req, Model model) {
		List<User4> list = userRepository.getUserInfo3(Arrays.asList("join"));
		model.addAttribute("list", list);
	}
	
	
	
}
