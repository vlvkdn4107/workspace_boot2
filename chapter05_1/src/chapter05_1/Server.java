package chapter05_1;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ch88.Server.RoomInfomation;
import ch88.Server.UserInfomation;

public class Server extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextArea textArea;
	private JLabel portlabel;
	private JTextField textField;
	private JTextField textField2;
	private JButton button;
	private JButton portstartbutton;
	private JButton portstopbutton;
	private JButton logbutton;
	
	
	// Network 자원
		private ServerSocket server_socket;
		private Socket socket;
		private int port;

		// 그외 자원들
		private Vector<Users> vc = new Vector<Users>();
		private Vector<Rooms> vc_room = new Vector<Rooms>();
		
	public Server() {
		init();	
		
		textField.requestFocus();
	}
	private void init() {
		setSize(500,600);
		setTitle("소켓통신");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		
		
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
		
		textField2 = new JTextField();
		textField2.setBounds(10, 440, 200,20);
		panel.add(textField2);
		
		button = new JButton("전송");
		button.setBounds(220, 440, 100, 20);
		panel.add(button);
		
		
		setVisible(true);
	}
	
		private void addEventListener() {
			textField.addActionListener(this);
			portstartbutton.addActionListener(this);
			portstopbutton.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == portstartbutton) {
				if(textField.getText().length() == 0) {
					
				}else if(textField.getText().length() != 0) {
					port = Integer.parseInt(textField.getText());
					starNetwork();
					textField.setEditable(false);
					portstartbutton.setEnabled(false);
					portstopbutton.setEnabled(true);
				}
			}else if(e.getSource() == portstopbutton) {
				server_socket.close();
				
			}
			
		}
	private void startNetwork() {
		
	}
	private void connet() {
		
	}
	public void  broadCast(String str) {
		
	}
	class Users extends Thread{
		
	}
	class Rooms{
		
	}
	
	
		
		
		
		
		
		
	
	public static void main(String[] args) {
		new Server();

	}
	

}
