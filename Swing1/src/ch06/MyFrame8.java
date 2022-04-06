package ch06;

import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrame8 extends JFrame implements KeyListener {

	// !!변수에 효용!!!

	BufferedImage bgImage;
	BufferedImage imageIcon;
	private JPanel panel;

	int xPoint = 200;
	int yPoint = 200;

	// 내부 클래스선억 - paint

	// 이벤트 리스너 등록 1, 2, 3
	public MyFrame8() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setTitle("");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		try {

//		ImageIO.read(new File("map.jpg"));
			bgImage = ImageIO.read(new File("map.jpg"));

			imageIcon = ImageIO.read(new File("icon2.png"));
		} catch (IOException e) {
			System.out.println("파일 없음");
		}

		panel = new JPanel();

	}

	private void setInitLayout() {
		setVisible(true);

		add(panel);

	}

	private void addEventListener() {
		this.addKeyListener(this);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 이미지 그리기

		g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
		g.drawImage(imageIcon, xPoint, yPoint, 100, 100, null);
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_UP) {
//			yPoint -=10;
			yPoint = (yPoint < 0) ? 0 : yPoint - 10;
		} else if (keyCode == KeyEvent.VK_DOWN) {
//                  yPoint += 10;
			yPoint = (yPoint > 400) ? 400 : yPoint + 10;
//                  System.out.println(yPoint);
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			xPoint += 10;
			xPoint = (xPoint > 420) ? 420 : xPoint + 10;
			System.out.println(xPoint);
		} else if (keyCode == KeyEvent.VK_LEFT) {
//                  xPoint -=10;
			xPoint = (xPoint < 0) ? 0 : xPoint - 10;
		}

		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MyFrame8();
	}
}
