package ch03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyCompoments extends JFrame{


	private JPanel jPanel;
	private JButton button;
	private JLabel label;
    JTextField textfield;
	private JPasswordField passwordField;
	private JCheckBox checkBox;
	
	
	public MyCompoments() {
		initDate();
		setInitLayout();
	}
	
	private void initDate() { //초기화하는 부분
		setTitle("컴포넌트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		
		jPanel = new JPanel();
		
		Dimension dimension = new Dimension(300, 300);
		
		jPanel.setPreferredSize(dimension);//j패털 크기 잡기
		
		
		button = new JButton("button");
		label = new JLabel("라벨");
		textfield = new JTextField("아이디",20);
		
        passwordField = new JPasswordField("비밀번호",20);
        checkBox = new JCheckBox("checkBox", true);
		
	}
	
	private void setInitLayout() {
	    setVisible(true);
	    setLayout(new FlowLayout(FlowLayout.LEFT,100,200));//굳이 여기에서만 사용할거면 바로 선언할수있
	                                           //left top
	    add(jPanel);
	    jPanel.setBackground(Color.BLUE);
	    jPanel.add(button); //this.add(button);//j패널 안에 버튼을 추가
	    jPanel.add(label);
	    jPanel.add(textfield);
	    jPanel.add(passwordField);
	    jPanel.add(checkBox);
	    }
	
public static void main(String[] args) {
	new MyCompoments();
}
	
}
