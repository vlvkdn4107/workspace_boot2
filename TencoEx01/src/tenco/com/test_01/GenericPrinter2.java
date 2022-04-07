package tenco.com.test_01;

//T 자료형에대한 제한을 지정할수있다. <T extends Material>
public class GenericPrinter2<T extends Material> {

	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	@Override
	public String toString() {
		
		return material.toString();
	}

}
