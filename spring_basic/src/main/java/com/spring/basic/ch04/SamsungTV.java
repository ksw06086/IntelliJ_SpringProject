package com.spring.basic.ch04;

import lombok.Data;

@Data
public class SamsungTV implements TV{
	
	// 멤버변수
	private SonySpeaker speaker;
	private int price;
	private String brand;
	
	// 기본생성자
	public SamsungTV() {
		System.out.println("=== SamsungTV() 기본 생성자");
	}
	
	// 매개변수 생성자
	// xml에서 값을 주입 -> 매개변수 -> 멤버변수
	// 면접
	// 의존성 주입(DI : Dependency Injection) - 생성자 Injection
	// speaker : 객체의 주소 정보 전달 : SonySpeaker 객체를 매개변수로 받아서, 멤버변수로 전달한다.
	/*
	 * 내가 매개변수로 값을 전달받기를 바랄 때 외부로부터 전달받는 것
	 * 생성자 Injection
	 * setter Injection
	 */
	public SamsungTV(SonySpeaker speaker, int price, String brand) {
		System.out.println("=== SamsungTV() 매개변수 생성자");
		this.speaker = speaker;
		this.brand = brand;
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("전원을 켭니다.");
		System.out.println("브랜드 " + brand + "가격 " + price);
	}

	@Override
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}

	@Override
	public void volumeDown() {
		// System.out.println("소리를 높입니다.");
		// 매개변수를 통해서 주소값을 전달받았으므로 객체생성할 필요가 없다.
		speaker.volumeDown();
	}

	@Override
	public void volumeUp() {
		// System.out.println("소리를 내립니다.");
		speaker.volumeUp();
	}

}
