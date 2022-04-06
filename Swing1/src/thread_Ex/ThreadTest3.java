package thread_Ex;

class MyCustomThread2 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " : " + currentThread());
//			System.out.println("-");
		}		
	}
}
//class MyCustomThread3 extends Thread{
//	@Override
//	public void run() {
//		for (int i = 0; i < 100; i++) {
//			System.out.println("|");
//		}
//	}
//}

public class ThreadTest3 {
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread());
		
		//생성하기
		MyCustomThread2 t1 = new MyCustomThread2();
		MyCustomThread2 t2 = new MyCustomThread2();
		MyCustomThread2 t3 = new MyCustomThread2();
		//프리올리티 우선수위 : 1~10 우선순위는 정할수 있으나 의미 없다고한다
		
		
		
		
		t1.start();
		//0 : Thread[Thread-1,5,main]
		//                      자기가 속해있는 그룹
		t2.start();
		t3.start();
		
		Thread thread = new Thread();//쓰레드는 heap메모에 올라가게된다.
		thread.start();
		
	}
	
	//Thread란?
	//process : 프로그램이 실행되면 OS로 부터 메모리를 할당 받아 프로세스 상태가 된다.
	//thread : 하나의 프로세스는 하나 이상의 thread를 가지게 되고,
	//         실제 작업을 수행하는 단위는 thread 이다
	
	//multi threading
	// 여러 thread가 동시에 수행되는 프로그래밍이라하고 여러 작업을 동시에 실행되는
	// 효과를 낸다.
	//thread는 각각 자신만에 작업 공간을 가진다. (context 환경변수) 각자  자신만에 멤버변수를 받을수 있다.
	
	
	//각 Thread는 공유 하는 자원이 생길수 있다.
	//여러 Thread가 자원을 공유 하여 작업이 수행되는 경우
	//서로 자원을 차지하려는 race condition(임계영역)가 발생할 수 있어서
	//의도 하지 않은 결과를 만들어 낼수있다.
	
	//해결 방법으로는 동기화 처리를 해주어야 한다.
	//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
