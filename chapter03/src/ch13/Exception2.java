package ch13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception2 {

	public static void main(String[] args) {
		
		
		FileInputStream fis;
		
		try {
			fis = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			System.out.println("파일 없음");
		}finally {
			System.out.println("반드시 실행");
		}
		System.out.println("코드가 실행이 되나요?");
		
		
		
	

	}

}
