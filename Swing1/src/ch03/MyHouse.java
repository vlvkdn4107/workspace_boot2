package ch03;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;


class MyHouse1 extends JPanel{
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawRect(200, 200, 200, 200);//집 몸체
		g.drawString("****************************************", 200 , 210);
		
		
		g.drawRect(220, 220, 80, 80);//창문
		g.drawLine(260, 300, 260, 220);
		g.drawLine(260, 300, 260, 220);
		g.drawLine(220, 260, 300, 260);
		g.drawString("●●●●●●●●", 220, 230);
		
		g.drawLine(300,  100, 200, 200);//지븅
		g.drawLine(300,  100, 400, 200);
		
		g.drawLine(330, 400, 330, 300);
		
		
		g.drawString("★", 380, 50);
		g.drawString("★", 300, 70);
		g.drawString("★", 220, 150);
		g.drawString("★", 240, 100);
		
		
		
		
	}
	
}




public class MyHouse extends JFrame{

	
	MyHouse1 myhousel;
	
	
	
    public MyHouse() {
        initDate();
        setInitLayout();
	}
    
    private void initDate() {
   	 setTitle("직접 그려보기 연습");
   	 setSize(800, 800);
   	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	myhousel = new MyHouse1();
   	 
    }
    
    private void setInitLayout() {
   	 setVisible(true);
   	 add(myhousel);
    }
	public static void main(String[] args) {
		new MyHouse();
	}
	
}

