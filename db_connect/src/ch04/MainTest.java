package ch04;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {


		EmployeesDao employeesDao = new EmployeesDao();
		ArrayList<EmployeesDto> data = employeesDao.select();
		System.out.println(data);
//		ArrayList<EmployeesSelectDto> data = employeesDao.employeesSelect("Marketing", "9999-01-01");
//		System.out.println(data);
//		ArrayList<EmployeesSelectDto> data = employeesDao.managerSelect("Finance");
//		System.out.println(data);
//		ArrayList<TitleEmployeesDto> data = employeesDao.titleEmployees("Senior Engineer");
//		System.out.println(data);
//		ArrayList<GenderSelectDto> data = employeesDao.genderSelecet("M");
//		System.out.println(data);
		
	}

}
