package Iconmove;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundMapService implements Runnable{

	private BufferedImage image;
	
	private Player player;
	
	private void BackgroundMapSer() {
		this.player = player;
        try {
			image = ImageIO.read(new File("images/backgroundMapService"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public void run() {
		Color leftcolor = new Color(image.getRGB(player.getX()+5, player.getY()));
		Color rightcolor = new Color(image.getRGB(player.getX()+60, player.getY()));
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
