package ch11;

public class ArrTest {

	public static void main(String[] args) {
	
		//선언방법
		//생성
		int[] arrInt1 = new int[5];
		int arrInt2[] = new int[5];
		//생성과 동시에 값 넣기
		int[] arrInt3 = {1, 2, 3, 4, 5};
		
		Fruit fruits[] = new Fruit[5];
		fruits[0] = new Banana("바나나", 2000, 70);
		
		for (int i = 0; i < fruits.length; i++) {
			fruits[i] = new Fruit("바나나", 2000, 70);
			fruits[i].showInfo();
		}
	}

}
