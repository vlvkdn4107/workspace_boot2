package ch03;

import java.util.Scanner;

public class MainTest1 {

	public static void main(String[] args) {
		 MyCompoments compoments = new MyCompoments();//주소값에 접근해서 수정해야하기때문에 
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("글자를 입력하세요.");
		 String userinput = scanner.nextLine();
		  compoments.textfield.setText(userinput);
		//1, MyCom...... 화면에 띄우세요
		//2.textField 안녕하세요 라는 글자를 코드로 셋팅해주세요
		
		
		
		//
		

	}

}
