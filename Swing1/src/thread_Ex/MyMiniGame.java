package thread_Ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class MyMiniGame extends JFrame {

	BufferedImage bgimage;
	BufferedImage imgIcon1;
	BufferedImage imgIcon2;
	JButton button1;
	JButton button2;
	JPanel jPanel;
	private CustomJpanel customJpanel;
	int image3XPosition = 0;
	int xPoint = 200;
	int yPoint = 200;

	public MyMiniGame() {
		initData();
		setIninLayout();
		addEventListener();

		// 생성자에서 Thread start처리
		Thread thread = new Thread(customJpanel);
		thread.start();
	}

	private void initData() {
		setSize(600, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 파일 가져오기 todo
		try {
			bgimage = ImageIO.read(new File("map.jpg"));
			imgIcon2 = ImageIO.read(new File("icon2.png"));
			imgIcon1 = ImageIO.read(new File("icon1.png"));
		} catch (IOException e) {
			System.out.println("파일x");
		} // end try

		System.out.println("11111111111111");
        jPanel = new JPanel();
		customJpanel = new CustomJpanel();
		button1 = new JButton("멈춤!");
		button2 = new JButton("시작!");

//		Dimension dimension = new Dimension(600,50);
		jPanel.setSize(600,50);
		
		jPanel.setBackground(Color.gray);
		
	}

	private void setIninLayout() {
		setVisible(true);
		
		add(jPanel, BorderLayout.SOUTH);
		add(customJpanel);
		customJpanel.add(jPanel);
		jPanel.add(button1);
		jPanel.add(button2);
		
		

	}

	private void addEventListener() {

		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼 누름");
				
			}
		});

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// 여기서는 이미지 2번을 키 이벤트를 받아서 동작 시켜주세요

				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP) {
					System.out.println("ㅇㄴㅁㅇㅁㄴ");
					yPoint = (yPoint < 0) ? 0 : yPoint - 10;
				} else if (keyCode == KeyEvent.VK_DOWN) {
					yPoint = (yPoint > 400) ? 400 : yPoint + 10;
				} else if (keyCode == KeyEvent.VK_LEFT) {
					xPoint = (xPoint > 420) ? 420 : xPoint - 10;
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					xPoint = (xPoint < 0) ? 0 : xPoint + 10;
				}

			}
		});
	}

	private class CustomJpanel extends JPanel implements Runnable {

		@Override
		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			// 이미지를 그리기 3개 TODO

			
			g.drawImage(bgimage, 0, 0, 600, 600, null );
			g.drawImage(imgIcon2, xPoint, yPoint, 100, 100, null);
			g.drawImage(imgIcon1, image3XPosition, 420, 100, 100, null);

		}

		@Override
		public void run() {
			boolean direction = true; // 오른쪽 x ++

			// 이미지 3번을 좌우 왔다갔다
			// while(true){} <<-- 이미지 하나를 >>><<<
			// x 좌표값을 +
			// max 좌표값 확인하고
			// x 좌표값을 -
			try {

				while (true) {

					if (direction) {
						image3XPosition += 10;
					} else {

						image3XPosition -= 10;
					}
					if (image3XPosition == 500) {
						direction = false;
					}
					if (image3XPosition == 100) {
						direction = true;
					}
					
					Thread.sleep(100);
					repaint();

				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		new MyMiniGame();
	}

}
