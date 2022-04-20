package Stream_Ex;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx03 {
	
	
		public static void main(String[] args) {
			 InputStream in = System.in; //키보드에 연결
			 InputStreamReader ir = new InputStreamReader(in); //추가해서 점진적으로 나아간다해서 게토레이터패턴 방식으로 in을 넣어주면 
			                                                   //65를 -->A로 부호화 해준다.
			                                                   //추가적인 기능...
			 //하지만 InputStreanReader 단점:  
			 
			 BufferedReader br = new BufferedReader(ir); // String 으로 받을수 있다.
			 
			 //통신에는 항상 인코딩,디코딩 이 들어간다 (버퍼가 달려있다)
			 try {
				 //"HEL" + "LLO(남은값)"  이렇게 처리가 되는게 Buffered이다 
				 String data = br.readLine();//String으로 넣어서 아무 글자나 다 받아드린다.
				 System.out.println(data);
				 
				} catch (Exception e) {
				System.out.println("예외 :" + e.getMessage());
			}
		}
	
	
	
	 
	
}
