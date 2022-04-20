package ch01;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
//콜백 받는 객체(응답자) : 우리가 만들었던 ICallbackBtnAction이라는 인터페이스를 구현해서 정의 하면된다.(추상메서드를 오버라이드 한다)
public class MainActivity extends JFrame implements ICallbackBtnAction{

	int count;
	JLabel label;
	SubActivity subActivity;
	public MainActivity() {
		count = 0; // 초기값 바로 설정 해주기
		label = new JLabel("count :" + count);//라벨 생성
		setSize(300, 300);//크기 셋팅
		setLayout(new FlowLayout());
		setVisible(true);
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new SubActivity(this);//다형성을 이용해서 this를 넣어준다.
	}

	@Override
	public void clickedAddBtn() {//ICallbackBtnAction에서 오버라이드
//		System.out.println("+ 버튼에 콜백 받았습니다");
		count++;
		label.setText("count :" + count);
	}

	
	// -버튼에 동작을 받는 콜백 메서드 정의
		// 값을 전달 받는 콜백 메서드 정의
	@Override
	public void clickedMinusBtn() {
		System.out.println("-버튼에 콜백 받았습니다");
		count--;
		label.setText("count :" + count);
	}

	@Override
	public void clickedMaxBtn(int result) {
		System.out.println(" result 콜백 받았음");
		count = count + result; 
		label.setText("count :" + count);
	}

	@Override
	public void pass(int result) {
		label.setText("전달 받은 값 :" + result);
		
	}
	
	
	
	
	
	
}
