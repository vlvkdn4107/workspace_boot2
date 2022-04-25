package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class ServerView extends JFrame{
	private JPanel panel;
	private JTextArea textArea;
	private JLabel portlabel;
	private JTextField textField;
	private JButton portstartbutton;
	private JButton portstopbutton;
	private JButton logbutton;
	private BufferedImage img;
	
	
	
	
	public ServerView() {
		init();
		
		textField.requestFocus();
	}
	private void init() {
		setSize(500,600);
		setTitle("소켓통신");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		//패널
		try {
			img = ImageIO.read(new File("images/lion.png"));
		} catch (IOException e) {
			System.out.println("파일 x");
			e.printStackTrace();
		}
		panel = new JPanel();
		
		
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);		
		panel.setLayout(null);
		
		//텍스트 아레아
		ScrollPane scroll = new ScrollPane();
		scroll.setBounds(12, 10, 360, 300);
		scroll.setBackground(Color.white);
		textArea = new JTextArea();
		scroll.add(textArea);
		panel.add(scroll);
		textArea.setEditable(false);
		
		//포트 라벨
		portlabel = new JLabel("포트 번호");
		portlabel.setBounds(12, 320, 100, 30);
		panel.add(portlabel);
		
		//포트 텍스트 필드
		textField = new JTextField();
		textField.setBounds(80, 320, 293, 30);
		panel.add(textField);
		
		
		logbutton = new JButton("로그 출력");
		logbutton.setBounds(25, 380, 100, 30);
		panel.add(logbutton);
		
		portstartbutton = new JButton("서버 실행");
		portstartbutton.setBounds(172, 355, 200, 30);
		panel.add(portstartbutton);
		
		portstopbutton = new JButton("서버 중지");
		portstopbutton.setBounds(172, 400, 200, 30);
		panel.add(portstopbutton);
		portstopbutton.setEnabled(false);
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ServerView();
	}
}
