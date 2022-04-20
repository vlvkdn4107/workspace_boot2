package tenco.com.data_structure;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class DatastructureTest2 {
  public static void main(String[] args) {
	 Map map;
	 // key value 구조로 데이터를 저장한다.(null값 허용)
	  HashMap<String, String> map1 = new HashMap<>();
	  
	  //key와value에 null값을 허용하지 않는다
	  Hashtable<String, String> map2 = new Hashtable<>();
	 
	  map1.put("A01", "김포공항정문");
	  map1.put("A02", "김포공항후문");
	  map1.put("A03", "김포공항로비");
	  map1.put("B01", "인천공항정문");
	  map1.put("B02", "인천공항후문");
	  map1.put("B03", "인천공항로비");
	  map1.put("C01", "null");
	  
	  System.out.println(map1);
	  System.out.println(map1.get("A03"));
	  System.out.println(map1.get("C01"));
	  
	  //삭제방법
	  map1.remove("C01");//키 값은 대소문자를 확실하 구별한다
	  map1.remove("cO1");
//	  map1.clear();// 전부 삭제
	  System.out.println(map1);
	  
	  //사이즈 확인 방법
	  System.out.println(map1.size());
	  
	  //map 계열에서 for 문을 사용하는 방법
	  //첫번째 방법(java.utill.Map.Entry << 활용!
	  for (Entry<String, String> entry : map1.entrySet()) {
		  System.out.println("key:" +entry.getKey());
		  System.out.println("value:" +entry.getValue());		
	}
	  System.out.println("================================");
	  //두번째 방법( keyset()활용 Map계열 안에있는 메서드
	  for(String key : map1.keySet()) {
		  System.out.println("[key]" + key);
		  System.out.println("[value]" + map1.get(key));
	  }

}
}
