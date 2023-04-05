package com.spring.basic.ch02;

public class LgTV implements TV{

	// 기본생성자
	public LgTV() {
		System.out.println("=== LgTV() 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("l전원을 켭니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("l전원을 끕니다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("l소리를 높입니다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("l소리를 내립니다.");
	}

}
