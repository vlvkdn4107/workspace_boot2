package ch11;

public class ArrTest2 {

	public static void main(String[] args) {
		int[] numbers3;
		numbers3 = new int[] {10, 20, 30, 40, 50};
		
		//인덱스를 활용하여 설계해야 할때
		for (int i = 0; i < numbers3.length; i++) {
			System.out.println(numbers3[i]);
		}
		System.out.println();
		
		//확장 for문
		//처음부터 끝까지 전체를 단순하게 찍을때
		for(int i : numbers3) {
			System.out.println("출력값 :" + i);
		}
	}

}
