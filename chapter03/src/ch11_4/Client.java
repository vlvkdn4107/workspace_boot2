package ch11_4;

public class Client {

	public TodoList createTodoList(String title, int nuber) {
		return new TodoList(nuber, title);
	}


	
}
