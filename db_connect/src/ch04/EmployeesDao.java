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
			String select1 = "SELECT emp_no, first_name, last_name, gender FROM employees LIMIT 10";
			PreparedStatement preparedStatement = connection.prepareStatement(select1);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				EmployeesDto dto = new EmployeesDto();
				dto.setEmp_no(resultSet.getInt("emp_no"));
				dto.setFirst_name(resultSet.getString("first_name"));
				dto.setLast_name(resultSet.getString("last_name"));
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
	public ArrayList<EmployeesSelectDto> employeesSelect(String dept_name, String to_date) {
		
		ArrayList<EmployeesSelectDto> EmploySelectdata = new ArrayList<EmployeesSelectDto>();
		
		try {
			String employeesSelect = "SELECT * FROM departments as a INNER JOIN dept_emp as b ON a.dept_no = b.dept_no WHERE dept_name = ? AND b.to_date = ? limit 10";
			PreparedStatement preparedStatement = connection.prepareStatement(employeesSelect);
			preparedStatement.setString(1, dept_name);
			preparedStatement.setString(2, to_date);
			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				EmployeesSelectDto employeesSelectDto = new EmployeesSelectDto();
				employeesSelectDto.setDept_no(resultSet.getString("dept_no"));
				employeesSelectDto.setDept_name(resultSet.getString("dept_name"));
				employeesSelectDto.setEmp_no(resultSet.getString("emp_no"));
				employeesSelectDto.setFrom_date(resultSet.getString("from_date"));
				employeesSelectDto.setTo_date(resultSet.getString("to_date"));
				
				EmploySelectdata.add(employeesSelectDto);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EmploySelectdata;
	}


	@Override
	public ArrayList<EmployeesSelectDto> managerSelect(String dept_name) {
		ArrayList<EmployeesSelectDto> managerSelectdata = new ArrayList<EmployeesSelectDto>();
		try {
			// Finance인 매니저만
			String managerSelect = "SELECT * FROM dept_manager as a LEFT JOIN departments as b ON a.dept_no = b.dept_no WHERE b.dept_name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(managerSelect);
			preparedStatement.setString(1, dept_name);

			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				EmployeesSelectDto magagerSelectDto = new EmployeesSelectDto();
				magagerSelectDto.setDept_no(resultSet.getString("dept_no"));
				magagerSelectDto.setEmp_no(resultSet.getString("emp_no"));
				magagerSelectDto.setFrom_date(resultSet.getString("from_date"));
				magagerSelectDto.setTo_date(resultSet.getString("to_date"));
				magagerSelectDto.setDept_name(resultSet.getString("dept_name"));
				
				managerSelectdata.add(magagerSelectDto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return managerSelectdata;
	}


	@Override
	public ArrayList<TitleEmployeesDto> titleEmployees(String title) {
		ArrayList<TitleEmployeesDto> titleEmploydata = new ArrayList<TitleEmployeesDto>();
		try {
			// Senior Engineer 사람들만
			String titleEmployees = "SELECT * FROM employees as e LEFT JOIN titles as t ON e.emp_no = t.emp_no WHERE t.title = ? limit 10";
			PreparedStatement preparedStatement = connection.prepareStatement(titleEmployees);
			preparedStatement.setString(1, title);

			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				TitleEmployeesDto titleEmployeesDto = new TitleEmployeesDto();
				titleEmployeesDto.setEmp_no(resultSet.getInt("emp_no"));
				titleEmployeesDto.setBirth_date(resultSet.getString("birth_date"));
				titleEmployeesDto.setFirst_name(resultSet.getString("first_name"));
				titleEmployeesDto.setLast_name(resultSet.getString("last_name"));
				titleEmployeesDto.setGender(resultSet.getString("gender"));
				titleEmployeesDto.setHire_date(resultSet.getString("hire_date"));
				titleEmployeesDto.setTitle(resultSet.getString("title"));
				titleEmployeesDto.setFrom_date(resultSet.getString("from_date"));
				titleEmployeesDto.setTo_date(resultSet.getString("to_date"));

				titleEmploydata.add(titleEmployeesDto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titleEmploydata;
	}

	
	@Override
	public ArrayList<GenderSelectDto> genderSelecet(String gender) {
		ArrayList<GenderSelectDto> genderdata = new ArrayList<GenderSelectDto>();
		try {
			// gender가 M인 사람들만
			String genderSelecet = "SELECT e.emp_no, e.first_name, e.last_name, e.gender, d.dept_no, d.from_date, d.to_date  FROM employees as e RiGHT JOIN dept_manager as d ON e.emp_no = d.emp_no WHERE e.gender = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(genderSelecet);
			preparedStatement.setString(1, gender);

			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				GenderSelectDto genderSelectDto = new GenderSelectDto();
				genderSelectDto.setEmp_no(resultSet.getInt("emp_no"));
				genderSelectDto.setFirst_name(resultSet.getString("first_name"));
				genderSelectDto.setLast_name(resultSet.getString("last_name"));
				genderSelectDto.setGender(resultSet.getString("gender"));
				genderSelectDto.setDept_no(resultSet.getString("dept_no"));
				genderSelectDto.setFrom_date(resultSet.getString("from_date"));
				genderSelectDto.setTo_date(resultSet.getString("to_date"));

				genderdata.add(genderSelectDto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return genderdata;
	}


	

	

}
