package ch11;

public class Zergring {
  
	private static int zergringsId;
	
	private String name;
	private int id;
	private int power;
	private int hp;
	
	public Zergring(String name) {
		this.name = name;
		zergringsId++;
		this.id = zergringsId;
		power = 5;
		hp = 100;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	//마린 공격하기
	public void attackMarine(Marine marine) {
		if(marine.getHp() >= 5) {
			System.out.println("-----------------------------");
			System.out.println(" ["+ this.getName() +"]의" + marine.getName() + "공격성공");
			System.out.println("-----------------------------");
			marine.beAttacked(power);
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
