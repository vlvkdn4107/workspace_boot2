package ch04;

import javax.swing.JFrame;
import javax.swing.JTable;

public class Table extends JFrame{

	JTable jTable;
	
	public Table() {
		initDate();
		setInitLayout();
	}
	private void initDate() {
	    setTitle("JTable");
	    setSize(500,200);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void setInitLayout() {
		
	}
}
