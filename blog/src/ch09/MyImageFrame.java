package ch09;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageFrame extends JFrame{

		private BufferedImage backgroundImage;
		private BufferedImage imageIcon;
		private MyImagePanel myImagePanel;
		private File image1;
		private File icon1;
		
		
		
		private final static int BACKGROUND_WIDTH = 500;
		private final static int BACKGROUND_HEIGHT = 500;
		private final static int IMAGE_WIDTH = 500;
		private final static int IMAGE_HEIGHT = 500;
		private final static int ICON_WIDTH = 150;
		private final static int ICON_HEIGHT = 150;
		
	public MyImageFrame(File imFile, File icon1) {
		this.image1 = image1;
		this.icon1 = icon1;
		initData();
		setInitLayout();
	}
	private void initData() {
		setTitle("백그라운드 이미지 연습");
		setSize(BACKGROUND_WIDTH,BACKGROUND_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			backgroundImage = ImageIO.read(image1);
			imageIcon = ImageIO.read(icon1);
		} catch (IOException e) {
			System.out.println("파일 x");
			e.printStackTrace();
		}
		myImagePanel = new MyImagePanel();
		add(myImagePanel);
	}
	private void setInitLayout() {
		setVisible(true);
		setResizable(false);
	}
		
		
	private class MyImagePanel extends JPanel{
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0, 0, IMAGE_WIDTH, IMAGE_HEIGHT, null);
			g.drawImage(imageIcon, 0, 0, ICON_WIDTH, ICON_HEIGHT, null);
		}
	}

}
