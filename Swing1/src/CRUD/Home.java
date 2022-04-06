package CRUD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Home extends JFrame{

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JPanel panel;
	private JTextField textField;
	private JLabel label;
	private TextArea textArea;
	
	
	
	public Home() {
		initData();
		setInitLayout();
	}
	private void initData() {
		setTitle("홈");
		setSize(600,550);
		panel = new JPanel();
		Dimension dimension = new Dimension(470, 500);
		Dimension dimension1 = new Dimension(106, 50);
	    Dimension dimension2 = new Dimension(440, 30);
		Dimension dimension3 = new Dimension(440, 360);
		
		panel.setPreferredSize(dimension);	
//		label = new JLabel("라벨");
		button1 = new JButton("가족");
		button2 = new JButton("친구");
		button3 = new JButton("회사");
		button4 = new JButton("동창");
		button5 = new JButton("추가");
		button6 = new JButton("나가기");
//		passwordField = new JPasswordField("아이디",20);
//		textField = new JPasswordField("패스워드",20);
		textArea = new TextArea();
		
		
		panel.setBackground(Color.cyan);
		
		add(panel);
//		panel.add(label, BorderLayout.NORTH);
		
		button1.setPreferredSize(dimension1);
		button2.setPreferredSize(dimension1);
		button3.setPreferredSize(dimension1);
		button4.setPreferredSize(dimension1);
		button5.setPreferredSize(dimension2);
		button6.setPreferredSize(dimension2);
		panel.add(button1);	
		panel.add(button2);	
		panel.add(button3);	
		panel.add(button4);	
		textArea.setPreferredSize(dimension3);
//		panel.add(textField);
//		panel.add(passwordField);
		panel.add(textArea);
		panel.add(button5);
		panel.add(button6);
		
	}
	private void setInitLayout(){	
		
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEFT,45,5));
		
//		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
	}
	
	
	public static void main(String[] args) {
		new Home();
	}
}
