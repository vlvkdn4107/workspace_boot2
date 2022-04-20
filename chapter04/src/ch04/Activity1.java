package ch04;

import java.awt.Color;

public class Activity1 extends BaseActivity{

	//변수 선언,초기화 (콜백 메서드)
	CallbackCheckPosition callback = new CallbackCheckPosition() {
		
		@Override
		public void checkPosition(int x, int y) {//콜백받는 공간
			System.out.println(name + "가 콜백을 받았습니다." + x);
			System.out.println(name + "가 콜백을 받았습니다." + y);
			
		}
	};
	
	public Activity1(String name) {//부모크래스에 생성자가 있기때문에 불러와야된다
		super(name);
		
	}
	
	@Override // <-- 주석 같은 녀석임 (@Override) 주석은 컴파일러가 무시하지만 @은 무시하지 않는다.
	          //컴파일러시점에 오버라이드 메서드는 부모의 initData라는 메서드가 정의 되있어라고 컴파일러한테 알려주는거다 그리고 있는지 없는지 확인하고 없으면 오류로 알려준다
	protected void initData() {
		super.initData();
		
	}
	@Override
	protected void setInitLayout() {
		super.setInitLayout();//슈퍼라는 키워드로 부모의 메서드를 확인하고 백그라운드를 같이 하는거다
		panel.setBackground(Color.blue);
	}
	
}
