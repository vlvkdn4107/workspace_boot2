package File_io_ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * 입력 스트림
 * 파일에서 한 바이트씩 데이터를 읽기  1
 */
public class MainTest1 {


	public static void main(String[] args) {
	
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("boot_a.txt");//파일에서 한바이트씩 읽어서 
			System.out.println((char)fis.read());// A 97
			System.out.println((char)fis.read());// B 98
			System.out.println((char)fis.read());// C 99
			System.out.println((char)fis.read());
			System.out.println(fis.read());// 아무것도 없으면 -1
			System.out.println((char)fis.read());// 아무것도 없으면 -1 형변환 해서 출력하면 아무것도 안뜬다
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이없습니다");
		} catch (IOException e) {
			System.out.println("입출력 오류");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
