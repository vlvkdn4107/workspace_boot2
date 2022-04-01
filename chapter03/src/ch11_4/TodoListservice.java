package ch11_4;

public interface TodoListservice{

	void addTodoList(TodoList todoList);
	
	void updateTodoList(TodoList todoList, String title);
	
	void deleteTodoList(String title);
	
	void showAllList();
	
	
}
