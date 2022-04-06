package thread_Ex;

class PriorityThread extends Thread{
	
	
	@Override
	public void run() {
		//지역변수
		int sum = 0;
		
		Thread t = Thread.currentThread();
		System.out.println( t+ "start");
		for (int i = 0; i < 10000; i++) {
			sum += i;	
		}
		System.out.println(t.getPriority()+ " end ");
	}
}



public class ThreadTest4 {
     public static void main(String[] args) {
		int i;
		// 1 2 3 4 5 6 ~~~
		for (i = Thread.MIN_PRIORITY; i <= Thread.MAX_PRIORITY; i++) {
			
			PriorityThread pt = new PriorityThread();
			pt.setPriority(i);//우선순위
			pt.start();
			
		}
	}
}
