package ch1_1;

import java.util.Scanner;

public class For2 {

	public static void main(String[] args) {
		System.out.print("1. 피라미드 층수를 입력해주세요:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1 ; i <= num; i++) {
			
			for(int j=0 ;  j<i ; j++) {
				System.out.print("*");
			} // end of inner for
			System.out.println();
		} // end of outer for

	}

}
