package ch05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeesDto2 {

	private int emp_no;
	private String first_name;
	private String gender;
	private int salary;
	private String title;
	private String dept_no;
	private String dept_name;
	private String from_date;
	private String to_date;
	
}
