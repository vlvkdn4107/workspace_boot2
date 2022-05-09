
package ch04;

import java.util.ArrayList;

public interface IEmployees {
	
	ArrayList<EmployeesDto> select();
	void innerJoin();
	void leftJoin1();
	void leftJoin2();
	void rightJoin1();
}
