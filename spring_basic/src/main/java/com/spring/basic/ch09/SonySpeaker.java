package com.spring.basic.ch09;

import org.springframework.stereotype.Component;

@Component("sony9")
public class SonySpeaker implements Speaker{
	
	// 기본생성자
	public SonySpeaker() {
		System.out.println("==> SonySpeaker() 기본객체 생성");
	}

	@Override
	public void volumeUp() {
		System.out.println("==> SonySpeaker() 소리를 올립니다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("==> SonySpeaker() 소리를 내립니다.");
	}
}
