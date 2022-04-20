package Stream_Ex;

import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx02 {
	
	
		public static void main(String[] args) {
			 InputStream in = System.in; //키보드에 연결
			 InputStreamReader ir = new InputStreamReader(in); //추가해서 점진적으로 나아간다해서 게토레이터패턴 방식으로 in을 넣어주면 
			                                                   //65를 -->A로 부호화 해준다.
			                                                   //추가적인 기능...
			 //하지만 InputStreanReader 단점:  
			 try {
//				   int data = in.read();//1byte (8bit)
				 
				   char[] data = new char[3];
				   ir.read(data);	
				   //char[1000] 
				   //사용할수는있지만 A라는 것만받기에는 999의 공간이 낭비된거다
				   // 1000글자 이상으로 치면 1000글자 이상으로는 못받는다
				   // 이래서 잘사용하지않는다 특히 통신에서는 더더욱
				   //해결방안은 Buffer이다
				   System.out.println(data);
				} catch (Exception e) {
				System.out.println("예외 :" + e.getMessage());
			}
		}
	
	
	
	 
	
}
