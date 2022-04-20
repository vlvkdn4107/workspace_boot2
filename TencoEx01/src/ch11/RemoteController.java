package ch11;

public interface RemoteController {

	//원형
	public static final int SERIAL_NUMBER = 1000;
	public abstract void turnOn();
	//축약형
	int SERIAL_NUMBER2= 100; // static final 생략
	void turnOff();			 // abstract 생략
	
}
