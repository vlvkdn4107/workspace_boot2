package ch13;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class MyException {

	String fileName;
	
	public MyException(String fileName) {
		this.fileName = fileName;
	}
	
	public String readFile() throws IOException {
		FileInputStream fis = new FileInputStream(this.fileName);
		Properties properties = new Properties();
		properties.load(fis);
		String dbType = properties.getProperty("DBTYPE");//키값
		
		return dbType;
		
	}
	
	public static void main(String[] args) {
		 String dbType = null;
		 MyException my = new MyException("a.txt");
		 try {
			dbType = my.readFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("예외가 발생해서 파일 로그 저장");
		}
		 
		 System.out.println("결과값 : " + dbType);
		 
	}// end off main
	
	
}
