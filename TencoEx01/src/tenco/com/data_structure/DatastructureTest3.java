package tenco.com.data_structure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class DatastructureTest3 {

	public static void main(String[] args) {
		Set set;
		HashSet<Integer> set1 = new HashSet<>();
		set1.add(1);
		set1.add(1); // 중복 값
		set1.add(2);
		set1.add(2); // 중복 값
		set1.add(3);
		set1.add(3); // 중복 값
		set1.add(4);
		
		//중복 체크 할필요없이 중복을 자동으로 인지해서 사이즈를 잡는다.
		//중복하지 않는
		System.out.println(set1.size());
		
		//값을 삭제하면 중복된 값도 같이 삭제 된다
		set1.remove(1);
		System.out.println(set1);
		//전체 삭제도 가능하다
//		set1.clear(); 
//		System.out.println(set1);
		
		//while 활용 //이터럴을 활용해서 할수도있다
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			System.out.println("값 확인 : " + iter.next());
		}
		System.out.println("======================");
		
		HashSet<Integer> set2 = new HashSet<Integer>();
		set2.add(getRandom());
		while(set2.size() < 6) {
            set2.add(getRandom());
        }
		System.out.println(set2);
//		for (int i = 0; i < 6; i++) {
//			set2.add(getRandom());		
//			  if(set2.size() != i) {
//	                i = i -1;     
//			  }
//			  System.out.println(set2);
//		}
		  
		
	}//end of main
	public static int getRandom() {
		Random rd = new Random();
		int value = rd.nextInt(45)+1;
		return value;
		
	}
}
