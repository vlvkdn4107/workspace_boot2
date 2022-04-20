package ch09;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFlowLayout extends JFrame{

	FlowLayout flowLayout = new FlowLayout();
	JButton[] buttons = new JButton[10];
	
	public TestFlowLayout() {
		initData();
		setInitLayout();
	}
	public void initData() {
		setTitle("Test FlowLayout");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("버튼" + i + "번");
			add(buttons[i]);
		}
	}
	public void setInitLayout() {
		setVisible(true);
		setLayout(flowLayout);
	}
	
	public static void main(String[] args) {
		new TestFlowLayout();

	}

}
