package thread_Ex;

public class ThreadTest1 {
	
	//메인은 코드의 시작점
	//메인 쓰레드가 동작하는 부분
   public static void main(String[] args) {
	  
	   for (int i = 0; i < 50; i++) {
		System.out.println(i + "\t");
		
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	   
	   
   }
}
