package tenco.com.Text_05;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BubbleFrame extends JFrame{

	private JLabel backgroundMap;
	//참조타입으로 불러오기
	private Player player;
	
	
	public BubbleFrame() {
       initObject();
       initSetting();
       initListener();
       setVisible(true);

	}
	
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/backgroundMap.png"));// 오류는 안뜨지만 디버깅하기가 어렵다
	    setContentPane(backgroundMap);	
	    //초기화 시키기
	    player = new Player();
	    add(player);
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
				System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					player.left();//플레이어에서 호출
					break;
				case KeyEvent.VK_RIGHT:
					player.right();
					break;
				case KeyEvent.VK_UP:
					player.up();
					break;
				case KeyEvent.VK_DOWN:
					player.down();
					break;

				default:
					break;
				}
			}
		});
	}
	
	
	
	public static void main(String[] args) {
		new BubbleFrame();
	}
	
	
}