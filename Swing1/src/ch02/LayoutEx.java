package ch02;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class LayoutEx extends JFrame{
   
	//배열,ArrayList
	
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private FlowLayout flowLayout;
	
	public LayoutEx() {
		initData();
		setInitLayout();
	}
	public void initData() {
		
		setTitle("Flow layout TEST");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		flowLayout = new FlowLayout();
		
		
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
	}
	public void setInitLayout() {
		setVisible(true);
		setLayout(flowLayout);
		
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
	}
}
