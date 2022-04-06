package thread_Ex;


class Water{
	private int water1 = 5;

	public int getWater1() {
		return water1;
	}

	public void setWater1(int water1) {
		this.water1 = water1;
	}
	


//더하기 기능
 public void saveWater(int water){
	int currentWater = getWater1();
	
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			//예외 처리
			e.printStackTrace();
		}
	 //값을 매개변수에 넣기
	setWater1(currentWater + water);
	System.out.println("더 한 물의 양 : " + getWater1() +"L" );
 
 }
 //빼기
 public void drawWater(int water) {
	 int currentWater = getWater1();
	 
		 try {
			Thread.sleep(1000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 setWater1(currentWater - water);
		 System.out.println("뺸 물의 양 :" + getWater1() + "L");
 

  }
}
    class Firend1 extends Thread{
	//포함 관계
     Water wateraccount;
     //메서드생성
     public Firend1(Water account) {
    	 this.wateraccount = wateraccount;
	}
     @Override
    public void run() {
    	wateraccount.saveWater(2);
      }
   }

   class Firend2 extends Thread{
	Water wateraccount;
	
	public Firend2(Water account) {
		
	}
	@Override
	public void run() {
		wateraccount.drawWater(3);
	}
   }
 
 

public class SharedTest {
	
public static void main(String[] args) {
		
	
	Water account = new Water();
	
	Firend1 firend1 = new Firend1(account);
	Firend2 firend2 = new Firend2(account);
    
	firend1.start();
	firend2.start();
	
     
	
	
  	}
}

