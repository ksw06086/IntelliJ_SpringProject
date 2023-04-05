package com.spring.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Workmain {
	public static void main(String[] args) {
		AbstractApplicationContext factory
		= new GenericXmlApplicationContext("applicationContext_02.xml");
		
		Worker member = (Worker)factory.getBean("work");
		member.workingInfo();
		
		factory.close();
	}
}
