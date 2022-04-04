package ch03;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyImageFrame2 extends JFrame{

	//코드를 조금 수정해주세요
	//상수,스테이틱 활용해서 처리해주세요
	
	private static BufferedImage backgroundImage;
	private static BufferedImage imageIcon;
	private MyImagePanel myimagePanel;
	private JButton button;
	
	 
	
	


	
	public BufferedImage getBackgroundImage() {
		return backgroundImage;
	}
	public BufferedImage getImageIcon() {
		return imageIcon;
	}
	
	public MyImageFrame2() {
		
	 	
		initDate();
		setInitLayout();
	}
	void initDate() {
		setTitle("백그라운드 연습");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
//			setbackgroundImage = 
			 backgroundImage = ImageIO.read(new File("image1.jpg"));//IO 는 출력 가져오다??
			 imageIcon = ImageIO.read(new File("icon2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 없습니다");
		}
		myimagePanel = new MyImagePanel();
	}
	private void setInitLayout() {
	    setVisible(true);	
        setResizable(false);
	    add(myimagePanel);
	}
	
	
	private class MyImagePanel extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(backgroundImage, 0,0 ,500,500, null);
			g.drawImage(imageIcon,0 ,0 ,100,100, null);
			
		}
		
	}//end of inner
	public static void main(String[] args) {
		new MyImageFrame2();
		
		
	}//end of main
	public void addEventListenner() {
		System.out.println("브렌치를 만들었습니다.");
	}
	
	
}
