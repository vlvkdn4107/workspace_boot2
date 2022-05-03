package ch02;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame1 extends JFrame{
    
	private BorderLayout borderLayout;
	JButton[] buttons = new JButton[5];
	String[] title = {"북", "센터", "남", "동","서"};
	String[] driections = {
			BorderLayout.NORTH,BorderLayout.CENTER,
			BorderLayout.SOUTH,BorderLayout.EAST,
			BorderLayout.WEST
	};
	
	public MyFrame1() {
	initDate();
	setInitLayout();
		
	}
	
	private void initDate() {
		setTitle("BorderLayout Test");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		borderLayout = new BorderLayout();
		
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(title[i]);
		}
	}
	private void setInitLayout() {
		setVisible(true);
		setLayout(borderLayout);
		
		
		for (int i = 0; i < buttons.length; i++) {
			add(buttons[i], driections[i]);//this.이 생략된거다 // i번째 버튼s를 넣는다
		}
		
	}
	
}
