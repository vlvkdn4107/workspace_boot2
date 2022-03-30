package ch03;

public interface RemoteController {

	//구현된 것이 아무것도 없는 밑그림만 있는 기본 설계도
    //멤버 변수, 일반 메서드를 가질 수 없고, 오직 추상 메서드와 상수만을
	//멤버로 가질 수 있다

	//추상 클래스 보다 추상화가 더 높다
	//인터페이스 : 강제성이 있는 약속이다, 표준, 규칙
	
	//사용방법
	// class 키워드 대신에 interface라는 키워드를 사용한다.
	// class public 이나 default를 사용할수있다.
	
	//원형..
	public static final int SERIAL_NUMBER = 1000; //상수 입니다 (final)
	//메서드
	public abstract void turnOn();
	
	
	// 축약형 
	int SERIAL_NUMBER2 = 100; // 축약형 (public static final 생략 되어있다.)
	void turnOff(); // 축약형 (public abstract void 생략)
}
