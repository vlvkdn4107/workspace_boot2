package File_io_ch03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 
 * @author ITPS
 * 바이트 단위 출력
 * byte[] 배열 A-Z까지 넣고
 * 한꺼번에 파일에 쓰기  2
 */

//문제 output이라는 D-X 까지만 파일에 쓰기
public class MainTest3 {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileOutputStream fos = new FileOutputStream("output_c.txt",true);
		
		try(fos){
			byte[] bs = new byte[26];
			byte data = 65;//D
			//배열 A-Z까지 데이터를 담는다
			while(true) {			
				fos.write(bs, data, 22);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(">>>출력 처리가 끝 <<<");

	}

}
