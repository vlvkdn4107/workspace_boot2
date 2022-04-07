package Iconmove;

import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapFrame extends JFrame{

	private JLabel backgroundMap;
	private Player player;
	int x;
	int y;
//	private Enemy enemy;
	
	public MapFrame() {
		initObject();
		initSetting();
		initListener();
		setVisible(true);
	}
	private void initObject() {
		backgroundMap = new JLabel(new ImageIcon("images/map.jpg"));
//		backgroundMap = new Imag
		setContentPane(backgroundMap);
		player = new Player();
		add(player);
		
		
		
	}
	
	
	private void initSetting() {
		setSize(700,580);
		setLayout(null);
		setLocationRelativeTo(null); // JFrame 가운데 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	private void initListener() {
		this.addKeyListener(new KeyAdapter() {	
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(!player.isLeft()) {
						player.left();
					}					
					break;
				case KeyEvent.VK_RIGHT:
					if(!player.isRight()) {
						player.right();
					}
					
					break;
				case KeyEvent.VK_UP:
					if(!player.isUp()) {
						player.up();
					}
					break;
				case KeyEvent.VK_DOWN:
					if(!player.isDown()) 
						player.down();
						break;
					
					
					
				default:
					break;
				}
			}//end of keyPressed
			@Override
			public void keyReleased(KeyEvent e) {
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
		new MapFrame();
	}
	
} // end of class

