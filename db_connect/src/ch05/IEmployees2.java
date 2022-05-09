
package ch05;

import java.util.ArrayList;

public interface IEmployees2 {
	
	ArrayList<EmployeesDto2> innerJoin1();
	ArrayList<EmployeesDto2> innerJoin2();
	ArrayList<EmployeesDto2> leftJoin1();
	ArrayList<EmployeesDto2> leftJoin2();
	ArrayList<EmployeesDto2> rightJoin1();
}
