package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import lombok.Getter;
import lombok.Setter;
import server.ServerService;
import server.UserSocket;




@Getter
@Setter
public class ServerView extends JFrame implements ActionListener {

	ServerView mContext = this;
	
	
	private JTextArea textArea;
	private JLabel portlabel;
	private JTextField textField;
	private JTextField textField2;
	private JButton button;
	private JButton portstartbutton;
	private JButton portstopbutton;
	private BufferedImage img = null;

	BufferedWriter bufferedWriter;
	BufferedReader bufferedReader;

	private JButton logbutton;
	

	private Socket socket;
	private int port;

	
	
	ServerService serverService;
	UserSocket user;
	  

	
	

	public ServerView() {
		
		try {
			img = ImageIO.read(new File("images/RYAN.png"));
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "이미지 불러오기 실패");
		}
		
		init();
		addEventListener();
		textField.requestFocus();
		
		
		serverService = new ServerService(mContext);
		
		
	}
	

	private void init() {
		setSize(500, 600);
		setTitle("소켓통신");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	
//		panel = new JPanel();
//		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(panel);		
//		panel.setLayout(null);
		ImagePanel panel = new ImagePanel();
		setContentPane(panel);
		panel.setLayout(null);
		
		
		
		
		// 텍스트 아레아
		ScrollPane scroll = new ScrollPane();
		scroll.setBounds(12, 10, 360, 300);
		scroll.setBackground(Color.white);
		textArea = new JTextArea();
		scroll.add(textArea);
		panel.add(scroll);
		textArea.setEditable(false);

		// 포트 라벨
		portlabel = new JLabel("포트 번호");
		portlabel.setBounds(12, 320, 100, 30);
		panel.add(portlabel);

		// 포트 텍스트 필드
		textField = new JTextField();
		textField.setBounds(80, 320, 293, 30);
		textField.setText("10000");
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

		textField2 = new JTextField();
		textField2.setBounds(10, 440, 200, 20);
		panel.add(textField2);

		button = new JButton("전송");
		button.setBounds(220, 440, 100, 20);
		panel.add(button);

		setVisible(true);
	}

	class ImagePanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img, 3, 0, null);
		}
		
	}
	
	public void addEventListener() {
		portstartbutton.addActionListener(this);
		portstopbutton.addActionListener(this);
		button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == portstartbutton) {

			if (textField.getText().length() == 0) {
			} else if (textField.getText().length() != 0) {
				port = Integer.parseInt(textField.getText());
				
				// 한군데 사용 (일단) 
				serverService.starNetwork(port);

				textField.setEditable(false);
				portstartbutton.setEnabled(false);
				portstopbutton.setEnabled(true);
			}
		} else if (e.getSource() == portstopbutton) {// 작동 안됌!
			try {
				serverService.getServerSocket().close();
			

				textField.setEditable(true);
				portstartbutton.setEnabled(true);
				portstopbutton.setEnabled(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {

		}
	}

	public void showLog(String log) {
		textArea.append(log + "\n");
	}
	
	

	public static void main(String[] args) {
		new ServerView();

	}

}
