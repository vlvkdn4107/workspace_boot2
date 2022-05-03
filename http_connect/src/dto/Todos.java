package dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Todos {
	
	int userId;
	int id;
	String title;
	boolean completed;
}
