package File_io_ch04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author ITPS
 * BufferedWrite를 이용한 파일에 문자 쓰기
 * 
 */
public class MainTest2 {

	public static void main(String[] args) {
		
	String text = "File Write Test";
	String fileName = "result.txt";
	
	//버퍼는 자기 공간이 다 채워지면 자동으로 전달 한다.
	try {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));//보조 스트림 // 매개변수에 true를 넣으면 붙여넣기
		bw.write(text);// 아직 보내지 않음
		bw.flush();//강제적으로 넣는다(물이 흘러간다)  Buffered를 쓸떄는 .flush()를 써줘야한다
		
		bw.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
