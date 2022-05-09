package ch04;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {


		EmployeesDao employeesDao = new EmployeesDao();
//		ArrayList<EmployeesDto> data = employeesDao.select();
//		System.out.println(data);
//		employeesDao.innerJoin();
//		employeesDao.leftJoin1();
//		employeesDao.leftJoin2();
		employeesDao.rightJoin1();
	}

}
