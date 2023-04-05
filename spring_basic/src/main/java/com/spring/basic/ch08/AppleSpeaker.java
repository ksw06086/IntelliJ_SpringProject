package com.spring.basic.ch08;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	
	// 기본생성자
	public AppleSpeaker() {
		System.out.println("==> AppleSpeaker() 기본객체 생성");
	}

	@Override
	public void volumeUp() {
		System.out.println("==> AppleSpeaker() 소리를 올립니다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("==> AppleSpeaker() 소리를 내립니다.");
	}
	
}
