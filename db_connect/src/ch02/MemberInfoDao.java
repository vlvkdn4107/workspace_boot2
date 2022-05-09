package ch02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.SqlUpdateResult;

public class MemberInfoDao implements ImemberinfoDao{

	private static final String TABLE_NAME = "memberTBL";
	//포함관계로 DBClient 를 통해서 DB접속 처리를 하자!!!!
	private DBClient dbClient;
	private Connection conn;
	
	public MemberInfoDao() {
		//초기화
		dbClient = DBClient.getInstance();
		conn = dbClient.getConnection();
	} 
	
	
	
	
	@Override
	public ArrayList<MemberDto> select() {
		
		ArrayList<MemberDto> dataResult = new ArrayList<MemberDto>();
		
		//쿼리문 
		String sqlFormat;
		String sql;
		sqlFormat = "SELECT * FROM %s";
		sql = String.format(sqlFormat, TABLE_NAME);
		
		//준비물
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {			 
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setMemberId(rs.getString("memberId"));
				dto.setMemberName(rs.getString("memberName"));
				dto.setMemberAddress(rs.getString("memberAddress"));
				
				dataResult.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return dataResult;
	}

	@Override
	public int insert(MemberDto dto) {
		String sqlFormat = "INSERT INTO %s VALUES('%s', '%s', '%s')"; // 문자열 표시를 해줘야한다!
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberId(), dto.getMemberName(), dto.getMemberAddress());
		
		Statement stmt = null;
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
//			stmt.executeQuery(sql); executeUpdate
			System.out.println("result : 행(레코드) 객수 " + result );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close(); // 역순으로 닫아줘야한다!
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return result;
		
	}

	@Override
	public int update(MemberDto dto) {
		// 해당 레코드 존재 여부 검사 select
//		if(dto.getMemberAddress() != null) {
//			
//		}else {
//			
//		}
		String sqlFormat = "UPDATE %s SET memberName = '%s' WHERE memberId = '%s' ";
		String sql = String.format(sqlFormat, TABLE_NAME, dto.getMemberName(), dto.getMemberId());
		int result = 0;
		
		try(Statement stmt = conn.createStatement()){
			result = stmt.executeUpdate(sql);
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public int delete(String memberId) {
		String sqlFormat = "DELETE FROM %s WHERE MEMBERID = '%s' ";
		String sql = String.format(sqlFormat, TABLE_NAME, memberId);
		int result = 0;
		
		try(Statement stmt = conn.createStatement()){
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
		return result;
	}

	
	
	
	
}
