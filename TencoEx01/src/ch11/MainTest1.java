package ch11;

import java.util.Scanner;

public class MainTest1 {

	public static void main(String[] args) {
		Zealot zealot = new Zealot("질럿");
		Marine marine = new Marine("마린");
		Zergring zergring = new Zergring("저글링");
		Scanner scanner = new Scanner(System.in);
		
		boolean flag = true;
		//캐럭터 누구 선택하는지 받는 변수
		int unitChoice = 0;
		int choice;
		//attackNum 공격 횟수 받는 변수
		int attackNum = 0;
		//닉네임 입력받을 변수
		String name = null;
		
		System.out.println("=======Game Loading=======");
		for (int i = 0; i < 8; i++) {
			System.out.println("   .   ");
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n=======Game Start=======");
		
		while(flag) {
			System.out.println("\t=====메뉴=====\t");
			System.out.println("\t  1. 캐릭터 고르기");
			System.out.println("\t  2. 공격하기");
			System.out.println("\t  3. 닉네임 설정");
			System.out.println("\t  4. 상태창 보기");
			System.out.println("\t  5. 게임 종료");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			//1 캐릭터 고르기
			if(choice ==1) {
				System.out.println("\t==캐릭터 선택==\t");
				System.out.println("\t== 1. 질럿==\t");
				System.out.println("\t== 2. 마린==\t");
				System.out.println("\t== 3. 저글링==\t");
				choice = scanner.nextInt();
				scanner.nextLine();
				unitChoice = choice;
				System.out.println("\t==캐릭터 선택완료==\t\n");
				continue;
				//2 공격하기
			}else if(choice == 2) {

			  if(unitChoice ==1) {
				if(zealot.getHp() == 0 || zealot.getHp() == -5) {
					System.out.println(zealot.getName() + " 이 사망하여 공격할 수 없습니다");
					continue;
				}
			  
				System.out.println("\t====공격====");
				System.out.println("\t 1. 마린");
				System.out.println("\t 1. 저글링");
				choice = scanner.nextInt();
				System.out.println("\t===공격 횟수===");
				attackNum = scanner.nextInt();
				if(choice == 1) {
					for (int i = 0; i < attackNum; i++) {
						zealot.attackMarine(marine);
						if(marine.getHp() == 0 || marine.getHp() == -5) {
							System.out.println(marine.getName() + "이 사망하여 공격할 수 없습니다");
							break;							
						}
						try {
							Thread.sleep(700);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					marine.showInfo();
				}else if(choice == 2) {
					for (int i = 0; i < attackNum; i++) {
						zealot.attackZergring(zergring);
						if(zergring.getHp() == 0 || zergring.getHp() == -5) {
							System.out.println(zergring.getName() + "이 사망하여 공격할 수 없습니다");
							break;
						}
						try {
							Thread.sleep(700);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					zergring.showInfo();
				}
			}
			  else if (unitChoice == 2) {
				  if(marine.getHp() == 0 || marine.getHp() == -5) {
					  System.out.println(marine.getName() + "이 사망하여 공격할 수 없습니다.");
					  continue;
				  }
				  System.out.println("\t====공격====");
					System.out.println("\t 1. 질럿");
					System.out.println("\t 1. 저글링");
					choice = scanner.nextInt();
					System.out.println("\t===공격 횟수===");
					attackNum = scanner.nextInt();
					if(choice == 1) {
						for (int i = 0; i < attackNum; i++) {
							marine.attackZealot(zealot);
							if(zealot.getHp() == 0 || zealot.getHp() == -5) {
								System.out.println(zealot.getName() + "이 사망하여 공격할 수 없습니다.");
								break;
							}
							try {
								Thread.sleep(700);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						zealot.showInfo();
					}else if(choice == 2) {
						for (int i = 0; i < attackNum;  i++) {
							marine.attackZergring(zergring);
							if(zergring.getHp() == 0 || zergring.getHp() == -5) {
								System.out.println(zergring.getName() + "이 사망하여 공격할 수 없습니다");
								break;
							}
							try {
								Thread.sleep(700);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						zergring.showInfo();
					}
			  }
			  //저글링이 공격
			  else if(unitChoice == 3) {
				  if(zergring.getHp() == 0 || zergring.getHp() == -5) {
					  System.out.println(zergring.getName() + "이 사망하여 공격할 수 없습니다");
					  continue;
				  }
				  System.out.println("\t====공격====");
					System.out.println("\t 1. 질럿");
					System.out.println("\t 1. 마린");
					choice = scanner.nextInt();
					System.out.println("\t===공격 횟수===");
					attackNum = scanner.nextInt();
					if(!(choice == 1 || choice ==2 )) {
						System.out.println("공격할 수 없습니다.");
						continue;
					}
					if(choice == 1) {
						for (int i = 0; i < attackNum; i++) {
							zergring.attackZealot(zealot);
							if(zealot.getHp() == 0 || zealot.getHp() == -5) {
								System.out.println(zealot.getName()+ "이 사망하여 공격할 수 없습니다");
								break;
							}
							try {
								Thread.sleep(700);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						zealot.showInfo();
					}else if(choice == 2) {
						for (int i = 0; i < attackNum; i++) {
							zergring.attackMarine(marine);
							if(marine.getHp() == 0 || marine.getHp() == -5) {
								System.out.println(marine.getName() + "이 사망하여 공격할 수 없습니다");
								break;
							}
							try {
								Thread.sleep(700);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						marine.showInfo();
					}
			  }else {
				  System.out.println("!!캐릭터를 먼저 선택해 주세요!!");
			  }
			}
			
			//닉네임 설정
			else if(choice == 3) {
				if(unitChoice == 1) {
					zealot.setName(name);
					System.out.println("\t\t [" + zealot.getName() + "]");
				}else if(choice == 2) {
					marine.setName(name);
					System.out.println("\t\t [" + marine.getName() + "]");
				}else if(choice == 3) {
					zergring.setName(name);
					System.out.println("\t\t [" + zergring.getName() + "]");
				}
				System.out.println("\t ==닉네임 설정 완료 == \t\n");
			}
			else if (choice == 4) {
				System.out.println("====================================");
				zealot.showInfo();
				marine.showInfo();
				zergring.showInfo();
				System.out.println("====================================");
			}
			else if (choice == 5) {
				System.out.println("=====Game Closing=====");
				for (int i = 0; i < 8; i++) {
					System.out.println("    .    ");
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("\n=====Game Over=====");
				flag = false;
			}
			
		}

	}

}
