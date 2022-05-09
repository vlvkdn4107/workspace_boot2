package ch04;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeesDao implements IEmployees{

	private DBClient dbClient = DBClient.getInstance();
	Connection connection = dbClient.getConnection();
	
	
	ResultSet resultSet = null;
	
	
	@Override
	public ArrayList<EmployeesDto> select() {
		
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		
		
		try {
			String select1 = "SELECT emp_no, first_name, gender FROM employees LIMIT 10";
			PreparedStatement preparedStatement = connection.prepareStatement(select1);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				EmployeesDto dto = new EmployeesDto();
				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setFirst_name(resultSet.getString("first_name"));
				dto.setGender(resultSet.getString("gender"));
				
				
				dataResult.add(dto);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataResult;
	}


	@Override
	public void innerJoin() {
		
		try {
			String innerJoin1 = "SELECT * FROM departments as a INNER JOIN dept_emp as b ON a.dept_no = b.dept_no WHERE dept_name = ? AND b.to_date = ? limit 10";
			PreparedStatement preparedStatement = connection.prepareStatement(innerJoin1);
			preparedStatement.setString(1, "Marketing");
			preparedStatement.setString(2, "9999-01-01");
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("dept_no"));
				System.out.println(resultSet.getString("dept_name"));
				System.out.println(resultSet.getString("emp_no"));
				System.out.println(resultSet.getString("from_date"));
				System.out.println(resultSet.getString("to_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void leftJoin1() {
		try {
			// Finance인 매니저만
			String leftJoin1 = "SELECT * FROM dept_manager as a LEFT JOIN departments as b ON a.dept_no = b.dept_no WHERE b.dept_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(leftJoin1);
			preparedStatement.setString(1, "Finance");

			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("emp_no"));
				System.out.println(resultSet.getString("dept_no"));
				System.out.println(resultSet.getString("from_date"));
				System.out.println(resultSet.getString("to_date"));
				System.out.println(resultSet.getString("dept_name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void leftJoin2() {
		try {
			// Senior Engineer 사람들만
			String leftJoin2 = "SELECT * FROM employees as e LEFT JOIN titles as t ON e.emp_no = t.emp_no WHERE t.title = ? limit 10";
			PreparedStatement preparedStatement = connection.prepareStatement(leftJoin2);
			preparedStatement.setString(1, "Senior Engineer");

			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("emp_no"));
				System.out.println(resultSet.getString("birth_date"));
				System.out.println(resultSet.getString("first_name"));
				System.out.println(resultSet.getString("last_name"));
				System.out.println(resultSet.getString("gender"));
				System.out.println(resultSet.getString("hire_date"));
				System.out.println(resultSet.getString("title"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void rightJoin1() {
		try {
			// gender가 M인 사람들만
			String rightJoin1 = "SELECT * FROM employees as e RiGHT JOIN dept_manager as d ON e.emp_no = d.emp_no WHERE e.gender = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(rightJoin1);
			preparedStatement.setString(1, "M");

			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println(resultSet.getString("emp_no"));
				System.out.println(resultSet.getString("birth_date"));
				System.out.println(resultSet.getString("first_name"));
				System.out.println(resultSet.getString("last_name"));
				System.out.println(resultSet.getString("gender"));
				System.out.println(resultSet.getString("hire_date"));
				System.out.println(resultSet.getString("dept_no"));
				System.out.println(resultSet.getString("to_date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

	

}
