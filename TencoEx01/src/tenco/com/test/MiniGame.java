 package tenco.com.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniGame extends JFrame implements ActionListener {

	// 배경
	private BufferedImage bgImage;
	// 플레이어
	private BufferedImage playerImage;
	private BufferedImage playerImageL;
	private BufferedImage playerImageR;

	// 적
	private BufferedImage enemyImage;
	private BufferedImage enemyImageL;
	private BufferedImage enemyImageR;

	private JButton startBtn;
	private JButton endBtn;
	private JPanel bottomPanel;

	private boolean isThread = true;

	// 플레이어 위치
	private int playerX;
	private int playerY;
	// 적 위치
	private int enemyX;
	private int enemyY;

	private CustomJPanel customJPanel;

	public MiniGame() {
		initData();
		setLayout();
		addEventListener();

		Thread thread = new Thread(customJPanel);
		thread.start();
	}

	private void initData() {
		setSize(600, 670);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 버튼 만들기
		startBtn = new JButton("start");
		endBtn = new JButton("end");

		// 이미지파일을 미리 메모리에 올리기
		try {
			bgImage = ImageIO.read(new File("images/backgroundMap.png"));
			playerImageL = ImageIO.read(new File("images/bear.png"));
			playerImageR = ImageIO.read(new File("images/playerR.png"));
			playerImage = playerImageR;

			enemyImageL = ImageIO.read(new File("images/enemyL.png"));
			enemyImageR = ImageIO.read(new File("images/enemyR.png"));
			enemyImage = enemyImageR;
		} catch (IOException e) {
			System.out.println("파일이 없습니다!!!");
			e.printStackTrace();

		}

		customJPanel = new CustomJPanel();

		// enemy좌표값 초기화 선언
		enemyX = 100;
		enemyY = 400;

		bottomPanel = new JPanel(new FlowLayout());
//		// 초기화
//		customJPanel = new CustomJPanel();

	}// end of initData

	private void setLayout() {

		bottomPanel.add(startBtn);
		bottomPanel.add(endBtn);

		add(customJPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		setVisible(true);
		// 나한테 ????
		this.requestFocusInWindow();
	}// end of setLayout

	private void addEventListener() {
		startBtn.addActionListener(this);
		endBtn.addActionListener(this);

		// this. 을 해줘야 keyEvent가 적용된다
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				System.out.println("작용된다.");
				// switch(바로찾아간다 다만 오타 유발 가능성이 높다)
				// if문이랑 거의 흡사하다
				switch (keyCode) {
				case KeyEvent.VK_UP:// 이거라면
					playerY -= 10; // -10만큼 해라
					break; // break문을 안써주면 바로 밑에 case도 실행된다.
				case KeyEvent.VK_DOWN:
					playerY += 10;
					break;
				case KeyEvent.VK_LEFT:
					playerX -= 10;
					playerImage = playerImageL;
					break;
				case KeyEvent.VK_RIGHT:
					playerX += 10;
					//keyEvent가 오른쪽으로 누르면 이미지가 바뀐다.
					playerImage = playerImageR;
					break;

				}
				repaint();
			}
		});
		this.requestFocusInWindow();
	}// end of addEventListener

	// 내부클래스
	private class CustomJPanel extends JPanel implements Runnable {

		// 기능 그리는 부분
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, 600, 600, null);
			g.drawImage(playerImage, playerX, playerY, 55, 55, null);
			g.drawImage(enemyImage, enemyX, enemyY, 55, 55, null);

		}

		@Override
		public void run() {
			boolean direcation = true;

			while (true) {
				if (isThread) {
					if (direcation) {
						enemyX += 10;
					} else {
						enemyX -= 10;
					}
					// X좌표값이 400이면
					if (enemyX == 400) {
						direcation = false;// 방향을 바꾸고
						// 이 위치에서 이미지를 바꾼다
						enemyImage = enemyImageL;
					}
					// X좌표값이 10이면
					if (enemyX == 10) {
						direcation = true; // 다시 방향을 바꾼다
						enemyImage = enemyImageL;
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} // end of if(isThread)
				//repaint가 if문밖에있어야 밑에 isThread가 false이 작용해서 다시 시작한다
				repaint();
			}

		}

	}// end of inner class

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton targetBtn = (JButton) e.getSource();
		if (startBtn == targetBtn) {
			System.out.println("디버깅 1");
			isThread = true;
		} else {
			isThread = false;
			System.out.println("디버깅 2");
		}
		this.requestFocusInWindow();
	}

	public static void main(String[] args) {
		new MiniGame();
	}

}
