package tenco.com.Text_17.text;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel implements Moveable{
	
	//삭제 2단계
	private Bubble bubbleContext = this;
	
	
	// 의존성 컴포지션
	private Player player;
	//버블 옵져버 주소값
		//new로 만들어서 하나의 버블만 감지 할거다
	private BackgroundBubbleObserver backgroundBubbleObserver;
	// 위치 상태를 위한 변수
	private int x;
	private int y;

	// 움직임 상태
	private boolean left;
	private boolean right;
	private boolean up;

	// 적군을 맞춘 상태
	private int state; // 0 이면 기본 1. 적군 가둠

//	private BufferedImage bubble1;
	private ImageIcon bubble;// 기본 물방울
	private ImageIcon bubbled;// 적을 가둔 물방울
	private ImageIcon bomb;// 물방울이 터진 상태

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public ImageIcon getBubble() {
		return bubble;
	}

	public void setBubble(ImageIcon bubble) {
		this.bubble = bubble;
	}

	public ImageIcon getBubbled() {
		return bubbled;
	}

	public void setBubbled(ImageIcon bubbled) {
		this.bubbled = bubbled;
	}

	public ImageIcon getBomb() {
		return bomb;
	}

	public void setBomb(ImageIcon bomb) {
		this.bomb = bomb;
	}

	public Bubble(Player player) {
		// 의존 주입 --> 생성자에 주입을 받는다
		// 내 클래스를 플레이어에 의존할꺼야
		this.player = player;
		initData();
		initSetting();
		initThread();
	}
	

	private void initData() {
		System.out.println("ds+++++++++");
		bubble = new ImageIcon("images/bubble.png");
		bubbled = new ImageIcon("images/bubbled.png");
		bomb = new ImageIcon("images/bomb.png");
		backgroundBubbleObserver = new BackgroundBubbleObserver(this);
	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;

		//플레이어의 현재 위치값을 받는다.
		x = player.getX();
		y = player.getY();

		setIcon(bubble);
		setSize(50, 50);
 
		state = 0;
	}

	private void initThread() {
		//쓰레드 시작
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(player.getPlayerWay() == PlayerWay.LEFT) {
					left();
//					up();
				}else {
					right();
				}
				
			}
		}).start();
	}
	
	
	@Override
	public void left() {
		left= true;
		for (int i = 0; i < 400; i++) {
			x--;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkLeftWall()) {
				left = false;
				break;
			}
			threadSleep(1);
			
		}
		left = false;
		up();
		
	}

	@Override
	public void right() {
		right = true;
		for(int i = 0; i < 400; i++) {
			x++;
			setLocation(x, y);
			if(backgroundBubbleObserver.checkRightWall()) {
				right = false;
				break;
			}
			threadSleep(1);
		}
		right = false;
		up();
	}

	@Override
	public void up() {
		up = true;
		while(up) {
			y--;
			setLocation(x, y);		
			if(backgroundBubbleObserver.checkTopWall()) {
				up = false;
				break;
			}
			threadSleep(1);
		}
		up = false;
		//remove(삭제)
		removeBubble();
		
	}
	private void removeBubble() {
		try {
			Thread.sleep(2000);
			setIcon(bomb);//2초뒤에 이미지 변경
			Thread.sleep(1000);
			bubbleContext = null;//널처리하면 java에서 자동으로 처리해준다. //this는 예약어기때문에 못받아드린다 //위에서 변수로 선언을 한뒤 변수 = null 처리하면 가능하다
			setIcon(null);
			//다시 그림을 그려라(JFrame에서 지워야한다)
//			mContext.remove(this);//먼저 메모리에서 지운다!!
//			mContext.repaint();// remove(this)를 안하면 repaint가 안된다 (메모리에서 안사라져서!!)//도화지(JFrame)에서 그림을 다시 그려라
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void threadSleep(int time){
		try {
			Thread.sleep(time);//값을 변수 처리
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
