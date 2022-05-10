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
	
	
}
