package ch01;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

public class BorderLayoutEx1 extends JFrame{

	private JButton button1;
	private JButton button2;
	private JButton button3;
	//諛곗튂愿�由ъ옄
	private Border borderLayout;
	
	public BorderLayoutEx1() {
		setTitle("�뀒�뒪�듃"); //super �깮�왂 媛��뒫
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//二쇱냼李쎌쓣 �떕�쑝硫� 肄섏넄李쎈룄 醫낅즺媛��맂�떎.//�겢�옒�뒪�씠由�.
		
		//媛앹껜�깮�꽦�븷�븣 硫붿꽌�뱶瑜� �샇異쒗빐�씪
		initDate();
		setInitLayout();
	}
	
	
	private void initDate() {
		button1 = new JButton("button1");
		button2 = new JButton("button2");
		button3 = new JButton("button3");
		borderLayout = new BorderLay();
	}
	private void setInitLayout() {
		this.setLayout((LayoutManager) borderLayout);
		this.add(button1, BorderLayout.NORTH);
		this.add(button2, BorderLayout.SOUTH);
		this.add(button3, BorderLayout.CENTER);
	}
	
}
