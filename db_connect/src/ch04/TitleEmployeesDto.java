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
public class TitleEmployeesDto extends EmployeesDto{

	private String birth_date;
	private String hire_date;
	private String title;
	private String from_date;
	private String to_date;
	
	
}
