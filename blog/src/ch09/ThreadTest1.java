package ch09;

public class ThreadTest1 {

	public static void main(String[] args) {
		MyThread subThread1= new MyThread("서브작업자1");
		MyThread subThread2= new MyThread("서브작업자2");
		MyThread subThread3= new MyThread("서브작업자3");
		
		subThread1.start();
		subThread2.start();
		subThread3.start();

	}

}
