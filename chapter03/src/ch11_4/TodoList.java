package ch11_4;

public class TodoList {
	int number;
	String title;

	public TodoList(int number, String title) {
		
		this.number = number;
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTodolist() {
		return title;
	}

	public void setTodolist(String todolist) {
		this.title = todolist;
	}

	@Override
	public String toString() {
		return "TodoArrayList [number=" + number + ", title=" + title + "]";
	}

}
