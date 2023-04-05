package com.spring.basic.ch01;

public class SamsungTV implements TV{
    
    public SamsungTV() {
        System.out.println("=== SamsungTV() 객체 생성");
    }

    @Override
    public void powerOn() {
        System.out.println("전원을 켭니다.");
    }

    @Override
    public void powerOff() {
        System.out.println("전원을 끕니다.");
    }

    @Override
    public void volumeUp() {
        System.out.println("소리를 높입니다.");
    }

    @Override
    public void volumeDown() {
        System.out.println("소리를 내립니다.");
    }
}
