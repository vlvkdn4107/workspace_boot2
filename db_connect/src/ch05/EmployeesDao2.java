package ch05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch04.EmployeesDto;

public class EmployeesDao2 implements IEmployees2{

	private DBClient dbClient = DBClient.getInstance();
	Connection connection = dbClient.getConnection();
	
	ResultSet resultSet = null;
	
	@Override
	public ArrayList<EmployeesDto2> innerJoin1() {
		
		ArrayList<EmployeesDto2> dataResult = new ArrayList<EmployeesDto2>();
		
		try {
			String select1 = "SELECT emp_no, first_name, gender FROM employees LIMIT 10";
			PreparedStatement preparedStatement = connection.prepareStatement(select1);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				EmployeesDto2 dto = new EmployeesDto2();
				
				
				
				dataResult.add(dto);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataResult;
	}

	@Override
	public void inline1() {
		
		try {
			String inline = "SELECT * FROM employees AS e, (SELECT * FROM dept_manager WHERE to_date = ? AND dept_no = ?)as m WHERE e.emp_no = m.emp_no";
			PreparedStatement preparedStatement = connection.prepareStatement(inline);
			preparedStatement.setString(1, "9999-01-01");
			preparedStatement.setString(2, "d003");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("emp_no"));
				System.out.println(resultSet.getString("first_name"));
				System.out.println(resultSet.getString("last_name"));
				System.out.println(resultSet.getString("gender"));
				System.out.println(resultSet.getString("dept_no"));
				System.out.println(resultSet.getString("from_date"));
				System.out.println(resultSet.getString("to_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void inline2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leftJoin2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightJoin1() {
		// TODO Auto-generated method stub
		
	}

	

}
