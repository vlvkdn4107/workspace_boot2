package ch04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GenderSelectDto extends EmployeesDto{
	
	private String dept_no;
	private String from_date;
	private String to_date;
	
}
