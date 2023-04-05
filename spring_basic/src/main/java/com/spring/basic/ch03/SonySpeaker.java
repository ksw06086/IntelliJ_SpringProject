package com.spring.basic.ch03;

public class SonySpeaker {
	
	// 기본생성자
	public SonySpeaker() {
		System.out.println("==> SonySpeaker() 기본객체 생성");
	}

	public void volumeUp() {
		System.out.println("==> SonySpeaker() 소리를 올립니다.");
	}
	
	public void volumeDown() {
		System.out.println("==> SonySpeaker() 소리를 내립니다.");
	}
}
