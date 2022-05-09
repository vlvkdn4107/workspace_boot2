package ch02;

import java.util.ArrayList;

import ch03.ShopDbDao;
import ch03.UserDto;

public class MainTest {

	public static void main(String[] args) {
		MemberInfoDao memberInfoDao = new MemberInfoDao();
		ShopDbDao shopDbDao = new ShopDbDao(); 
		ArrayList<UserDto> data = shopDbDao.innerjoin1();
		System.out.println(data);
//		shopDbDao.leftJoin1();
//		shopDbDao.leftJoin2();
//		shopDbDao.buyInfo(null);
//		ArrayList<UserDto> data = shopDbDao.innerjoin1();
//		System.out.println(data);
		
//		ArrayList<MemberDto> data = memberInfoDao.select();
//		System.out.println(data);
		
		// 오브젝트를 통으로 던지게 했기때문에 
//		MemberDto dto = new MemberDto("abc", "강감찬", "서울시 동작구");
//		memberInfoDao.update(dto);
//		int returnRow = memberInfoDao.delete("abc");
//		System.out.println("returnRow :" + returnRow);
		
		
		
	}

}
