
package ch04;

import java.util.ArrayList;

public interface IEmployees {
	
	ArrayList<EmployeesDto> select();
	void insert();
	void update();
	void delete();
	void innerJoin();
	
}
