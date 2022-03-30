package ch05;

import java.util.Scanner;

public class UserInfoClient {
	
	public static final String MYSQL = "mysql"; //static 영역
	public static final String ORACLE = "oracle";
	
    
	public static void main(String[] args) {
		// 사용자한테 userInfo 정보를 받는다.
		//유저인포 스캐너를 받아서 흐름을 만들어 주세요
		UserInfo info = new UserInfo();
		
	    Scanner sc = new Scanner(System.in);
		
		
		info.setUserid("vlvkdn");
		info.setPassword("11111");
		info.setUserName("히히히");
		
		String userinput = sc.nextLine();
		
		//인터페스으를 활용해서 사용하기!
		//1. 
		//객체생성!
//		UserInfoMySqlDao mySqlDao = new UserInfoMySqlDao();
//		mySqlDao.insertUserInfo(info);
		//2. B
//		UserInfoOracleDao oracleDao = new UserInfoOracleDao();
//		oracleDao.insertUserInfo(info);
		
		
//		String str = new String("mysql"); //힙 영역
		//equals는 문자열에 값을 비교합니다.
		//==는 객체에 주소값을 비교 합니다.
		
		//문자열을 비교할때는 무조건 equals 라는것을 사용한다.
		
		
		//userinfodao 변수를 선언
		UserInfoDao dao = null;
		//if(){}
//		if("str" == MYSQL)
	//  if("mysql == MYSAL) 같다고 나온다
	      //if(이문자가.equals(이문자가 같으면)
//		if("mysql".equals(MYSQL)) {
//			System.out.println("문자열이 같습니다");
//		}else {
//		    System.out.println("문자열이 다릅니다.");
//		}
		
		//1. mysql 문자열이면 --> userInfoMySqlDao 동작 (if else)
		//   orcle 문자열이면 --> userInfoOracleDao 동작
		//   단. 다형성을 사용해서 처리 해주세요.
		
		
		
		//스캐너 사용
		
		String str = "oracle";
		
		
		if(userinput.equals(MYSQL)) {//유저가 입력만 값이 MYSQL와 문자열이 같으면~~
		   dao = new UserInfoMySqlDao();			
		}else if(userinput.equals(ORACLE)) {
			dao = new UserInfoOracleDao();
		}else {
			System.out.println("잘못된 입력 입니다.");
		}
		//방어적 코드
		// 1.아이디를 입력세요 
		
		if(dao != null) {
			dao.insertUserInfo(info);
		}
		
	}



	
}
