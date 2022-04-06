package thread_Ex;

class BankAccount {

	private int money = 100_000;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	// 입금 기능
	// 메서드 생성
	// synchronized 키워드 사용
	public synchronized void saveMoney(int money) {
		// 10만원
		// 지역변수로 호출됬을떄 //내부에서 쓰기
		int currentMoney = getMoney();

		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();// 예외처리
		}
		// 값을 매게변수에 넣기
		setMoney(currentMoney + money);
		System.out.println("입금 후 계좌 잔액 : " + getMoney());

	}

	// 출금 기능
	// 메서드 생성

	public void withdraw(int money) {

		synchronized (this) {
			int currentMoney = getMoney();

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			setMoney(currentMoney - money);
			System.out.println("출급 후 계좌 잔액 : " + getMoney());
		} // synchronized 블록 사용
	}

}

//아버지 세종시에서 입금 합니다 (네트워크가 느려서 시간이 조금 걸림)
class Father extends Thread {

	// 포함관계
	BankAccount account;

	// 생성자
	public Father(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		// 객체에 접근해서
		account.saveMoney(10_000);
	}

}

class Mother extends Thread {
	// 포함관계
	BankAccount account;

	// 생성자
	public Mother(BankAccount account) {
		this.account = account;
	}

	@Override
	public void run() {
		// acount. 객체에 접근해서 ??기능을 한다
		account.withdraw(5_000);
	}
}

public class SharedResource {
	public static void main(String[] args) {
		// 메모리에 올리기
		BankAccount account = new BankAccount();

		Father father = new Father(account);
		Mother mother = new Mother(account);

		// 아버지가 입금 합니다.
		father.start();
		// 어머지가 출금합니다.
		mother.start();

		// father쓰레드는 4초동안 기다리고있는데 mather 쓰레드가 먼저 접근해서

		// 105_000원
		// 정상 처리 금액 10 +1 -0.5 = 10.5

		// shared 공유되는 자원을 활용 할 때 의되 않은 결과를 생성할 수 있다.
		// 해결 방법 --> 동기화(synhronized, synhronized블록)
	}
}
