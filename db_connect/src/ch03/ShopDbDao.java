package ch03;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch02.DBClient;

public class ShopDbDao implements IShopDbDao{

	private DBClient client = DBClient.getInstance();
	private Connection connection = client.getConnection();
	
	ResultSet resultSet = null;
	
	
	@Override
	public ArrayList<UserDto> innerjoin1() {
		
		ArrayList<UserDto> dataResult = new ArrayList<UserDto>();
		
		try {
			String innerjoin = "SELECT u.userName, b.prodName, b.price, b.amount FROM userTBL AS u INNER JOIN buyTBL AS b on u.userName = b.userName WHERE u.userName = ?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(innerjoin);
			preparedStatement.setString(1, "이순신");

			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				UserDto dto = new UserDto();
				dto.setUserName(resultSet.getString("userName"));
				dto.setProdName(resultSet.getString("prodName"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setAmount(resultSet.getInt("amount"));
				
				dataResult.add(dto);
//				System.out.println("userName : " + resultSet.getString("userName"));
//				System.out.println("birthYear : " + resultSet.getString("birthYear"));
//				System.out.println("addr : " + resultSet.getString("addr"));
//				System.out.println("mobile : " + resultSet.getString("mobile"));
//				System.out.println("userName : " + resultSet.getString("userName"));
//				System.out.println("prodName : " + resultSet.getString("prodName"));
//				System.out.println("price : " + resultSet.getString("price"));
//				System.out.println("amount : " + resultSet.getString("amount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataResult;
		
		
	}

	@Override
	public void leftJoin1() {
		
		try {
			String leftJoin = "SELECT * FROM userTBL AS u LEFT JOIN buyTBL AS b on u.userName = b.userName WHERE u.userName = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(leftJoin);
			preparedStatement.setString(1, "이승기");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			System.out.println("userName : " + resultSet.getString("userName"));
			System.out.println("birthYear : " + resultSet.getString("birthYear"));
			System.out.println("addr : " + resultSet.getString("addr"));
			System.out.println("mobile : " + resultSet.getString("mobile"));
			System.out.println("userName : " + resultSet.getString("userName"));
			System.out.println("prodName : " + resultSet.getString("prodName"));
			System.out.println("price : " + resultSet.getString("price"));
			System.out.println("amount : " + resultSet.getString("amount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void leftJoin2() {
		try {
			String leftJoin2 = "SELECT * FROM buyTBL AS b LEFT JOIN userTBL AS u on b.userName = u.userName";
			PreparedStatement preparedStatement = connection.prepareStatement(leftJoin2);

			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
			System.out.println("userName : " + resultSet.getString("userName"));
			System.out.println("prodName : " + resultSet.getString("prodName"));
			System.out.println("price : " + resultSet.getString("price"));
			System.out.println("amount : " + resultSet.getString("amount"));
			System.out.println("userName : " + resultSet.getString("userName"));
			System.out.println("birthYear : " + resultSet.getString("birthYear"));
			System.out.println("addr : " + resultSet.getString("addr"));
			System.out.println("mobile : " + resultSet.getString("mobile"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<UserDto> buyInfo(UserDto dto) {
		
		ArrayList<UserDto> dataResult = new ArrayList<UserDto>();
		
		try {
			
			String buyInfo = "SELECT b.userName, u.mobile, u.addr FROM buyTBL AS b LEFT JOIN userTBL AS u on b.userName = u.userName WHERE b.userName = ? OR b.userName = ?";
			String sql;
			sql = String.format(buyInfo, dto.getUserName(),dto.getProdName(), dto.getPrice(), dto.getAmount());
			PreparedStatement preparedStatement = connection.prepareStatement(buyInfo);
//			preparedStatement.setString(1, "이순신");
//			preparedStatement.setString(2, "홍길동");
			
			resultSet = preparedStatement.executeQuery(sql);
			while(resultSet.next()) {
				
				dto.setUserName(resultSet.getString("userName"));
				dto.setProdName(resultSet.getString("prodName"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setAmount(resultSet.getInt("amount:"));
				dataResult.add(dto);
//			System.out.println("userName :" + resultSet.getString("userName"));
//			System.out.println("mobile :" + resultSet.getString("mobile"));
//			System.out.println("addr :" + resultSet.getString("addr"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataResult;
	}

}
