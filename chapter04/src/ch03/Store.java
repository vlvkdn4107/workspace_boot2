package ch03;

public class Store {
		String dog;
		ICallbackTest1 oncallbackTest1;
		
		public Store(String dog) {
			this.dog = dog;
			
			
		}
		public void selldog1() {
			oncallbackTest1.selldog(dog);
		}
	

}
