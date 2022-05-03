package ch03;

import java.util.ArrayList;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //생성자만들어주는놈
@ToString
class Student{
	String name;
	int age;
	String address;
}

public class MainTest2 {

	public static void main(String[] args) {
		 
		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 33, "서울");
		Student student3 = new Student("세종대왕", 59, "세종시");
		
		//Object를 --> 형식이 있는 문자열로 바꾸기(Json)
		Gson gson = new Gson();
		String jsonStr = gson.toJson(student1);
		System.out.println(jsonStr);
		System.out.println("------------------------------");
		
		
		//ArrayList(Object) ----> JsonArray(Object)
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		System.out.println(list); // tostring안해주면 주소값으로 출력함
		System.out.println("------------------------------");
		
		String jsonArray = gson.toJson(list);
		System.out.println(jsonArray);
	}

}
