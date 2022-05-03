package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest3 {

	private Connection conn;
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "asd123";
	private static final String URL = "jdbc:mysql://localhost:3306/shopdb?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";

	private Statement stmt;
	private ResultSet rs;

	public MainTest3() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("select b.userName, b.prodName, b.price, b.amount, timestamp('2022-05-01','12:13:21') as 주문날짜, u.addr, u.mobile,(select date_add(주문날짜, interval 5 day)) as 도착날짜 from buyTBL as b left join usertbl as u on b.userName = u.userName where b.userName = '이승기'");

			while (rs.next()) {
				String userName = rs.getString("userName");
				String prodName = rs.getString("prodName");
				String price = rs.getString("price");
				String amount = rs.getString("amount");
				String addr = rs.getString("addr");
				String mobile = rs.getString("mobile");
//				String timestamp = rs.getString("timestamp");
//				String date_add = rs.getString("date_add");
				System.out.println("userName :" + userName + ", " + "prodName :" + prodName 
						            + ", " + "price :" + price + ", " + "amount :" + amount
						            + ", " + "addr :" + addr + ", " + "mobile :" + mobile);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// buytbl
	public static void main(String[] args) {
		new MainTest3();

	}

}
