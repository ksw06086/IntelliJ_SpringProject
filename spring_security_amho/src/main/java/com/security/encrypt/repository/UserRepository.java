package com.security.encrypt.repository;

import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository{
	private final SqlSessionTemplate sql;

	public int insertUser(Map<String, Object> map) {
		return sql.insert("UserRepository.insertUser", map);
	}

	public Map<String, Object> selectUser(String userid) {
		return sql.selectOne("UserRepository.selectUser", userid);
	}

}
