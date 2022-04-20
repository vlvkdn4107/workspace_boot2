package ch11;

public abstract class Animal {
	String name;
	
	public  void move() {
		System.out.println("이동 합니다");
	}
	public abstract void hunt();
	
	public static void main(String[] args) {
		//기본적으로 추상 클래스는 new라는 키워드를 사용해서 메모리에 올릴수 없다.
		Animal animal; // = new Animal();
}
}
