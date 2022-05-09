package ch04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ch02.DBClient;





public class EmployeesDao implements IEmployees{

	private DBClient client = DBClient.getInstance();
	Connection connection = client.getConnection();
	
	
	ResultSet resultSet = null;
	
	
	@Override
	public ArrayList<EmployeesDto> select() {
		
		ArrayList<EmployeesDto> dataResult = new ArrayList<EmployeesDto>();
		
		
		try {
			String select1 = "SELECT m.emp_no, m.first_name, m.gender, s.salary as 현재연봉 FROM employees as m INNER JOIN salaries as s ON m.emp_no = s.emp_no WHERE m.emp_no = ? GROUP BY m.emp_no";
//			String select1 = "SELECT emp_no, first_name, gender from employees WHERE emp_no = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(select1);
			preparedStatement.setInt(1, 12345);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				EmployeesDto dto = new EmployeesDto();
				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setFirst_name(resultSet.getString("first_name"));
				dto.setGender(resultSet.getString("gender"));
				dto.setSalary(resultSet.getInt("salary"));
				
				dataResult.add(dto);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataResult;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void innerJoin() {
		// TODO Auto-generated method stub
		
	}

	

}
