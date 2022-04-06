package CRUD;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Add extends JFrame{

	private JButton button1;
	private JButton button2;
	private JPanel panel;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private TextField textField1;
	private TextField textField2;
	private TextField textField3;
    private TextArea textArea;
	
	
	
	
	public Add() {
         initData();
         setLayout();
	}
	private void initData() {
		setTitle("추가");
		setSize(600,550);
		Dimension dimension = new Dimension(470, 500);
		Dimension dimension1 = new Dimension(445, 270);
		Dimension dimension2 = new Dimension(222, 30);
		
		panel = new JPanel();
		
		panel.setPreferredSize(dimension);	
		textArea = new TextArea();
		panel.add(textArea);
		textArea.setPreferredSize(dimension1);
		button1 = new JButton("추가하기");	
		button2 = new JButton("나가기");	
		button1.setPreferredSize(dimension2);
		button2.setPreferredSize(dimension2);
		label1 = new JLabel("이름");
		label1.setPreferredSize(dimension2);
		label2 = new JLabel("전화번호");
		label2.setPreferredSize(dimension2);
		label3 = new JLabel("주소");
		label3.setPreferredSize(dimension2);
		
		textField1 = new TextField(60);
		textField2 = new TextField(60);
		textField3 = new TextField(60);
		add(panel);
		panel.setBackground(Color.cyan);
		panel.add(label1);
		panel.add(textField1);
		
		panel.add(label2);
		panel.add(textField2);
		
		panel.add(label3);
		panel.add(textField3);
		
		panel.add(button1);
		panel.add(button2);
	}
	private void setLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	public static void main(String[] args) {
		new Add();
		
	}
}
