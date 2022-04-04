package ch04;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class EventListener1 extends JFrame implements ActionListener {

	JButton button1;

	public EventListener1() {

		initDate();
		setInitLayout();
		addEventListener();

	}

	private void initDate() {
		setTitle("이벤트 리스터 연습1");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button1 = new JButton("button1");
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout());
		add(button1);
	}

	private void addEventListener() {
		//액션 일어나면 나에게 알려줘 -->이벤트를 등록 했다.
		//등록하다
		button1.addActionListener(this);// 버튼1에다가 액션리스너를 등록한다!! (나한테 알려줘)
	}
     //메서드가 호출 되어진다.
	//콜백 되어진다 -> 콜백 메서드(알람)(다시돌아온다)
	@Override
	public void actionPerformed(ActionEvent e) {
		 System.out.println(e.toString());
		//ectionPerformed 메서드를 통해서 동작을 처리 할꺼야 (라고 약속된거다)
		System.out.println("버튼이 클릭 되었습니다.");

	}

}
