package com.spring.basic.ch03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		// xml 파일 생성 : new > Spring Bean Configuration File
		
		// 1. IoC 컨테이너를 구동한다.
		// 1-1. TVUser 클래스가 스프링 설정파일을 로딩하여 IoC 컨테이너를 구동
		// 1-2. 스프일 설정파일에 <bean>으로 등록된 SamsungTV 객체 생성
		AbstractApplicationContext factory
		= new GenericXmlApplicationContext("applicationContext_03.xml");
		
		// 2. IoC 컨테이너로부터 필요한 객체를 요청(LookUp) 한다.
		TV tv = (TV)factory.getBean("sstv3");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		factory.close();
	}
}
