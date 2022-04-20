package ch09;

import java.io.File;

public class MainTest2 {

	public static void main(String[] args) {
		File image1 = new File("image1.jpg");
		File icon1 = new File("image1.jpg");
		new MyImageFrame(image1, icon1);

	}

}
