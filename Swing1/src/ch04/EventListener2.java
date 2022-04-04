package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListener2 extends JFrame implements ActionListener{

	JButton button1;
	JButton button2;
	
	public EventListener2() {

        initDate();
        setInitLayout();
        addEventListener();
	}
	private void initDate() {
		setTitle("이벤트 리스너 연습2");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
		button2 = new JButton("button2");
	}
	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		add(button1);
		add(button2);
	}
	private void addEventListener() {
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼1  버튼2 눌러졌을때 구분을 해야한다.
		//첫번째 방법
//		System.out.println(e.getActionCommand() + " 이 클릭 되었습니다");// 객체의 이름이 나온다
//		if(e.getActionCommand().equals(button1.getText())){
//			System.out.println("버튼1");
//		}else {
//			System.out.println("버튼2");
//		}
		
		
		
		//두전째 방법
//		Object obj =  e.getSource();
		//하지만 우리는 object -->JButton(파악가능)
		JButton seletedBtn = (JButton) e.getSource();//다운캐스팅
		if(seletedBtn.getText().equals(this.button1.getText())) {
			System.out.println(button1.getText() + "가 클릭 되었습니다/");
		}else {
			System.out.println("버튼 2가 클릭되었습니다.");
		}
		
		
//		System.out.println(e.toString());
//		System.out.println(button1 + "버튼1");
//		System.out.println(button2 + "버튼2 클릭되었습니다");
//		//문제1
		// 버튼1이 눌러졌는지 버튼2가 눌러졌는지 구분해서 화면에 출력하세요
		
	}
}
