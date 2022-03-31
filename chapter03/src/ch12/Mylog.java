package ch12;

import java.util.logging.Logger;

class Student {
	String name;
	int grade;
}

public class Mylog {
	
	public static void main(String[] args) {
		  //로그 남겨 보기
		Logger logger = Logger.getLogger("MyLog"); //원시코드가 static이라서 new를 안쓰고 호출할수있다.
		
		Student student = null;
		
		try {
			student.name = "홍길동";	
		} catch (NullPointerException e) { //Exception 이거는 왜 오류가 뜨는거지??
			e.printStackTrace();
			System.out.println("==================");
			logger.warning("오류 확인 :" + e.toString());
		}
		
		System.out.println("여기코드 오류 확인");
		
		
	}
   
}
