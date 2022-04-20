package tenco.com.data_structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DatastructureTest1 {
	public static void main(String[] args) {
		List list0;
		// 중간에 데이터를 추가 하거나 삭제가 용이하다.

		// 순서가 있고(인덱스) 중복이 가능하다.
		// 선언 방법
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list1 = new ArrayList<>();

		// 선언과 동시에 초기화
		ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
		
		// 값 추가 방법
		list3.add(4);
		list3.add(null);
		System.out.println(list3);

		list3.add(1, 10);
		System.out.println(list3);

		// 삭제
		list3.remove(5);
		System.out.println(list3);

		// 전체삭제
//         list3.clear();

		// 출력방법
		System.out.println(list3.get(3));

		// 추가적인 메서드 확인
		System.out.println(list3.size());
		System.out.println(list3.isEmpty());

		// for

		for (Integer i : list3) {
			System.out.println("i :" + i);
		}

		// while
		// 요소 순회(반복자) 컬렉션 프레임워크에 저장된 요소들을 하나씩 차례 참조한다.
		Iterator<Integer> iter = list3.iterator();
		while(iter.hasNext()) {
			System.out.println("while :" + iter.next());
		}
		
		//
		System.out.println(list3.contains(500));
		System.out.println(list3.contains(10));
		
		//indexOf
		//인덱스에 값이 있으면 인덱스 번호를 반환하거나 없으면 -1을 반환 한다
		System.out.println(list3.indexOf(0));
		System.out.println(list3.indexOf(1));
		System.out.println(list3.indexOf(4));
		System.out.println(list3.indexOf(100));
		

	}
}
