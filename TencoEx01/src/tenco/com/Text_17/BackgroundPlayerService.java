package tenco.com.Text_17;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//main 쓰레드 바쁨 --> 카보드 이벤트 처리하기때문에
// 백그라운드에서 계속 관찰
public class BackgroundPlayerService implements Runnable {

	private BufferedImage image;
	private Player player;

	public BackgroundPlayerService(Player player) {
		this.player = player; // 포함관계 시킴

		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override // 캐릭터의 최 상단 좌표값
	public void run() {
		// 쓰레드 안에서 while문을 쓰기때문에 계속 돌아가는거다
		// 맵을 벗어나면 찍을게 없어서 null포인트가 뜬다
		// 도전 과제 던지거나 처리
		// 색상확인
		while (true) {
			Color leftcolor = new Color(image.getRGB(player.getX() + 5, player.getY() + 25));
			Color rightcolor = new Color(image.getRGB(player.getX() + 50 + 10, player.getY() + 25));
//            Color bottomcolor = new Color(image.getRGB(player.getX() + 25, player.getY() +50 + 10));
			int bottomcolor = image.getRGB(player.getX() + 10, player.getY() +50 +5 ) // 흰색이면-1
                            + image.getRGB(player.getX() +50 -10, player.getY() +50 + 5 );
//			System.out.println(bottomcolor);
			
			
            // - 2 이 아니라는 것은 빨간색이거나 파란색이다.
            if(bottomcolor != -2) { // 바닥 컬러를 걸러낸다
            	//버그(무한호출) 백그라운드 서비스는 계속 실행이 된다
            	//player에서 down ==flase 일 경우에만 한번 실행되게 수정
            	player.setDown(false);//흰색이 아니라면 떨어지는것을 멈춰
//            	player.setDown(true);// 
            }else {
            	// 점프 하는 순간 down 메서드 호출
            	if(!player.isUp() && !player.isDown()){
            		player.down();
            	}
            }
            
            
//            if (leftcolor.getRed() == 225 && leftcolor.getGreen() == 0 && leftcolor.getBlue() == 0) {// 왼쪽색에(
//				System.out.println("왼쪽 벽에 충돌 했어!!!!");
//				player.setLeftWallCrash(true);
//				player.setLeft(false);
//			} else if (rightcolor.getRed() == 225 && rightcolor.getGreen() == 0 && rightcolor.getBlue() == 0) {
//				System.out.println("오른쪽 벽에 충돌했어");
//				player.setRightWallCrash(true);
//				player.setRight(false);
//			}else {
//				System.out.println("오류");
//				player.setLeftWallCrash(false);
//				player.setRightWallCrash(false);				
//			}
//           
            if (leftcolor.getRed() == 255 && leftcolor.getGreen() == 0 && leftcolor.getBlue() == 0) {
				System.out.println("왼쪽 벽에 충돌했어 !!!");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightcolor.getRed() == 255 && rightcolor.getGreen() == 0 && rightcolor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌했어 !!!");
				player.setRightWallCrash(true);
				player.setRight(false);
			} else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}		
			try {
				//캐릭터가 이동 될 때 칼라 값을 못찾는 경우가 있다! 이동속도보다 더 빠르게 색을체크해야 해결 가능!
				Thread.sleep(7); // 수정함  //바닥색 체크를 해야되는데 체크하기전에 다운을 만나서 떨어진다?
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//end of while
		 
	}

}
