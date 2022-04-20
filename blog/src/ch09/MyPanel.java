	package ch09;
	
	import java.awt.Color;
	import java.awt.FlowLayout;
	import java.awt.GridLayout;
	
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	
	public class MyPanel extends JFrame{
	
		private JPanel panel1;
		private JPanel panel2;
		
		private JButton button1;
		private JButton button2;
		private JButton button3;
		private JButton button4;
		private JButton button5;
		
		
		public MyPanel() {
			initData();
			setInitLayout();
		}
		private void initData() {
			setTitle("패널연습");
			setSize(500,500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			panel1 = new JPanel();
			panel1.setBackground(Color.CYAN);
			
			panel2 = new JPanel();
			panel2.setBackground(Color.green);
			
			button1 = new JButton("버튼1");
			button2 = new JButton("버튼2");
			button3 = new JButton("버튼3");
			button4 = new JButton("버튼4");
			button5 = new JButton("버튼5");
			
			add(panel1);
			add(panel2);
			
		}
		private void setInitLayout() {
			setVisible(true);
			setLayout(new GridLayout(2, 1));
			panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
			panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			panel1.add(button1);
			panel1.add(button2);
			panel1.add(button3);
			
			panel2.add(button4);
			panel2.add(button5);
		}
		
		
		public static void main(String[] args) {
	
			new MyPanel();
	
		}
	
	}
