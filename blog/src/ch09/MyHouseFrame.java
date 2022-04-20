package ch09;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel1 extends JPanel{
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawLine(400, 100, 200, 300);
		g.drawLine(400, 100, 600, 300);
		g.drawLine(200, 300, 600, 300);
		g.drawRect(250, 300, 300, 300);
	}
}

public class MyHouseFrame extends JFrame{
	MyPanel1 myPanel1;
	
	public MyHouseFrame() {
		initData();
		setInitLayout();
	}
	private void initData() {
		setTitle("집");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myPanel1 = new MyPanel1();
		add(myPanel1);
	}
	
	private void setInitLayout() {
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new MyHouseFrame();

	}

}
