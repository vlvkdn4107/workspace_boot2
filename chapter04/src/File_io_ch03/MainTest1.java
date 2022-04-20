package File_io_ch03;

import java.io.FileOutputStream;

/**
 * 
 * @author ITPS
 * 바이트 단위 출력
 * 파일에 한 바이트씩 쓰기  1
 *
 */
public class MainTest1 {

	public static void main(String[] args) {
		//FileOutputStream은 파일이 없다면 자동으로 파일을 생성해준다.
		try(FileOutputStream fos = new FileOutputStream("output_a.txt",true)){//추가 or 생성  생성자에서 true를 하면 이어서 쓴다
			// 1 
			// 2
			// 3
			// 4
			// 5
			fos.write(65); //A 추가됨
			fos.write(66); //B 추가됨
			fos.write('C');
			fos.write('D');
			fos.write('E');
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(">>>출력 처리가 끝 <<<");

	}

}
