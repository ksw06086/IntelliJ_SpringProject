package spring.mvc.mybatis.ch03.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import spring.mvc.mybatis.ch03.dto.Post3;
import spring.mvc.mybatis.ch03.dto.Search3;
import spring.mvc.mybatis.ch03.dto.User3;
import spring.mvc.mybatis.ch03.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

	private final UserRepository userRepository;

	public void getSearch1(Model model) {
		Search3 search = new Search3();
		search.setUserName("join");
		
		Post3 post = new Post3();
		post.setTitle("평화");
		post.setContent(""); // isEmpty()
		
		search.setPost(post);
		
		List<User3> list = userRepository.getSearch1(search);
		model.addAttribute("list", list);
	}

	public void getSearch2(Model model) {
		Search3 search = new Search3();
		search.setUserName("join");
		
		Post3 post = new Post3();
		post.setTitle(null);
		post.setContent("연결"); // isEmpty()
		
		search.setPost(post);
		
		List<User3> list = userRepository.getSearch2(search);
		model.addAttribute("list", list);
		
	}

	public void getSearch3(Model model) {
		Search3 search = new Search3();
		search.setUserName(null);
		
		Post3 post = new Post3();
		post.setTitle(null);
		post.setContent("연결"); // isEmpty()
		
		search.setPost(post);
		
		List<User3> list = userRepository.getSearch3(search);
		model.addAttribute("list", list);
	}

	public void updateUser(Model model) {
		Search3 search = new Search3();
		search.setUserName("ansony"); // 게시자
		
		Post3 post = new Post3(); // 게시글
		post.setTitle("파멸");
		post.setContent(null);
		search.setPost(post);

		User3 user = new User3(2, "ansony", null);
		
		int cnt = userRepository.updateUser(user);
		
		if(cnt != 0) {
			// ansony, 글제목 like "%파멸%"
			List<User3> list = userRepository.getSearch3(search);
			model.addAttribute("list", list);
		}
		
	}

	public void getUserSearchInfo(Model model) {
		User3 user3 = userRepository.getUserSearchInfo("join");
		model.addAttribute("user3", user3);
	}
	
}
