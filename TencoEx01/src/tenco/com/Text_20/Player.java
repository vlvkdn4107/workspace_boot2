package tenco.com.Text_20;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import lombok.Data;
@Data
public class Player extends JLabel implements Moveable {

	private BubbleFrame1 mContext;
	private List<Bubble> bubbles;
	//위치 상태
	private int x;
	private int y;
	
	//플레이어의 현재 방향 (enum)
	private PlayerWay playerWait;
	
    //움직임의 상태
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	//플레이어 속도 상태
	private final int SPEED =4;
	//점프 기능
	private final int JUMPSPEED =2;
	
	
	//벽에 충돌한 상태
	private boolean leftWallCrash;
	private boolean rightWallCrash;
	
	
	
	private ImageIcon playerR;
	private ImageIcon playerL;
	
	//bubbleFrame에서 쓰기위한 set

	

	public Player(BubbleFrame1 mContext) {
		this.mContext = mContext;
		initObject();
		initSetting();
		initBackgroundPlayerService();
	}
	public PlayerWay getPlayerWay() {
		return playerWait;
	}

	public void setPlayerWait(PlayerWay playerWait) {
		this.playerWait = playerWait;
	}


	private void initBackgroundPlayerService() {
		//백그라운드는 계속 돌아가게 만들어야한다
		new Thread(new BackgroundPlayerService(this)).start(); //이 쓰레드를 runnble로 만들어야 하기떄문에 백그라운드서비스 를 불러와도된다 // 이 클래스가 player이기때문에 this
		
	}

	private void initObject() {
		bubbles = new ArrayList<Bubble>();
		playerR = new ImageIcon("images/playerR.png");
		playerL = new ImageIcon("images/playerL.png");
	}

	private void initSetting() {
		x = 80;
		y = 535;
		
		//초기화
		left = false;
		right = false;
		up = false;
		down = false;
		
		 leftWallCrash = false;
		 rightWallCrash = false;
		 
		 playerWait = PlayerWay.RIGHT;
		

		setIcon(playerR);
		setSize(50, 50);
		setLocation(x, y);// 위치를 좌표로 설정

	}

	//이벤트 핸들러
	
	

	
	@Override
	public void left() {
		System.out.println("left");
		playerWait = PlayerWay.LEFT;
		left = true;
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(left) {
					setIcon(playerL);
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
		System.out.println("right");
		playerWait = PlayerWay.RIGHT;
		right = true;
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(right) {
					setIcon(playerR);
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
		System.out.println("점프!");
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
		System.out.println("다운!");
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
				
				
//				for (int i = 0; i < (130/JUMPSPEED); i++) {
//					y = y + JUMPSPEED;
//					setLocation(x, y);
//					try {
//						Thread.sleep(3);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				down = false;
				
			}
		}).start();

	}
    //moveable 활용 x
	//메서드 이름 지을때 보통 동사+명사
	public void attackBubble() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Bubble bubble = new Bubble(mContext);
				 mContext.add(bubble);//여기서 mContext는 jframe
				 bubbles.add(bubble);//백그라운드 서비스에서 버블을 for문으로 다 체크 할거다
				 if(playerWait == PlayerWay.LEFT) {
					bubble.left();  
				 }else {
					 bubble.right();
				 }
				
			}
		}).start();
	}
	
	
	
	
}//end of class
