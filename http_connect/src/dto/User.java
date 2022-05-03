package dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@RequiredArgsConstructor // 생성자 만들기
@ToString
public class User {

	private int age;
	private String name;
	private String address;
	
	
}
