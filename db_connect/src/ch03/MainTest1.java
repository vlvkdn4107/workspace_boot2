package ch03;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch02.DBClient;


public class MainTest1 {

	public static void main(String[] args) {
		
		// 개념 한번더 잡기 
		// object는 main메서드에서 new 하기 때문에 언제 태어나서 언제 죽을수 있는것을 말하고
		// static 으로 만들어진 녀석들은 시작과 끝으로만 처리 되는 녀석들이다.
		//  DBClient.getInstance() 는 단 한번도 new를 한적이 없다 
		DBClient client = DBClient.getInstance();
		Connection connection = client.getConnection();
		
		ResultSet resultSet = null;
		
		// 데이터 한건 조회
//		Statement stmt = connection.createStatement();
		
		try {
			String selectQuery1 = "SELECT * FROM memberTBL WHERE memberId = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(selectQuery1);
			preparedStatement.setString(1, "Dang");
			 
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
			}
			System.out.println("===================================");
			String selectQuery2 = "SELECT * FROM memberTBL WHERE memberId IN(?, ?)"; // prepareStatement는 문자열이라는 표시를 안해줘도 알아서 해준다.
			preparedStatement = connection.prepareStatement(selectQuery2);
			preparedStatement.setString(1, "jee1");// 란 녀셕은 없으므로 출력이 안된다
			preparedStatement.setString(2, "Han");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("memberId"));
				System.out.println(resultSet.getString("memberName"));
				System.out.println(resultSet.getString("memberAddress"));
			}
			System.out.println("===================================");
//			String insertQuery = "INSERT INTO memberTBL VALUES(?,?,?)";
//			preparedStatement = connection.prepareStatement(insertQuery);
//			preparedStatement.setString(1, "boot1");
//			preparedStatement.setString(2, "개발자");
//			preparedStatement.setString(3, "서울 판교");
//			
//			int resultCount = 0;
//			resultCount = preparedStatement.executeUpdate();
//			//방어적 코드
//			if(resultCount >= 1) {
//				System.out.println("정상 등록 되었습니다");
//			}else {
//				System.out.println("동일한 아이디가 존재하거나  잘못된 입력입니다.");
//			}
			
			// 데이터 수정
			String updateQuery = "UPDATE memberTBL SET memberName = ? WHERE memberId = ?";
			preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, "이름변경1");
			preparedStatement.setString(2, "boot1");
			
			int updateCount = preparedStatement.executeUpdate();
			System.out.println("updateCount : " + updateCount);
			
			// 데이터삭제
			String deleteQurey = "DELETE FROM memberTBL WHERE memberId = ?";
			preparedStatement = connection.prepareStatement(deleteQurey);
			preparedStatement.setString(1, "boot1");
			
			int deleteCount = preparedStatement.executeUpdate();
			System.out.println(deleteCount);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
	}

}
