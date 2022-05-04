package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBClient {

	private static final String DB_HOST = "localhost";
	private static final int DB_PORT = 3306;
	private static final String DB_DATABASE_NAME = "shopdb";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "root";
	private static final String DB_PASSWORD = "asd123";
	
	//DB에만 존재하는 클라이언트
	private Connection conn; // 기본은 null값
	
	//싱글톤 처리
	private static DBClient dbClient;
	
	private DBClient() {
		
	}
	
	public static DBClient getInstance() {
		if(dbClient == null) {
			dbClient = new DBClient();
			
		}
		return dbClient;
	}
	
	public Connection getConnection(){
		if(conn == null) {
			// "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
			// s는 문자열 d는 정수값을 의미한다.
			String urlFormat = "jdbc:mysql://%s:%d/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST,DB_PORT, DB_DATABASE_NAME,DB_CHARSET);
			
			//MySQL JDBC 드라이버 클래스를 로딩해서 driverManager 클래스에 등록한다.
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				// DriverManager 객체를 사용하여 DB서버에 접근 할수있다.
				conn = DriverManager.getConnection(url, DB_USER_NAME,DB_PASSWORD); // 커넥션 녀석에 url이랑 데이터베이스 이름 패스워드가 담겼다
				System.out.println(">>>>Connection Success<<<<<");
				
			} catch (Exception e) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		return conn;
	
	}
	
	public void connectionClose() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
