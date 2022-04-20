package File_io_ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * 입력 스트림
 * 파일에서 한 바이트씩 데이터를 읽기  1
 * try- with-resources : try()문법 (오토 클로즈 제공)
 * 코드량도 줄어들고 실수로 try-catch를 안했을때를 방지할수있음
 */
public class MainTest2 {

	
	public static void main(String[] args) {
	
	//System.in//키보다
	System.out.println("시작 파일에서 데이터를 읽어서 화면에 출력");
//	FileInputStream fis = null; 
	int i;
	
	try(FileInputStream fis = new FileInputStream("boot_a.txt");) {
		while((i = fis.read()) != -1) { //문자가없으면 -1이기때문에
			System.out.println((char)i);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	try {
//		int i;
//		fis = new FileInputStream("boot_a.txt");
//		while((i = fis.read()) != -1) { //문자가없으면 -1이기때문에
//			System.out.println((char)i);
//		}
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}finally {
//		try {
//			fis.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	System.out.println("끝");

	} //end of main

}
