package ch02;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.Test;

public class MainTest1 {

	public static void main(String[] args) {
		
		//JSON을 받는것을 확인 (Response 응답)
		
		//JSON형식으로 보낼수도 있다
		
		//자바 문법에서 json형식을 만드는 방법
//		String a = "{"\a\" : b}";
		
		JsonObject jsonObject1 = new JsonObject(); // String int boolean 넣을수있다
		jsonObject1.addProperty("이름", "홍길동");
		jsonObject1.addProperty("나이", 23); 
		jsonObject1.addProperty("직업", "CEO");
		jsonObject1.addProperty("취미", "노래");
		jsonObject1.addProperty("결혼여부", false);
		
		//jsonObject1 값을 꺼내보자
		System.out.println(jsonObject1);//주소값 확인
		System.out.println(jsonObject1.get("이름")); // key값을 꺼내주면된다.
		System.out.println(jsonObject1.get("나이")); // key값을 꺼내주면된다.
		System.out.println(jsonObject1.get("직업")); // key값을 꺼내주면된다.
		System.out.println(jsonObject1.get("취미")); // key값을 꺼내주면된다.
		System.out.println(jsonObject1.get("결혼여부")); // key값을 꺼내주면된다.
		System.out.println(jsonObject1.get("결혼여부111")); // key값을 잘못 입력하게 되면 null이라고 표기 된다.
		
		
		//깊은 복사와 얉은 복사 개념 이해해보기
		JsonObject b = jsonObject1; //b에 jsonObject1을 담는다(b랑 jsonObject1이랑 같은 heap영역에있는 놈을 바라본다
		System.out.println("================");
		
		b.addProperty("안녕", "hi");
		System.out.println(jsonObject1);//여기까지 얉은 복사개념
		
		//깊은 복사(deepCopy)
		JsonObject c = jsonObject1.deepCopy();// c라는 이름을 가진 오브젝트에 jsonObject1 값이 담겨졌다
		c.addProperty("test", "1234"); // jsonObject1에는 변화가 없다
		System.out.println("===============");
		System.out.println(jsonObject1);
		System.out.println("===============");
		System.out.println(c);
		
		//JSONArray
		JsonArray array1 = new JsonArray(); // array형식으로 문자열을 만들겠다
		array1.add(b);
		array1.add(c);
		System.out.println("=======@@@@@@@@@@@========");
		System.out.println(array1); // 리스트안에 b오브젝트 c오브젝트/ 2개가 담겨져있다
		System.out.println("=======@@@@@@@@@@@========");
		//꺼내는 방법
		System.out.println(array1.get(0));
		System.out.println(array1.get(1));
		System.out.println("=======@@@@@@@@@@@========");
		
		//모델링(클래스를 만들어내서 담을거다)
		Gson gson;
//		Test test = gson.fromJson(array1.get(0), Test.class);
//		System.out.println(test);
		
		JsonObject j1 = new JsonObject();
		
		JsonArray a1 = new JsonArray();
		//두개에 object 타입이 필요해(문자열)
		JsonObject t1 = new JsonObject();
		
		//{"name" : "홍길동","age" ㅣ 20}
		t1.addProperty("name", "홍길동");
		t1.addProperty("age", 20);
		//{"name":"이순신","age":35}
		JsonObject t2 = new JsonObject();
		t2.addProperty("name", "이순신");
		t2.addProperty("age", 35);
		
		a1.add(t1);
		a1.add(t2);
		//{"arr":[{"name":"홍길동","age":20},{"name":"이순신","age":35}]}
		j1.add("arr", a1);
		System.out.println(j1);
	}

}
