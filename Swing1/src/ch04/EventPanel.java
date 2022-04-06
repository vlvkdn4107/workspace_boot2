package ch04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EventPanel extends JFrame implements ActionListener {

	private JPanel jPanel1;
	private JPanel jPanel2;

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;

	public EventPanel() {
		initDate();
		setInitLayout();
		
	}

	private void initDate() {
		setTitle("패널연습");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jPanel1 = new JPanel();

		jPanel1.setBackground(Color.red);

		

		jPanel2 = new JPanel();
		jPanel2.setBackground(Color.green);

		button1 = new JButton("1번");
		button2 = new JButton("2번");
		button3 = new JButton("3번");
		button4 = new JButton("4번");

	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new GridLayout(2, 1));
		jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(jPanel1);
		add(jPanel2);
		jPanel1.add(button1);
		jPanel1.add(button2);
		button1.add(jPanel1).setBackground(Color.blue);

		jPanel2.add(button3);
		jPanel2.add(button4);
		
		
		
		
	}

//	private void addEventListener() {
//		button1.addActionListener(this);
//		button2.addActionListener(this);
//		button3.addActionListener(this);
//		button4.addActionListener(this);
//	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//          
//	
//		
//	
//		
//		
//	}

	public static void main(String[] args) {
		new EventPanel();
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}// end of class
