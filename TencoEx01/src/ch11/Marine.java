package ch11;

public class Marine {

	private static int marinesId;
	
	private int id;
	private String name;
	private int power;
	private int hp;
	
	public Marine(String name) {
		this.name = name;
		marinesId++;
		this.id = marinesId;
		power = 5;
		hp = 100;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void attackZergring(Zergring zergring) {
		if(zergring.getHp() >= 5) {
			System.out.println("-----------------------------");
			System.out.println(" ["+ this.getName() +"]의" + zergring.getName() + "공격성공");
			System.out.println("-----------------------------");
			zergring.beAttacked(power);
		}
	}
	public void attackZealot(Zealot zealot) {
		if(zealot.getHp() >= 5) {
			System.out.println("-----------------------------");
			System.out.println(" ["+ this.getName() +"]의" + zealot.getName() + "공격성공");
			System.out.println("-----------------------------");
			zealot.beAttacked(power);
		}
	}
	
	
	//내가 공격당함
	public void beAttacked(int power) {
		this.hp -= power;
		if(this.hp <= 0) {
			System.out.println(this.name + "이 사망하였습니다.");
		}
	}
	//상태창
	public void showInfo() {
		System.out.println("\t=====정보장=====");
		System.out.println("\t닉네임 : " + name);
		System.out.println("\t아이디 : " + id);
		System.out.println("\t공격력 : " + power);
		System.out.println("\t생명력 : " + hp);
		System.out.println("\t==============");
	}
}
