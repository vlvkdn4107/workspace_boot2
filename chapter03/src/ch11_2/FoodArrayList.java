package ch11_2;

import java.util.ArrayList;

public class FoodArrayList implements FoodService{

	
	private ArrayList<Food> foods = new ArrayList<Food>();
	
	@Override
	public void addFood(Food food) {
		//추가
		System.out.println("음식을 추가합니다.");
		foods.add(food);
		showinfoAll();
		
		
	}

	@Override
	public void selectedFood(String name) {
		
		
	}

	@Override
	public void updateFood(String name, Food food) {
		
		
	}

	@Override
	public void deleteFood(Food food) {
		
		
	}

	@Override
	public void showinfoAll() {
		System.out.println(">>>>>현재 저장된 음식<<<<<");
		for (Food food : foods) {
			System.out.println(food);
		}
		
	}

}
