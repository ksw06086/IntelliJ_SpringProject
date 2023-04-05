package spring.mvc.mybatis.ch03.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import spring.mvc.mybatis.ch03.dto.Search3;
import spring.mvc.mybatis.ch03.dto.User3;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository{

	private final SqlSessionTemplate sql;
	
	public List<User3> getSearch1(Search3 search) {
		return sql.selectList("UserRepository3.getSearch1", search);
	}

	public List<User3> getSearch2(Search3 search) {
		return sql.selectList("UserRepository3.getSearch2", search);
	}

	public List<User3> getSearch3(Search3 search) {
		return sql.selectList("UserRepository3.getSearch3", search);
	}

	public int updateUser(User3 user) {
		return sql.update("UserRepository3.updateUser", user);
	}

	public User3 getUserSearchInfo(String userName) {
		return sql.selectOne("UserRepository3.getUserSearchInfo", userName);
	}

}
