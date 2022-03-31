package ch12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyException {

	String fileName;

	public MyException(String fileName) {
		this.fileName = fileName;
	}

	// throws란?? 던지기 (사용하는 사람이(개발자가) 직접 예외 처리를 해라고 지시함)
	public String readFile() throws IOException {// FileInputStream는 반드시 예외 처리해야되지만 throws를 쓰면 다른사람한테 던진다(알아서 예외를 처리해라)

		FileInputStream fis = new FileInputStream(this.fileName);
		Properties properties = new Properties();
		properties.load(fis);// 스팀이라는 빨대로 연결후 properties로 읽겠다.
		String dbType = properties.getProperty("DBTYPE"); // a.txt DBTYPE(키) = MYSQL(벨류)

		return dbType;
	}

	public static void main(String[] args) {

		String dbType = null;
		MyException my = new MyException("b.txt");
		
		try {
			dbType = my.readFile();//빨간줄이 나오는 이유는 입출 오류라서 트라이 캐취문을 써줘야한다
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("예외가 발생해서 파일 로그 저장");
			
		}
		System.out.println("결과값 :" + dbType);
	}// end of main

}
