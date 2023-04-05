package com.spring.aop;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pwd;
	private String name;
	private String hobby;

	public void getMemberInfo() {
		System.out.println("====== 핵심관심.. 비즈니스 로직 ======");
		
		System.out.println("id : " + getId());
		System.out.println("pwd : " + getPwd());
		System.out.println("name : " + getName());
		System.out.println("hobby : " + getHobby());
	}
}
