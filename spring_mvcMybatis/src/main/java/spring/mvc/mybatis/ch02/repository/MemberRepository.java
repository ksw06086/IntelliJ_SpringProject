package spring.mvc.mybatis.ch02.repository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import spring.mvc.mybatis.ch02.dto.User2DTO;

@Repository
@RequiredArgsConstructor
public class MemberRepository{
	private final SqlSessionTemplate sql;

	public List<User2DTO> getUserPostInfo1() {
		return sql.selectList("getUserPostInfo1");
	}

	public List<User2DTO> getUserPostInfo2() {
		return sql.selectList("getUserPostInfo2");
	}

}
