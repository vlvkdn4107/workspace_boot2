package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListener3 extends JFrame{

	private JButton button1;
	private JButton button2;
	
	public EventListener3() {
		initDate();
		setInitLayout();
		addEventListener();
	}
	private void initDate() {
		setTitle("익명 구현 객체에 이해");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
	}
	
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
		add(button1);
		add(button2);
	}
	
	
	
	private void addEventListener() {
		//익명 구현 객체 사용법!!!
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼이 클릭 됨");
				
			}
		});
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼2가 클릭 됨");
				
			}
		});
	}
	public static void main(String[] args) {
//		EventListener3 listener3 = new EventListener3();
		new EventListener3();//익명 클래스
		
	}
	
	
}
