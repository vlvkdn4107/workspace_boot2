package ch09;

public class Wrapper {

	Integer integerNum1 = new Integer(100);  //박싱
	Integer integerNum2 = 200;               //자동박싱 new Integer(200)생략
	Number number1 = 10;					 //자동박싱 new Integer(10)생략
	
	int intNum1 = integerNum1.intValue();    //언박싱
	int intNum2 = integerNum2;				 //자동언박싱 num1.intValue()생략
	
	
}
