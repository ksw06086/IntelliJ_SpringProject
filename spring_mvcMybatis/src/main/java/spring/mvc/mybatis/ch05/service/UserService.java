package spring.mvc.mybatis.ch05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import spring.mvc.mybatis.ch05.dto.User5;
import spring.mvc.mybatis.ch05.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public void getUsers(HttpServletRequest req, Model model) {
		List<User5> user = userRepository.getUsers();
		model.addAttribute("user", user);
	}

	public void getUser(HttpServletRequest req, Model model) {
		User5 user = userRepository.getUser(1);
		model.addAttribute("user", user);
	}

	public void addUser(HttpServletRequest req, Model model) {
		int insertCnt = userRepository.addUser(new User5(6, "mama", java.sql.Date.valueOf("2019-11-11")));
		model.addAttribute("icnt", insertCnt);
		
		List<User5> user = userRepository.getUsers();
		model.addAttribute("user", user);
	}

	public void updateUser(HttpServletRequest req, Model model) {
		int updateCnt = userRepository.updateUser(new User5(6, "돼지", java.sql.Date.valueOf("2018-10-03")));
		model.addAttribute("icnt", updateCnt);
		
		List<User5> user = userRepository.getUsers();
		model.addAttribute("user", user);
	}

	public void deleteUser(HttpServletRequest req, Model model) {
		int deleteCnt = userRepository.deleteUser(6);
		model.addAttribute("icnt", deleteCnt);
		
		List<User5> user = userRepository.getUsers();
		model.addAttribute("user", user);
	}

}
