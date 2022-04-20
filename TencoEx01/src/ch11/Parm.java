package ch11;

import java.util.Scanner;

public class Parm {
	
	private Carrot makeCarrot() {
		System.out.println("당근을 재배합니다");
		return new Carrot("당근1");
	}
	private Cucumber makeCucumber() {
		System.out.println("오이를 재배합니다");
		return new Cucumber("오이1");
	}
	private Pumpkin makePumpkin() {
		System.out.println("호박을 재배합니다");
		return new Pumpkin("호박1");
	}
	
	public Vegetable makeVegetable() {
		Scanner scanner = new Scanner(System.in);
		Vegetable vegetable = null;
		System.out.println("어떤 야채를 재배하겠습니까?");
		System.out.println("1. 당근 2. 오이 3.호박");
		int userInput = scanner.nextInt();
		
		if(userInput ==1) {
			vegetable = makeCarrot();
		}else if(userInput == 2) {
			vegetable = makeCucumber();
		}else if(userInput == 3) {
			vegetable = makePumpkin();
		}
		scanner.close();
		return vegetable;
		
	}
	
}
