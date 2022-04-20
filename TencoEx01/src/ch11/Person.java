package ch11;


//Animal --> Human --> Person
public class Person extends Human{

	@Override
	public void hunt() {
		System.out.println("사람이 칼을 들고 사냥을 합니다.");
		
	}

}
