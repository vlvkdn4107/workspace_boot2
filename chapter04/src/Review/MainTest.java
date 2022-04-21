package Review;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainTest extends JFrame{

	private textArea textArea;
	private ImagePanel background;
	private JButton subminButton;
	
	 public MainTest() {
		initData();
		setinitLayout();
		addEventListener();
	}
	 private void initData() {
		 setTitle("메모장");
		 setSize(500,500);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 background = new ImagePanel();
		 textArea = new textArea();
		 subminButton = new JButton("submit");
		 subminButton.setSize(100,50);
		 
		 add(subminButton);
		 add(textArea);
		 add(background);
	 }
	 private void setinitLayout() {
		 setLayout(null);
		 setVisible(true);
		 subminButton.setVisible(true);
		 subminButton.setLocation(200, 350);
		 subminButton.setBackground(Color.ORANGE);
	 }
	 private void addEventListener() {
		 subminButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					String s = textArea.getText().toString();
					textArea.bw.write(s);
					textArea.bw.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	 }
	
	 private class ImagePanel extends JPanel{
		 private BufferedImage backImage;
		 
		 public ImagePanel() {
			 setSize(600,700);
			 try {
				backImage = ImageIO.read(new File("background.png"));
			} catch (IOException e) {
				System.out.println("파일이 없습니다");
			}
		 }
		 @Override
		public void paintComponents(Graphics g) {
			super.paintComponents(g);
			g.drawImage(backImage, 0, 0, 500, 500, null);
		}
	 }
	 
	 private class textArea extends JTextArea{
		 private File file;
		 private BufferedWriter bw;
		 
		 public textArea() {
			 setSize(400,200);
			 setLocation(45, 50);
			 setBackground(Color.white);
			 setVisible(true);
			 file = new File("memo.txt");
			 try {
				bw = new BufferedWriter(new FileWriter(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 }
	 public static void main(String[] args) {
			new MainTest();
		}
}
