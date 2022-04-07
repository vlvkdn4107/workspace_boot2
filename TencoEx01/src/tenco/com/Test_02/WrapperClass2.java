package tenco.com.Test_02;

public class WrapperClass2 {
	public static void main(String[] args) {
	String str = "100입니다";
	String str2 = "100.5";
	String str3 = "true";
	
	//예외처리
	try {
		int i = Integer.parseInt(str);//문자열 100을 정수값으로 변경을 해줘!	
		System.out.println("문자열 int값 변환 : " + str);
	} catch (Exception e) {
		System.out.println("오류!!");
	}
	
	
	try {
		double d = Double.parseDouble(str2);
		System.out.println("문자열 double 값 변환 : " + str2);
	} catch (Exception e) {
		System.out.println("오류!!");
	}
	
	
	try {
		boolean bool = Boolean.parseBoolean(str3);
		System.out.println("문자열 boolean값 변환 : " + str3);
	} catch (Exception e) {
		System.out.println("오류!!");
	}
	
	
	
	
	
	
}
}
