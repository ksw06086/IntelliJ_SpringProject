package spring.mvc.mybatis.ch06.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import spring.mvc.mybatis.ch06.dto.User6;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository{

	private final SqlSessionTemplate sql;

	public List<User6> getUsers() {
		return sql.selectList("UserRepository6.getUsers");
	}

	public User6 getUser(int userId) {
		return sql.selectOne("UserRepository6.getUser",userId);
	}

	public int addUser(User6 user) {
		return sql.insert("UserRepository6.addUser",user);
	}

	public int updateUser(User6 user) {
		return sql.update("UserRepository6.updateUser",user);
	}

	public int deleteUser(int userId) {
		return sql.delete("UserRepository6.deleteUser",userId);
	}

	
	
	

}
