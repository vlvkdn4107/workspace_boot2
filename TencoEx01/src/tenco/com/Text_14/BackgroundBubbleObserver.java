package tenco.com.Text_14;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//쓰레드로 만들지 않을거임!!!
//이 코드에서 쓰레드를 쓰면 많이 느려진다.

public class BackgroundBubbleObserver {

	private static int LEFT_XPOINT = 0;
	private static int RIGHT_XPOINT = 60;
	private static int CENTER_TOP = 25;

	// RGB값을 받을꺼기때문에 버퍼드
	private BufferedImage image;
	private Bubble bubble;

	// Color를 멤버 변수로 만드는게 좋은가??? -->> 강사님은 지역변수로 쓰는걸 추천한다
	// 리펙토리 과정 연습!!
	public BackgroundBubbleObserver(Bubble bubble) {// 의존성
		// 의존성
		this.bubble = bubble;
		try {
			image = ImageIO.read(new File("images/backgroundMapService.png"));
		} catch (IOException e) {
			System.out.println("파일 x");
			e.printStackTrace();
		}
	}

	public boolean checkLeftWall() {

		// 의존한 버블 의 x y 를 들고온다
		// 1단계
//	Color leftColor = new Color(image.getRGB(bubble.getX(), bubble.getY()));
//	if(leftColor.getRed() == 225 && leftColor.getGreen() == 0 && leftColor.getBlue() == 0) {
//		return true;
//	}
		return isCrashColor(LEFT_XPOINT);
	}

	public boolean checkRightWall() {
		// 2단계
//	if(isCrashColor()) {
//		return true;
//	}	
		return isCrashColor(RIGHT_XPOINT);
	}

	public boolean checkTopWall() {
		// 3단계

		return isCrashColor(CENTER_TOP);
	}

	private boolean isCrashColor(int correctionPoint) {
		Color topColor = new Color(image.getRGB(bubble.getX() + correctionPoint, bubble.getY()));
		if (topColor.getRed() == 225 && topColor.getGreen() == 0 && topColor.getBlue() == 0) {
			return true;
		}
		return false;
	}
//	private boolean isCrashColor(int correctionPoint) {
//		Color topColor = new Color(image.getRGB(bubble.getX() + correctionPoint, bubble.getY()));
//		if(topColor.getRed() == 255 && topColor.getGreen() == 0 && topColor.getBlue() == 0) {
//			return true; 
//		}
//		return false; 
//	}

}// end of class