package com.spring.basic.ch09;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Component("sstv")
public class SamsungTV implements TV{
	
	// @Autowired : 주로 변수위에 설정하여 해당 타입의 객체를 찾아서 의존성 주입한다.
	// @Autowired 어노테이션을 사용하려면, 의존성 주입 대상이 되는 객체가 반드시 메모리에 올라가 있어야한다.
	// 멤버변수
	/*
	 * @Autowired private SonySpeaker sony;
	 * 
	 * @Autowired private AppleSpeaker apple;
	 */

	// @Resource는 객체의 이름을 이용해서 의존성 주입을 처리한다. => 자바 9 이후부터는 지원 안해준다고 함
	/* 사용하고 싶다면 이걸 추가해주면 됨 pom.xml에
	* <dependency>
		<groupId>javax.annotation</groupId>
		<artifactId>javax.annotation-api</artifactId>
		<version>1.3.1</version>
	  </dependency>
	*/
	// @Autowired + @Qualifier("sony9")
	// @Inject + @Named("sony9")

	@Inject
	@Named("sony9")
	private Speaker speaker;
	
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
	
	@Override
	public void powerOn() {
		System.out.println("전원을 켭니다.");
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
