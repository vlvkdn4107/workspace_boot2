package tenco.com.Text_18;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;
@Data
public class Enemy extends JLabel implements Moveable {

	private BubbleFrame1 mContext;
	
	//위치 상태
	private int x;
	private int y;
	
	//적의 현재 방향 (enum)
	private EnemyWay enemyWay;
	
    //움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	//플레이어 속도 상태
	private final int SPEED =2;
	//점프 기능
	private final int JUMPSPEED =1;
	
	
	//벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	
	
	private ImageIcon enemyR;
	private ImageIcon enemyL;
	
	//bubbleFrame에서 쓰기위한 set

	

	public Enemy() {
		initObject();
		initSetting();
		initBackgroundPlayerService();
	}

	

	public Enemy(BubbleFrame1 montext) {
		this.mContext = mContext;
		initObject();
		initSetting();
	}
	

	private void initBackgroundPlayerService() {
		//백그라운드는 계속 돌아가게 만들어야한다
//		new Thread(new BackgroundPlayerService(this)).start(); //이 쓰레드를 runnble로 만들어야 하기떄문에 백그라운드서비스 를 불러와도된다 // 이 클래스가 player이기때문에 this
		
	}

	private void initObject() {
		enemyR = new ImageIcon("images/enemyR.png");
		enemyL = new ImageIcon("images/enemyL.png");
	}

	private void initSetting() {
		x = 500;
		y = 180;
		
		//초기화
		left = false;
		right = false;
		up = false;
		down = false;
		
		 leftWallCrash = false;
		 rightWallCrash = false;
		 
		 enemyWay = EnemyWay.RIGHT;
		

		setIcon(enemyL);
		setSize(50, 50);
		setLocation(x, y);// 위치를 좌표로 설정

	}

	//이벤트 핸들러
	
	

	
	@Override
	public void left() {	
		enemyWay = EnemyWay.LEFT;
		left = true;
		new Thread(new Runnable() {		
			@Override
			public void run() {
				while(left) {
					setIcon(enemyL);
					x -= SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);//0.01
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}//end of while	
			}
		}).start();
	}

	@Override
	public void right() {
		enemyWay= EnemyWay.RIGHT;
		right = true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(right) {
					setIcon(enemyR);
					x += SPEED;
					setLocation(x, y);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}//end of while
				
				
			}
			
			
		}).start();;
		

	}
    //left + up  , right + up
	@Override
	public void up() {
        up = true;
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 130/ JUMPSPEED; i++) {//올라가는 부분은 for
					y = y - JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(4);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//이값을 다시 false로 해줘야 for문이 계속 반복한다
				up = false;
				down();// 내부에서 호출
			}
		}).start();
        
        
	}

	@Override
	public void down() {
		down = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(down) {
					y = y + JUMPSPEED;
					setLocation(x, y);
					try {
						Thread.sleep(7);
					} catch (Exception e) {
					   e.printStackTrace();
					}	
				}
				down = false;				
			}
		}).start();

	}
   
	
}//end of class
