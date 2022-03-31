package ch01;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{

	
	public MyFrame() {
		super.setTitle("MyFrame");//JFrame에있어서 setTitle을 쓸수있다
		super.setSize(500,500);
		super.setVisible(true);
//		super.setDefaultCloseOperation(ABORT);	
	}
	
	
	
	
	public static void main(String[] args) {
		
//    new MyFrame();//메모리에 바로 올림
     String title = JOptionPane.showInputDialog("입력값 받기");
     System.out.println(title);
		
		
		
		
		
	}// end of main

} // end of class
