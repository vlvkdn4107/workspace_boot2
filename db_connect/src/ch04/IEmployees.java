
package ch04;

import java.util.ArrayList;

public interface IEmployees {
	
	// 변수명 꼭 !!!!!
	ArrayList<EmployeesDto> select();
	// 유저이름을 입력하면 한사람에 정보 출력 
	// 어떤 기능을 만들지 명확하게 이해하고 진행 하기 !!! 
	// 2. 현재 근무중인지 퇴사했는지, 어느부서 사람들 출력
	ArrayList<EmployeesSelectDto> employeesSelect(String dept_name, String to_date);
	// 3. 어느 부서의  매니저만 출력하기
	ArrayList<EmployeesSelectDto> managerSelect(String dept_name);
	// 4. 부서이름을 입력해서 그 부서의 사람들만 출력하기
	ArrayList<TitleEmployeesDto> titleEmployees(String title);
	// 5. gender를 입력해서 그 gender의 사람들만 출력하기
	ArrayList<GenderSelectDto> genderSelecet(String gender);
}
