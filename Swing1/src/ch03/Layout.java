package ch03;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Layout extends JFrame{

	
	
	private JLabel jLabel;
	private JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox checkBox;
	
	private Panel panel1;
	private Panel panel2;
	private Panel panel3;
	
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	
	
	public Layout() {

        initDate();
        setInitLayout();
	}
	
	
	
	private void initDate() {
	    setTitle("연습");
	    setSize(800, 500);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel jPanel = new JPanel();
	    
	    Dimension dimension = new Dimension(300 , 300);
	    Dimension dimension2 = new Dimension(200 , 200);
	    Dimension dimension3 = new Dimension(100 , 100);
	    panel1.setBackground(Color.CYAN);
	    panel1.setPreferredSize(dimension);
	    panel2.setBackground(Color.pink);
	    panel2.setPreferredSize(dimension2);
	    panel3.setBackground(Color.ORANGE);
	    panel3.setPreferredSize(dimension3);
	    
	    button1 = new Button("1");
	    button1 = new Button("2");
	    button1 = new Button("3");
	    button1 = new Button("4");
	    button1 = new Button("5");
	    
	   
	    
	}
	
	
	
	
	private void setInitLayout() {
		setVisible(true);
		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(panel1);
		add(panel2);
		add(panel3);
		panel1.add(button1);
		panel1.add(button2);
		panel2.add(button3);
		panel3.add(button4);
		panel3.add(button5);
	}
	public static void main(String[] args) {
		new Layout();
	}
	
}
