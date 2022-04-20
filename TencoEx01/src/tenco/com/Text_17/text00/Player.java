package tenco.com.Text_17.text00;

import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player extends JLabel implements Moveable {

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

	

	public Player() {
		initObject();
		initSetting();
		initBackgroundPlayerService();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeftWallCrash() {
		return leftWallCrash;
	}

	public void setLeftWallCrash(boolean leftWallCrash) {
		this.leftWallCrash = leftWallCrash;
	}

	public boolean isRightWallCrash() {
		return rightWallCrash;
	}

	public void setRightWallCrash(boolean rightWallCrash) {
		this.rightWallCrash = rightWallCrash;
	}

	public ImageIcon getPlayerR() {
		return playerR;
	}

	public void setPlayerR(ImageIcon playerR) {
		this.playerR = playerR;
	}

	public ImageIcon getPlayerL() {
		return playerL;
	}

	public void setPlayerL(ImageIcon playerL) {
		this.playerL = playerL;
	}

	public int getSPEED() {
		return SPEED;
	}

	public int getJUMPSPEED() {
		return JUMPSPEED;
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
		playerR = new ImageIcon("C:\\workspace_boot2\\TencoEx01\\images/playerR.png");
		playerL = new ImageIcon("C:\\workspace_boot2\\TencoEx01\\images/playerL.png");
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
	public Bubble attackBubble() {
		return new Bubble(this); //add 함수는 
	}
	
	
	
	
}//end of class
