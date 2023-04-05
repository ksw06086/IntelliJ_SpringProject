package com.spring.aop.anotation;

//pom.xml에서 aspectj 라이브러리를 등록했으므로 사용가능
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// 횡단관심 클래스
@Aspect
public class LogAop {
	
	// 참조메소드이며, 가로안에 아무것도 없고 참조되는 용도, 단순히 포인트컷을 식별하는 이름으로만 사용
	// 참조메소드는 메소드 몸체가 비엉ㅆ는, 즉 구현로직이 없는 메소드이다.
	// 따라서 어떤 기능처리를 목적으로 하지 않는다. 단순히 포인트컷을 식별하는 식별 용이다.
	@Pointcut("execution(* com.spring.aop.anotation.*.*())")
	private void allpointCut() {}
	
	@Around("allpointCut()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		// 핵심 관심 클래스.메소드 정보 - Member.getMemberInfo()
		// getSignature() : 클라이언트가 호출한 메소드의 시그니처(리턴타입, 이름, 매개변수) 정보가 저장된 객체 리턴
		String signatureStr = joinpoint.getSignature().toShortString();
		
		// 공통기능(횡단관심)
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
