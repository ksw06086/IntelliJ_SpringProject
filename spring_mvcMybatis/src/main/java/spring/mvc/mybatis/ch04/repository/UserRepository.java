package spring.mvc.mybatis.ch04.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import spring.mvc.mybatis.ch04.dto.Search4;
import spring.mvc.mybatis.ch04.dto.User4;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository{

	private final SqlSessionTemplate sql;

	public List<User4> getUserInfo1(Search4 search) {
		return sql.selectList("UserRepository3.getUserInfo1", search);
	}

	public List<User4> getUserInfo2(int[] ids) {
		return sql.selectList("UserRepository3.getUserInfo2", ids);
	}

	public List<User4> getUserInfo3(List<String> names) {
		return sql.selectList("UserRepository3.getUserInfo3", names);
	}


	
	

}
