package ch09;

import javax.swing.JFrame;

class MyRunnable extends JFrame{

	Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 0; i < 20; i++) {
				System.out.println("스레드동작 " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	};
	
}


public class MyRunnableTest {

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		myRunnable.runnable.run();
		
	}

}
