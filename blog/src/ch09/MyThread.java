package ch09;

public class MyThread extends Thread{
	
	String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
	}
}
