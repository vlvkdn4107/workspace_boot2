package tenco.com.Text_12;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bubble extends JLabel {
	// 의존성 컴포지션
	private Player player;
	private BufferedImage bubbleimg;

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
	}

	private void initData() {
		try {
			bubbleimg = ImageIO.read(new File("images/bubble.png"));
		} catch (IOException e) {
			System.out.println("파일 x");
			e.printStackTrace();
		}
		bubble = new ImageIcon("images/bubble.png");
		bubbled = new ImageIcon("images/bubbled.png");
		bomb = new ImageIcon("images/bomb.png");
	}

	private void initSetting() {
		left = false;
		right = false;
		up = false;

		//플레이어의 현재 위치값을 받는다.
		x = player.getX();
		x = player.getY();

		setIcon(bubble);
		setSize(50, 50);
 
		System.out.println("159798");
		state = 0;
	}

}
