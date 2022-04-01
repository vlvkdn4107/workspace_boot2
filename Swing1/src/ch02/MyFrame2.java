package ch02;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame2 extends JFrame{

	private BorderLayout borderLayout;
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<String> directions = new ArrayList<String>();
	
	
	
//	 private String[] directions = {
//	            BorderLayout.NORTH, BorderLayout.CENTER, 
//	            BorderLayout.SOUTH, BorderLayout.EAST,
//	            BorderLayout.WEST };
	public MyFrame2() {
	   initDate();
	   setInitLayout();
	   
	}
	
	private void initDate() {
	    setTitle("BorderLayout ArrayList Tset");
	    setSize(400,400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    borderLayout =new BorderLayout();
	    
	    
	    buttons.add(new JButton("북"));
	    buttons.add(new JButton("센터"));
	    buttons.add(new JButton("남"));
	    buttons.add(new JButton("동"));
	    buttons.add(new JButton("서"));
	    
	    directions.add(BorderLayout.NORTH);
	    directions.add(BorderLayout.CENTER);
	    directions.add(BorderLayout.SOUTH);
	    directions.add(BorderLayout.EAST);
	    directions.add(BorderLayout.WEST);
	    
	 
	    
	}
	
	private void setInitLayout() {
		setVisible(true);
		setLayout(borderLayout);
		 for (int i = 0; i < buttons.size();i++) {	
			add(buttons.get(i), directions.get(i));
//			add(directions.get(i));
			}
		
		
	}

	


	
}
