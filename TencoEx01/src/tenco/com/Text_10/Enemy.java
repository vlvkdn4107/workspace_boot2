package tenco.com.Text_10;



import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy extends JLabel implements Runnable{

	private int x;
	private int y;
	
	
	private ImageIcon enemyL;
	private ImageIcon enemyR;
	
	private boolean isThread = true;
	
	
	
	
	public Enemy() {
		initObject();
		initSetting();
		Thread thread = new Thread();
		thread.start();
	}
	
	private void initObject() {
		
		enemyL = new ImageIcon("images/enemyL.png");
		enemyR = new ImageIcon("images/enemyR.png");
		
	}
	private void initSetting() {
		
		x = 200;
		y = 300;
		setIcon(enemyL);
		setSize(50,50);		
		setLocation(x, y);
		
	}

	@Override
	public void run() {
	boolean direcation = true;
	System.out.println("111111");
		while(true) {
			System.out.println("321");
		   if(isThread) {
			   if(direcation) {
				   x += 10;
			   }else {
				   x -=10;
			   }
			   if(x == 400) {
				   direcation = false;
				   enemyL = enemyR;
			   }
			   try {
				Thread.sleep(70);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   
		}
		
	}
	

	
}
