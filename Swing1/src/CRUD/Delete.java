package CRUD;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete extends JFrame{

	JButton button;
	JPanel panel;
	JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    
    
	
	
	public Delete() {
		initData();
		setInitLayout();
	}
	
	private void initData() {
		
		panel = new JPanel();
		add(panel);
		panel.setBackground(Color.cyan);
		button = new JButton();
		textField1 = new JTextField();
		textField2 = new JTextField();
		textField3 = new JTextField();
		
	}
	private void setInitLayout() {
		
	}
	
	
}
