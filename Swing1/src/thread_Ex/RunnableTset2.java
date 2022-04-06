package thread_Ex;

import javax.swing.JFrame;

class MyRunnable2 extends JFrame{
	int grade;
	//자바 문법 -> 내부 익명 구현 객체를 변수에 담기
	//interface
	Runnable runnable = new Runnable() {
		
		//익명 내부 클래스로 만들어졌다.
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				System.out.println("-");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		}
	};
	
	
	//생성자
	public MyRunnable2() {
		//멤버변수에 접근해서
//		runnable.run();
	}
	
}



public class RunnableTset2 {

	public static void main(String[] args) {

     MyRunnable2 runnable2 = new MyRunnable2();
     //여기서 실행 할려면 참조변수
     runnable2.runnable.run();
	}

}
