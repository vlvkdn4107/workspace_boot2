package ch02;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		MemberInfoDao memberInfoDao = new MemberInfoDao();
		
//		ArrayList<MemberDto> data = memberInfoDao.select();
//		System.out.println(data);
		
		// 오브젝트를 통으로 던지게 했기때문에 
		MemberDto dto = new MemberDto("abc", "강감찬", "서울시 동작구");
//		memberInfoDao.update(dto);
		int returnRow = memberInfoDao.delete("abc");
		System.out.println("returnRow :" + returnRow);
		
		
	}

}
