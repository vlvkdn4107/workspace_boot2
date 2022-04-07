package tenco.com.Test_02;

public class WrapperClass1 {
   public static void main(String[] args) {
	 Integer num = new Integer(100);//박싱
	 Number n1 = 10;
	 
	 int n = num.intValue();//언박싱
	 System.out.println(n);
		System.out.println("============================");
		Integer num1 = 200; //클래스타입에 기본데이터를 넣어도 허용하는 이유는 자동 박싱되서 가능한거다. //자동박싱(autoBoxing)
		int num10 = num1;//자동 언박싱  (  num1.IntValue()  ) 
	 
	 
}
}
