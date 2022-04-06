package thread_Ex;

//쓰레드 만들기 
//쓰레드를 상속받아도 import가 안생김
//1번째 방법 : 다른 작업자를 생성하는 방법   (상속) -->run()메서드 구현함
class MyCustomThread extends Thread{
	
	String name; //멤버변수
	public MyCustomThread(String name) {//생성자 
		this.name= name;
	}
	//Thread는 약속되어있다
	@Override   //상속받은 Thread에서 run에 이미 정의해놨고 오버라이드를 해서 재정의 해주는 과정이다.
	//run이라는 메서드는 쓰레드가 동적을 명령 받으면
	//수행하는 코드 역역이다
	public void run() {
		int i;
		for (int j = 0; j < 50; j++) {
			System.out.println(name + " : " + j);
		}
		try {
			//클래스.sleep
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}


public class ThreadTest2 {

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread());
		                 //현재 쓰레드가 누구인가 (main)
		System.out.println("메인 쓰레드 시작");
		
		//작업자 만들기
		//쓰레드는 자기들끼리도 순서가 없다!!
		// 작업자 호출 및 작업 수행( run)을 순서대로 호출하더라도 
		//실제 작업은 랜덤이다..
		//쓰레드는 작업자가 따로 작업할수없다
		MyCustomThread t1 = new MyCustomThread("서브 작업자 1");
		//쓰레드를 시작하는 방법
		t1.start(); //t1의 객체에 들어가서 start()
		
		MyCustomThread t2 = new MyCustomThread("서브 작업자2");
		t2.start();
		
		MyCustomThread t3 = new MyCustomThread("서브 작업자 3");
		t3.start();//해야 run이라는 부분이 시작된다
		
		
		//작업자한테 맡기고 바로 나온다.
		System.out.println("메인 쓰레드 종료");

	}

}
