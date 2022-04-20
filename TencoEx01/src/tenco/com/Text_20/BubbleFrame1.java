package tenco.com.Text_20;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import lombok.Data;
import sound.BGM;

public class BubbleFrame1 extends JFrame {

	
	
//	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Enemy enemy;
	private JLabel backgroundMap;
	// 참조타입으로 불러오기
	private Player player; //삭제 1단계 겟터셋터만들거나 public으로 바꾸거나
//	private Enemy enemy;

	public BubbleFrame1() {
		initObject();
		initSetting();
		initListener();
		
		setVisible(true);
//		new BGM();
		

	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public JLabel getBackgroundMap() {
		return backgroundMap;
	}

	public void setBackgroundMap(JLabel backgroundMap) {
		this.backgroundMap = backgroundMap;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));// 오류는 안뜨지만 디버깅하기가 어렵다
		setContentPane(backgroundMap);
		// 초기화 시키기
		player = new Player(this);// 생성을하고
		add(player);// 넣고
		enemy = new Enemy(this);
		add(enemy);

	}

	private void initSetting() {
		setSize(1000, 640);
		setLayout(null); // absoulte개념 (좌표값으로 자유롭게 그림을 그릴 수 있다)
		setLocationRelativeTo(null);// JFrame 가운데 배치하기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void initListener() {
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
//				System.out.println("11111");
				System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					// true true false false
					if (!player.isLeft() && !player.isLeftWallCrash()) {// isLeft가 아닐때만 밑에 실행문을 실핼해라
						player.left();// 플레이어에서 호출
					}
					break;  
 				case KeyEvent.VK_RIGHT:
					if (!player.isRight() && !player.isRightWallCrash()) {// 아닐때 오른쪽으로 가라
						player.right();
					}
					break;
				case KeyEvent.VK_UP:
					if (!player.isUp() && !player.isDown()) {
						player.up();
					}
					break;
				case KeyEvent.VK_SPACE :
//				    Bubble bubble = new Bubble(player);
					player.attackBubble();
					
//					add(player.attackBubble());
//				    add(bubble);
				    break;
				}
			}// end of keyPressed
			

			@Override
			public void keyReleased(KeyEvent e) {
//				System.out.println("222222");
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.setLeft(false);
					break;
				case KeyEvent.VK_RIGHT:
					player.setRight(false);
					break;
				case KeyEvent.VK_UP:
					player.setUp(false);
					break;
				case KeyEvent.VK_DOWN:
					player.setDown(false);
					break;

				default:
					break;
				}
			}

		});
	}

	public static void main(String[] args) {
		new BubbleFrame1();
		
		
	}

	

}
