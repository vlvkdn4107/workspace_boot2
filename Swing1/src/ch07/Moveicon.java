package ch07;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Moveicon extends JFrame implements KeyListener{
	
	
	private BufferedImage bgImage;
	private BufferedImage imgIcon;
	private JPanel panel;
	private String bgImageFileName = "map.jpg";
	private String imageIconFileName = "icon2.png";
	int xPoint = 200;
	int yPoint = 200;
	
	public Moveicon() {
		initDate();
		setLayout();
		addEventListener();
	}
	private void initDate() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//이미지 
		try {
			bgImage = ImageIO.read(new File(bgImageFileName));
			imgIcon = ImageIO.read(new File(imageIconFileName));
		} catch (IOException e) {
			System.out.println("파일이 없습니다");
//			System.exit(0);  0번을 누르면 종료한다
			
		}
		panel = new JPanel();
	}
	private void setLayout() {
		setVisible(true);
		setResizable(false);
		add(panel);
	}
	private void addEventListener() {
		this.addKeyListener(this);//전체
	}
	private class ImagePanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(imgIcon, xPoint,yPoint, 100, 100, null);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_UP) {
			yPoint = (yPoint < 0) ? 0:yPoint - 10;
//			yPoint -= 10;
		}else if(keyCode == KeyEvent.VK_DOWN) {
			yPoint += 10;
		}else if(keyCode == KeyEvent.VK_LEFT) {
			xPoint -=10;
		}else if(keyCode == KeyEvent.VK_RIGHT) {
			xPoint +=10;
		}
		
		repaint();//다시 그릴거다
		
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		   new Moveicon();
	}
	
}
