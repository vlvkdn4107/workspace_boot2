package ch09;

public class MainTest3 {

	public static void main(String[] args) {
		
		ToyFactory<GUNDAM> gundamFt = new ToyFactory<>();
		GUNDAM gundam = new GUNDAM();
		gundamFt.setToyMaterial(gundam);
		System.out.println(gundamFt);
		
		ToyFactory<Keroro> keroroFt = new ToyFactory<>();
		Keroro keroro = new Keroro();
		keroroFt.setToyMaterial(keroro);
		System.out.println(keroroFt);
	}

}
