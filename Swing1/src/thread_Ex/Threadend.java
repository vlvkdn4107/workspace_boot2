package thread_Ex;

import java.util.Scanner;

class MyThread1 extends Thread {
	
    boolean flag = true;
	
	
	@Override
	public void run() {
			while (flag) {
				System.out.println("-");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					
				}
			}
	}
}

public class Threadend {
	public static void main(String[] args) {
		System.out.println("작업자를 생성 합니다");//메인 쓰레드
		MyThread1 myThread1 = new MyThread1();//메인 쓰레드
		myThread1.start();//메인 쓰레드
		System.out.println("중지 : 0 입력하세요");//메인 쓰레드
		Scanner scanner = new Scanner(System.in);//메인 쓰레드
		int userInput = scanner.nextInt();//메인 쓰레드
		
		if(userInput == 0) {//메인 쓰레드
//			myThread1.stop();//deprecated(더 이상 사용하지 마시오) 권장
			myThread1.flag = false;
		}
	}// end of main
}
