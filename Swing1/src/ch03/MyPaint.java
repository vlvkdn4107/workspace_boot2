package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class MyPaint extends JFrame{

	MyPanel myPanel;
	
	
	
     public MyPaint() {
         initDate();
         setInitLayout();
	}
     
     private void initDate() {
    	 setTitle("직접 그려보기 연습");
    	 setSize(800, 800);
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 myPanel = new MyPanel();
    	 
     }
     
     private void setInitLayout() {
    	 setVisible(true);
    	 add(myPanel);
     }
	public static void main(String[] args) {
		new MyPaint();
	}
	//내부클래스
	private class MyPanel extends JPanel{ //내부클래스는 private 써도 된다.
	
	@Override
	public void paint(Graphics g) {//Graphics가 직접 그려준다!
		super.paint(g);
		g.drawString("안녕 Java 2D", 100, 200);// String str, int x, int y
		g.drawLine(20, 30, 100, 100);// x부터 y까지 x부터 y까지
		g.drawRect(100, 100, 150, 150); //x y 값부터 크기가 150인 사작형을 그린다
	}
	
 }//end of innerclass //어차피 이 클래스에서만 쓸꺼기 때문에 내부 클래스로 만들어도 괜ㅊㅏㄶ다
}
	

