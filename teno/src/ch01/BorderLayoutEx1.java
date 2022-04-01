package ch01;

import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class BorderLayoutEx1 extends JFrame{

	private JButton button1;
	private JButton button2;
	private JButton button3;
	//배치관리자
	private Border borderLayout;
	
	public BorderLayoutEx1() {
		setTitle("테스트"); //super 생략 가능
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//주소창을 닫으면 콘솔창도 종료가된다.//클래스이름.
		
		//객체생성할때 메서드를 호출해라
		initDate();
		setInitLayout();
	}
	
	
	private void initDate() {
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		borderLayout = new BorderLay();
	}
	private void setInitLayout() {
		this.setLayout((LayoutManager) borderLayout);
		this.add(button1, BorderLayout.NORTH);
		this.add(button2, BorderLayout.SOUTH);
		this.add(button3, BorderLayout.CENTER);
	}
	
}
