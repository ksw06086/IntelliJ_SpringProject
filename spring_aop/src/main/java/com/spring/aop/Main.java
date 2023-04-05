package com.spring.aop;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext factory
                = new GenericXmlApplicationContext("applicationContext_01.xml");
        Member member = (Member)factory.getBean("member");
        member.getMemberInfo();

        factory.close();

    }
}
