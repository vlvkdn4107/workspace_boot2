package thread_Ex;


class ThreadEx1 extends Thread{
	

      @Override
    public void run() {
    	for (int i = 0; i < 50; i++) {
			System.out.println(new String("_"));
		}
    }    	
}

class ThreadEx2 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(new String("|"));
		}
	}
}


public class ThreadEx_1 {
//   static long startTime = 0;
   public static void main(String[] args) {
	ThreadEx1 th1 = new ThreadEx1();
	ThreadEx2 th2 = new ThreadEx2();
	
	th2.start();
	th1.start();
	
	
//	startTime = System.currentTimeMillis();
	try {
		th1.join();
		th2.join();
	} catch (InterruptedException e) {
		
	}
}
}
