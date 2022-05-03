package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class Todo{
	int id;
	String title;
	boolean complete;
}

public class Plan {

	private List<Todo> todoList = new ArrayList<Todo>();
	private String server_name;
	
	//todoList get,set
	public List<Todo> getTodoList() {
		return this.todoList;
	}
	public void setTodoList(List<Todo> todoList) {
		this.todoList = todoList;
	}
}
