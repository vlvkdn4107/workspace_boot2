package ch09;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGridLayout extends JFrame{
	
	GridLayout gridLayout;
	JButton button[] = new JButton[8];
	
	public TestGridLayout() {
		initData();
		setInitLayout();
	}
	public void initData() {
		setTitle("Test GridLayout");
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton("버튼" + i);
			add(button[i]);
		}
	}
	public void setInitLayout() {
		gridLayout = new GridLayout(4,2);
		setVisible(true);
		setLayout(gridLayout);
	}

	public static void main(String[] args) {
		new TestGridLayout();

	}

}
