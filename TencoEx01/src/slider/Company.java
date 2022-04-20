package slider;

public class Company {
	 
    //1. 외부에서 생성하지 못하게 private으로 생성자만듬
    private Company() {
    	
    }
    //2. static메소드에 들어갈 static객체
    private static Company instance = new Company();
    
    //3.클래스로 접근 할 수 있도록 static메소드
    public static Company getInstance() {
    	//방어적 코드
    	if(instance == null) {
    		instance = new Company();
    	}
    	return instance;
    }
    
    public static void main(String[] args) {
		System.out.println(Company.getInstance());
		System.out.println(Company.getInstance());
		System.out.println(Company.getInstance());
	}
}
