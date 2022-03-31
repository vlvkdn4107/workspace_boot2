package ch11_2;

public class FoodClient {

	private static int serialNumber = 0;
	
	public Food createFood(String name,int price) {
		serialNumber++;
		return new Food(serialNumber, name, price);
	}
	
	
}
