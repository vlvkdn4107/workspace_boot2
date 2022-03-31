package ch12;

public class Exception {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
	    try { 
			for (int i = 0; i < 10; i++) {
				System.out.println(arr[i]); //ArrayIndexOutOfBoundsException 오류가 뜬다. 
			}
			
		}catch(Exception e){
			System.out.println("예외 발생");
		}
		
		System.out.println("코드가 여기까지 실행 되나요?");
	}

}
