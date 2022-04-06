package thread_Ex;

import java.io.IOException;

public class TerminateThread extends Thread {

	private boolean flag = false;
	int i;

	public TerminateThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		// !flag = true
		while (!flag) {
			try {
				Thread.sleep(100);// 0.1초
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
         System.out.println(getName() + "end");
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public static void main(String[] args) {
     
		TerminateThread threadA = new TerminateThread("A");
		TerminateThread threadB = new TerminateThread("B");
		TerminateThread threadC = new TerminateThread("C");
		
		threadA.start();
		threadB.start();
		threadC.start();
		
		int in;
		while(true) {
			//true면 실행
			try {
				in = System.in.read();//어떤 값을 읽어주는 녀석
				if(in == 'A') {
					threadA.setFlag(true);
				}else if(in == 'B') {
					threadB.setFlag(true);
				}else if(in == 'C') {
					threadC.setFlag(true);
				}else if(in == 'M') {
					threadA.setFlag(true);
					threadB.setFlag(true);
					threadC.setFlag(true);
				}else {
					System.out.println("type again");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
//		System.out.println("main end");
	}// end of main
}
