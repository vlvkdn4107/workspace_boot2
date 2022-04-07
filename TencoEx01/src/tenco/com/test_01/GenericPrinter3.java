package tenco.com.test_01;
//T안에서만 강제성을 부여
public class GenericPrinter3<T extends Material>{
	private T mateiral;

	public T getMateiral() {
		return mateiral;
	}

	public void setMateiral(T mateiral) {
		this.mateiral = mateiral;
	}

	@Override
	public String toString() {
		return mateiral.toString();
	}
	
	
}
