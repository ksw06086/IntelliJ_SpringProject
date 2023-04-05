package spring.mvc.mybatis.ch05.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import spring.mvc.mybatis.ch05.dto.User5;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository{

	private final SqlSessionTemplate sql;

	public List<User5> getUsers() {
		return sql.selectList("UserRepository5.getUsers");
	}

	public User5 getUser(int userId) {
		return sql.selectOne("UserRepository5.getUser",userId);
	}

	public int addUser(User5 user) {
		return sql.insert("UserRepository5.addUser",user);
	}

	public int updateUser(User5 user) {
		return sql.update("UserRepository5.updateUser",user);
	}

	public int deleteUser(int userId) {
		return sql.delete("UserRepository5.deleteUser",userId);
	}
}
