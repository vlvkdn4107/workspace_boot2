package ch06;

import java.sql.Connection;

import java.sql.ResultSet;

public class SelectDao {

	private DBClient dbClient = DBClient.getInstance();
	Connection connection = dbClient.getConnection();
	
	ResultSet resultSet = null;
	
	
}
