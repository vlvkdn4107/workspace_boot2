package ch03;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.User;

public class MainTest {

	public static void main(String[] args) {
		
		
		JsonArray a1 = new JsonArray();
		JsonObject json1 = new JsonObject();
	    JsonObject json2 = new JsonObject();
	    JsonObject json3 = new JsonObject();
	    
	    json1.addProperty("name", "홍길동");
	    json1.addProperty("age", 20);
	    json1.addProperty("address", "부산");
	    json2.addProperty("name", "이순신");
	    json2.addProperty("age", "33");
	    json2.addProperty("address", "서울");
	    json3.addProperty("name", "세종대왕");
	    json3.addProperty("age", 59);
	    json3.addProperty("address", "세종시");
	    
	    System.out.println(json1);
	    System.out.println(json2);
	    System.out.println(json3);
	    
	    a1.add(json1);
	    a1.add(json2);
	    a1.add(json3);
	    System.out.println(a1);
	    Gson gson = new Gson();
	    String json= gson.toJson(a1);
	    System.out.println(json);
	    
	    
	    JsonObject j1 = new JsonObject();
	    JsonArray arr = new JsonArray();
	    JsonObject jsOb1 = new JsonObject();
	    JsonObject jsOb2 = new JsonObject();
	    jsOb1.addProperty("id", 1);
	    jsOb1.addProperty("title", "청소");
	    jsOb1.addProperty("complete", false);
	    jsOb2.addProperty("id", 2);
	    jsOb2.addProperty("title", "영어공부");
	    jsOb2.addProperty("complete", true);
	    
	    arr.add(jsOb1);
	    arr.add(jsOb2);
	    
	    j1.add("todoList",arr);//j1에 array를 넣는다
	    System.out.println(j1);
	    
	    
	    
	    JsonArray array = new JsonArray();
	   
	    
	    
	    
	}

}
