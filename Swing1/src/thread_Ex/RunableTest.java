package thread_Ex;

import javax.swing.JFrame;

// Runable 인터페이스를 구현해서 만들기 -Thread  2번째
// 자바는 다중 상속이 허용되지 않으므로 다른 클래스를 상속한 경우 
// thread를 만들기 위해 Runnable interface를 구현 하도록 합니다.

class MyRunnable1 extends JFrame implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("☈ ☇");
		}

	}

}

public class RunableTest {

	public static void main(String[] args) {
		// Runnable 사용하는 방법
		MyRunnable1 myRunnable1 = new MyRunnable1();
		// Runnable을 구현한 객체는 그냥 기본 Thread를 생성해서 매개 변수에 담고
		// thread를 시작하면된다
		Thread thread1 = new Thread(myRunnable1);
		thread1.start();

		Thread thread2 = new Thread(myRunnable1);
		thread2.start();
	}

}
