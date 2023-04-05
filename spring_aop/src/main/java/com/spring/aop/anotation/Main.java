package com.spring.aop.anotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext factory
		= new GenericXmlApplicationContext("applicationContext_03.xml");

		Member member = (Member)factory.getBean("member");
		member.getMemberInfo();

		Worker worker = (Worker)factory.getBean("work");
		worker.workingInfo();
		
		factory.close();
	}
}
