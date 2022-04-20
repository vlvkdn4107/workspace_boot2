package ch04_1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//호출자
public class Activity2_1 extends BaseActivity_1{

	CallbackCheckPosition_1 callbackCheckPosition_1;
	
	
	public void setCallbackCheckPosition_1(CallbackCheckPosition_1 callbackCheckPosition_1) {
		this.callbackCheckPosition_1 = callbackCheckPosition_1;
	}

	public Activity2_1(String name) {
		super(name);
		addEventListner();
		
	}
	
	private void addEventListner() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				callbackCheckPosition_1.checkPosition(x, y);//콜백체크 포지션 클래스 안에있는 체크포지면 메서드를 넣을거다
			}
		
		});
	}
	
}
