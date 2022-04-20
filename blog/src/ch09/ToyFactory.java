package ch09;

public class ToyFactory<T extends ToyMaterial> {

	private T toyMaterial;

	public T getToyMaterial() {
		return toyMaterial;
	}

	public void setToyMaterial(T toyMaterial) {
		this.toyMaterial = toyMaterial;
	}

	@Override
	public String toString() {
		return toyMaterial + "만드는 중";
	}
	
	
	
}
