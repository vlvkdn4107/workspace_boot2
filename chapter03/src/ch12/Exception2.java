package ch12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Exception2 {

	public static void main(String[] args) {
		
		FileInputStream fis;
		try {
			//예외가 발생 할수 있는 코드
		fis = new FileInputStream("a.txt");
//			return;
		} catch (FileNotFoundException e) {
//			e.printStackTrace();
			//예외를 어떻게 처리 해야 하는지 작성하는 부분
			System.out.println("파일이 없습니다.");//stram?? 에 빨대를 연결시켜서 오류를 없앰?????
		}finally {
			
			//심지어 return 키워드를 만나도 실행되는 영역 입니다.
			System.out.println("반드시 실행되는 영역입니다.");
		}
		System.out.println("코드가 실행이 되나요??");
	}

}
