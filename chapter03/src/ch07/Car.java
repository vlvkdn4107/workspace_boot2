package ch07;

public class Car {

	private String name;
	private int carnb;

	
	public Car(String name,int carnb) {
		this.name =name;
		this.carnb = carnb;
	}
	
	
	@Override
	public String toString() {
		return "Car name= " + name +"/"+"차번호 = " + carnb;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Car) {
			Car tempCar = (Car)obj;
			String name = tempCar.name;
			if(this.name == name) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Car) {
//			Car tempCar = (Car)obj;
//			String name = tempCar.name;
//			int carnb = tempCar.carnb;
//			if(this.name == name) {
//				
//			}
//		}
//		
//	}

}
