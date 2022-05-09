package ch03;

import java.util.ArrayList;

public interface IShopDbDao {

	// userTbl, buytbl 결과 *
	ArrayList<UserDto> innerjoin1();	
	
	// usertbl, buytbl null 제거, 결과 *
	void leftJoin1();
	
	// buytbl usertbl 결과 *
	void leftJoin2();
	
	// 이순신, 김유신(전화주소,주소)
	ArrayList<UserDto> buyInfo(UserDto dto);
	
}
