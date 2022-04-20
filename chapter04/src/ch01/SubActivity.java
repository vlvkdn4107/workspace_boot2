package ch01;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//콜백 호출자(콜리) : 멤버변수로 징검다리 역할을 하는 인터페이스를 멤버 변수로 먼저 선언한다.
public class SubActivity extends JFrame {

	JButton button1;
	//마이너스 버튼하나+1
	JButton button2;
	//값을 전달 하는 버튼+1 
	
	JButton button3;
	JButton button4;
	int result = 999;
	ICallbackBtnAction callbackBtnAction; //선언만 하기
	
	//콜리는 : 콜백 받는 객체의 주소값을 알고 있어야 메서드가 subActivity에서 호출 되었다고 알릴수 있다.
	public SubActivity(ICallbackBtnAction iCallbackBtnAction) {
		this.callbackBtnAction = iCallbackBtnAction;//주소값을 넘겨 받는다.
		
		
		setSize(300,300);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		button1 = new JButton("더하기 버튼");
		button2 = new JButton("빼기 버튼");
		button3 = new JButton("result");
		button4 = new JButton("값전달");
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		button1.addActionListener(new ActionListener() {//익명 객체 구현해주기	
			@Override
			public void actionPerformed(ActionEvent e) {//악명 객체
//				System.out.println("더하기 버튼 클릭!!!");
				//하지만 new하지 않아서 null포인트 오류가 뜬다
				callbackBtnAction.clickedAddBtn();				
			}
		});
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("빼기 버튼 클릭!");
				callbackBtnAction.clickedMinusBtn();				
			}
		});
		
		button3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				callbackBtnAction.clickedMaxBtn(result);				
			}
		});
		button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				callbackBtnAction.pass(result);
				
			}
		});
		
		
	}
	
	
}
