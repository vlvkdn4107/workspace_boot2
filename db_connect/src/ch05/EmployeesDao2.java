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
	public ArrayList<EmployeesDto2> innerJoin2() {
		
		ArrayList<EmployeesDto2> dataResult2 = new ArrayList<EmployeesDto2>();
		try {
			// 이렇게 하면 안된다 !!!!!!!!!!!!!!!!!!!!!!! 고쳐라!!! ArrayList 중복으로 쓰면 안된다!! 
			String innerJoin2 = "SELECT * FROM departments as a INNER JOIN dept_emp as b ON a.dept_no = b.dept_no WHERE dept_name = ? AND b.to_date = ? limit 10";
			PreparedStatement preparedStatement = connection.prepareStatement(innerJoin2);
			preparedStatement.setString(1, "Marketing");
			preparedStatement.setString(2, "9999-01-01");
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			EmployeesDto2 dto = new EmployeesDto2();
			dto.setDept_no(resultSet.getString("dept_no"));
			dto.setDept_name(resultSet.getString("dept_name"));
			dto.setEmp_no(resultSet.getInt("emp_no"));
			dto.setFrom_date(resultSet.getString("from_date"));
			dto.setTo_date(resultSet.getString("to_date"));
			
			dataResult2.add(dto);
		
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		return dataResult2;
	}

	@Override
	public ArrayList<EmployeesDto2> leftJoin1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EmployeesDto2> leftJoin2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EmployeesDto2> rightJoin1() {
		// TODO Auto-generated method stub
		return null;
	}

}
