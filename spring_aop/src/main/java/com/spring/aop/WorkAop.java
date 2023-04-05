package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class WorkAop {
	public Object workingAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		// 핵심 관심 클래스.메소드 정보 - Member.getMemberInfo()
		String signatureStr = joinpoint.getSignature().toShortString();
		
		// 공통기능(횡단관심)
		System.out.println("둘재 마마마마");
		System.out.println(signatureStr + " is start!!");
		long st = System.currentTimeMillis(); // 시작시간
		
		// 핵심단심 호출
		try {
			Object obj = joinpoint.proceed(); // Member.getMemberInfo();
			return obj;	
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is end!!");
			System.out.println(signatureStr + " 경과시간 : " + (et - st));
		}
	}
}
