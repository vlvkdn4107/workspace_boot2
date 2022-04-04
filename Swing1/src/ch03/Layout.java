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
import javax.swing.JTable;
import javax.swing.JTextField;

public class Layout extends JFrame{

	
	JTable jtable;
	
   String [][] str= {
		   { "Sam", "29" ," Twinkle House" },
		   { "Anna Sam", " 27 ", "Happy Villa" },
		   { "Iza Norah", " 4 ", "Happy house" },
		   
   }
	
	public Layout() {

        initDate();
        setInitLayout();
	}
	
	
	
	private void initDate() {
	    setTitle("연습");
	    setSize(800, 500);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	   
	    
	}
	
	
	
	
	private void setInitLayout() {
		setVisible(true);
		
	public static void main(String[] args) {
		new Layout();
	}
	
}
