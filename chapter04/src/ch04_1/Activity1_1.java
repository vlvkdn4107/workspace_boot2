package ch04_1;

import java.awt.Color;

//응답자
public class Activity1_1 extends BaseActivity_1{
	
	CallbackCheckPosition_1 cPosition_1 = new CallbackCheckPosition_1() {
		
		@Override
		public void checkPosition(int x, int y) {
			System.out.println(name + "콜백 받음" + x);
			System.out.println(name + "콜백 받음" + y);
			
		}
	};
	
	public Activity1_1(String name) {
		super(name);
		
	}
	
	@Override
	protected void initData() {
		super.initData();
	}
	
	@Override
	protected void setInitLayout() {
		super.setInitLayout();
		panel.setBackground(Color.cyan);
	}

}
