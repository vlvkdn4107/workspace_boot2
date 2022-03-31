package ch1_1;

import java.util.Scanner;

public class For3 {

	public static void main(String[] args) {
		System.out.print("1. 피라미드 층수를 입력해주세요:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		

		for(int a=1; a<=num; a++){ //a는 1부터; a는 인풋한 숫자까지;  a는증감연산자(+1씩) 
			
			
			for(int b =num ;b>a ; b--) { //
				System.out.print(" "); //비가 에이보다 크면 실행
				
				
			} // end of inner for1
			for(int c = 0 ; c< (a*2-1) ; c++) {
				System.out.print("*");
				
				
			} // end of inner for2
			
			System.out.println();
		} //end of outer for

	}

}
