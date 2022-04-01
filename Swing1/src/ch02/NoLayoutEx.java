package ch02;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class NoLayoutEx extends JFrame {

	
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	
//	private JButton button1;
//	private JButton button2;
//	private JButton button3;

	public NoLayoutEx() {

		initDate();
		setInitLayout();
	}

	private void initDate() {
		setTitle("NO Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		
//		for (int i = 0; i < buttons.size(); i++) {
//			buttons.add(new JButton("button" + i));
//		}//for문을쓰면 객체가 0개라서 돌릴수가없다
		buttons.add(new JButton("1"));
		buttons.add(new JButton("2"));
		buttons.add(new JButton("3"));
		
		
//		button1 = new JButton("1");
//		button2 = new JButton("2");
//		button3 = new JButton("3");
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		
		
		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).setSize(50,50); //크기
			buttons.get(i).setLocation(50 + (10* i), (50+(10+i)));
			add(buttons.get(i));
		}
		
//		button1.setSize(50, 50);
//		button1.setLocation(10, 10);
//
//		button2.setSize(50, 50);
//		button2.setLocation(10, 200);
//
//		button3.setSize(50, 50);
//		button3.setLocation(100, 10);
		
//		add(button1);
//		add(button2);
//		add(button3);

	}

	public static void main(String[] args) {
		
		new NoLayoutEx();
	}

}
