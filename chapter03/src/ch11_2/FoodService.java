package ch11_2;

public interface FoodService {
    //추가
    void addFood(Food food);
    //조회
    void selectedFood(String name);
    //수정
    void updateFood(String name, Food food);
    //삭제
    void deleteFood(Food food);
    //전체 조회
    void showinfoAll();
	
	
}
