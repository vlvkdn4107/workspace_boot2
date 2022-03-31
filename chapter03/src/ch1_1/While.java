package ch1_1;

public class While {

	public static void main(String[] args) {
		 int num = 1;
		 int sum = 0;
		 
		 while( num <= 5){
			 sum += num;
			 num++;
			 
		 }
		 System.out.println("합계" + sum);
		 System.out.println("num :" + num);

	}

}
