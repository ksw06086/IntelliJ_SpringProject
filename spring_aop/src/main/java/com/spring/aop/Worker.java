package com.spring.aop;

import lombok.Data;

@Data
public class Worker {
	private String name;
	private String part;
	private String msg;
	
	public void workingInfo() {
		System.out.println("===== 핵심관심.. 비즈니스 로직 =====");
		
		System.out.println("이름 : " + getName());
		System.out.println("부서 : " + getPart());
		System.out.println(getMsg());
	}
}
