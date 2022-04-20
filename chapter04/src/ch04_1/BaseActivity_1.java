package ch04_1;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BaseActivity_1 extends JFrame{
	
	String name;
	JPanel panel;
	
	public BaseActivity_1(String name) {
		this.name = name;
		initData();
		setInitLayout();
	}
	protected void initData() {
		setTitle(this.name);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		
	}
	
	protected void setInitLayout() {
		setVisible(true);
		add(panel);
		
	}

}
