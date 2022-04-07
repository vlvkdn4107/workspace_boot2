package tenco.com.test_01;

public class MainTest2 {

	public static void main(String[] args) {
		
		Powder powder = new Powder();
		Plastic plastic = new Plastic();
		
		
		ThreeDPrinter1 dPrinter1 = new ThreeDPrinter1();
		//재료 셋팅 / 플라스틱을 넣는다
		dPrinter1.setMaterial(new Plastic());
		
		//메모리 올리기
		ThreeDPrinter2 dPrinter2 = new ThreeDPrinter2();
		dPrinter2.setMaterial(powder);
		
		//모든 클래스에 최상위 클래스는 Object이다.
		ThreeDPrinter3 dPrinter3 = new ThreeDPrinter3();
		dPrinter3.setMaterial(plastic);
		
		//dp1 재료 꺼내기
		Plastic getPlastic = dPrinter1.getMaterial();
		System.out.println(getPlastic);
		//dp2 재료 꺼내기
		//파우더 겟 파우터 = dPrinter2에 넣겠다
		Powder getPowder = dPrinter2.getMaterial();
		System.out.println(getPowder);
		//dp3 재료 꺼내기	
		Plastic tempPlastic = (Plastic)dPrinter3.getMaterial();
		//형 변환을 해야하는 번거로움이 있다 -->코드를 살펴서 확인을 해야한다
		System.out.println(tempPlastic);
  
		
	}

}
