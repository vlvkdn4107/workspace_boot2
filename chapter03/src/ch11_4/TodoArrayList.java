package ch11_4;

import java.util.ArrayList;

public class TodoArrayList implements TodoListservice{

	
	private ArrayList<TodoList> lists = new ArrayList<TodoList>();
	
	
	
	@Override // 리스트 추가
	public void addTodoList(TodoList todoList) {
		System.out.println("리스트를 추가합니다 추가할 리스트를 입력하세요");
		lists.add(todoList);
		
	}

	@Override // 리스트 수정
	public void updateTodoList(TodoList todoList, String title) {
		System.out.println("리스트를 수정합니다.");
		System.out.println("수정할 리스트를 입력하세요.");
	    
		
	}

	@Override // 리스트 삭제
	public void deleteTodoList(String title) {
		boolean deleteOk = false;
        System.out.println("삭제할 리스트를 선택해주세요.");
        for (int i = 0; i < lists.size(); i++) {
        	lists.remove(i);
        	deleteOk = true;
		}
        if(deleteOk) {
       	 System.out.println(title + " 를 삭제 하였습니다.");
        }
        System.out.println("리스트가 없습니다");//방어적 코드
	}

	@Override
	public void showAllList() {
		System.out.println(">>>> TODO리스트 <<<<");
		for (TodoList todoList : lists) {
			System.out.println(todoList);
		}
		
	}
     
	
}
