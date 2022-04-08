package tenco.com.Text_09.copy.copy;

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
			Color rightcolor = new Color(image.getRGB(player.getX() + 60, player.getY() + 25));

			if (leftcolor.getRed() == 225 && leftcolor.getGreen() == 0 && leftcolor.getBlue() == 0) {// 왼쪽색에(
				System.out.println("왼쪽 벽에 충돌 했어!!!!");
				player.setLeftWallCrash(true);
				player.setLeft(false);
			} else if (rightcolor.getRed() == 225 && rightcolor.getGreen() == 0 && rightcolor.getBlue() == 0) {
				System.out.println("오른쪽 벽에 충돌했어");
				player.setRightWallCrash(true);
				player.setRight(false);
			}else {
				player.setLeftWallCrash(false);
				player.setRightWallCrash(false);
			}

			System.out.println("==================----------");
			System.out.println(" 왼쪽 생삭 :" + leftcolor);
			System.out.println(" 오르쪽 생삭 :" + rightcolor);
			System.out.println("==================----------");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
