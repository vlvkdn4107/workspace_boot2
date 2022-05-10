package ch04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeesSelectDto {

	private String dept_no;
	private String dept_name;
	private String emp_no;
	private String from_date;
	private String to_date;
	
}
