package ch04;

public interface RemoteController {
	
	//인터페이스라서 축약형을 쓴다 
       int SERIAL_NUBER = 1000; //(public static final 생략 되어있다.)
	   int SERIAL_NUBER2 = 100; //(public static final 생략 되어있다.)
	   void turnOn(); // 축약형 (public abstract void 생략)
	   void turnOff(); // 축약형 (public abstract void 생략)
	   
	
	
}
