package ch03;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class MyimageFrame1 extends JFrame{

	 //이미지패널을 포함관계로 넣는다
	
	public MyimageFrame1() {
         initDate();
         setInitLayout();
	}
	private void initDate() {
		setTitle("JPanel에 이미지 넣기");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private  void setInitLayout() {
	  setVisible(true);
	  add(new imagePanel());
	}
	
	public static void main(String[] args) {
		new MyimageFrame1();
	}
	
	
	class imagePanel extends JPanel{
		
		private Image image;
		
		public imagePanel() {
			image = new ImageIcon("image1.jpg").getImage();
		}
		
		@Override
		public void paint(Graphics g) {
			
			super.paint(g);
			
			g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		}
	}
}
