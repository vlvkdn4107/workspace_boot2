package ch05;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {

		EmployeesDao2 employeesDao2 = new EmployeesDao2();
//		ArrayList<EmployeesDto2> data = employeesDao2.innerJoin1();
//		System.out.println(data);
		
		employeesDao2.inline1();
		
	}

}
