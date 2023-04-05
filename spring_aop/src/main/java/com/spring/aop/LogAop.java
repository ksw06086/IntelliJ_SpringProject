package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
    public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
        // 핵심 관심 클래스.메소드 정보 - Member.getMemberInfo()
        String signatureStr = joinpoint.getSignature().toShortString();

        // 공통기능(횡단관심)
        System.out.println(signatureStr + " is Start!!");
        long st = System.currentTimeMillis();

        //  핵심관심 호출
        try {
            Object obj = joinpoint.proceed();   // Member.getMemberInfo();
            return obj;
        } finally {
            long et = System.currentTimeMillis();
            System.out.println(signatureStr + " is End!!");
            System.out.println(signatureStr + " 경과시간 : " + (et - st));
        }
    }
}
