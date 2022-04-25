package ch89;

import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JTextArea textArea;
	private JLabel portlabel;
	private JTextField textField;
	private JButton portstartbutton;
	private JButton portstopbutton;
	private JButton logbutton;
	
	private Socket socket;
	private ServerSocket serverSocket;
	private int port;
	
	private Vector<Users> vc = new Vector<Users>();
	private Vector<Rooms> vcRoom = new Vector<Rooms>();

	public Server() {
		init();
		addEventListener();
		textField.requestFocus();
	}
	private void init() {
		setSize(500,600);
		setTitle("소켓통신");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		//패널
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setBackground(Color.cyan);
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
	private void addEventListener() {
		textField.addActionListener(this);
		portstartbutton.addActionListener(this);
		portstopbutton.addActionListener(this);
		logbutton.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == portstartbutton) {
			
			if(textField.getText().length() == 0) {
				textArea.append("포트번호를 입력하세요.\n");
			}else if(textField.getText().length() != 0) {
				
				port = Integer.parseInt(textField.getText());
				startNetwork();
				textField.setEnabled(false);//작동x
				portstartbutton.setEnabled(false);// 작동x
				portstopbutton.setEnabled(true);//작동 o
			}
		}
		if(e.getSource() == portstopbutton) {
			try {
				serverSocket.close();
				textField.setEnabled(true);
				portstartbutton.setEnabled(true);
				portstopbutton.setEnabled(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == logbutton) {
//			String textAreaMsg = textArea; 
			String file = "ServerLog.txt";
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
//				bw.write(textAreaMsg);
				bw.flush();
				bw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	private void startNetwork() {
		try {
			serverSocket = new ServerSocket(port);
			textArea.append("서버를 시작합니다.\n");
			
			connet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void connet() {
		Thread connetTh = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {					
					try {
						textArea.append("유저의 접속을 기다립니다.\n");
						socket = serverSocket.accept();
						
						Users users = new Users(socket);
						users.start();
					} catch (IOException e) {
						textArea.append("서버가 중지됬습니다. 다시 서버실행 버튼을 눌러주세요.\n");
						break;
					}
				}
				
			}
		});
		connetTh.start();
	}
	
	
	
	
	
	
class Users extends Thread{
	
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	
	private Socket userSocket;
	String userName;
	
	
	public Users(Socket socket) {
		this.userSocket = socket;
		network();
	}
	private void network() {
		try {
			is = userSocket.getInputStream();
			dis = new DataInputStream(is);
			os = userSocket.getOutputStream();
			dos = new DataOutputStream(os);
			
			userName = dis.readUTF();
			textArea.append(userName + "님이 입장했습니다.\n");
			
			vc.add(this);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Stream설정에러!", "알림",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void run() {
		while(true) {
			try {
				String msg = dis.readUTF();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}





class Rooms{
	
}

	
	
	
	public static void main(String[] args) {
		new Server();

	}
	
}
