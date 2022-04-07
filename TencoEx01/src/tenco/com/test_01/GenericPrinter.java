package tenco.com.test_01;

public class GenericPrinter<T> {
    //T라는 대체문자를 사용한다, E- element, K - key, V - value(사실 아무 문자나 상관없음)
	//위에 선언한 문자로 변수를 선언할수 있다
	private T meterial; //T 자료형으로 선언한 변수
//	private T name //T 자료형으로 선언한 변수

	public T getMeterial() {
//		return name;
		return meterial;
	}

	public void setMeterial(T meterial) {
		this.meterial = meterial;
	}
}
