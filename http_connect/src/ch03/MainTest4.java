package ch03;

import java.lang.reflect.Type;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor //생성자만들어주는놈
@ToString


public class MainTest4 {

	public static void main(String[] args) {
		Gson gson = new Gson();
		Student[] students = new Student[3];

		Student student1 = new Student("홍길동", 20, "부산");
		Student student2 = new Student("이순신", 33, "서울");
		Student student3 = new Student("세종대왕", 59, "세종시");
		
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		
		String studentArr = gson.toJson(students);
		System.out.println(studentArr);
		//Object를 --> 형식이 있는 문자열로 바꾸기(Json)
		
		String jsonStr = gson.toJson(student1);
	
		//ArrayList(Object) ----> JsonArray(Object)
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		
		//list -->json
		String jsonArray = gson.toJson(list);
		
		//자바에서 사용하는 object를 문자열로 변환(json)
		//서버측에 데이터를 보낼때 서버가 이해할수있는 문자열 (json)
		
		////////////////////////////////////////////////////////
		//서버에서 json을 던져준다면 우리가 java에서 사용하기 위해서 class로 변환해야 한다.
		//DTO개념을 배웠음!!!!!!!
		System.out.println(jsonStr);
		//파싱하는 방법 1.
//		Student objs1 = gson.fromJson(jsonStr, Student.class);
//		System.out.println(objs1.address);
//		System.out.println(objs1.name);
//		System.out.println(objs1.age);
//		System.out.println("=====================================");
		//파싱하는 방법 2.
//		Student[] objA1 = gson.fromJson(studentArr, Student[].class);
//		
//		for(Student student : objA1) {
//			System.out.println(student);
//		}
		
		
		
		
		//파싱하는 방법 3.(ArrayList)
		//jsonArray
		//import java.lang.reflect.Type;
		//import com.google.gson.reflect.TypeToken;
		//타입 명시함!
		Type moviesType = new TypeToken<ArrayList<Student>>() {}.getType();
		ArrayList<Student> arrayList = gson.fromJson(jsonArray, moviesType);
		for (Student student : arrayList) {
			System.out.println(student);
		}
		
		//파싱하는 방법 3가지
		//1.object
		//2.배열
		//3.ArrayList
	}

}
