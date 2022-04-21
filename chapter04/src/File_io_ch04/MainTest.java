package File_io_ch04;

import java.io.FileWriter;

/**
 * 
 * @author ITPS 문자 단위 출력 스트림 파일에 문자 쓰기 1.
 */
public class MainTest {

	public static void main(String[] args) {

		try (FileWriter fw = new FileWriter("write_1.txt")) {
			
			fw.write('A');//문자 A 출력
			char buf[] = {'B', 'C', 'D', 'E', 'F', 'G'};//배열 이용
			fw.write(buf);
			
			fw.write("\t안녕하세요 ~ 가나다라마");// String  (이스케이프문자 활용해서 사용\t)
			fw.write(buf,1 , 2); // CD 
			fw.write("65");
			fw.write("/");			
			fw.write(65);//자동으로 부호화해서 문자 A가 찍히게 된다.
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
