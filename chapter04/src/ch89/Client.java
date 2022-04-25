package ch89;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ch89.Server.Users;

public class Client extends JFrame implements ActionListener{
	
	
	
	Client2 client2;
	
	JPanel mainPanel;
	JLabel ipLabel;
	JLabel portLabel;
	JLabel idLabel;
	JTextField ipField;
	JTextField portField;
	JTextField idField;
	JButton loginBt;// 로그인 
	
	
	
	
	//network 자원
	Socket socket;
	public Vector<String> getUserVc() {
		return userVc;
	}
	public void setUserVc(Vector<String> userVc) {
		this.userVc = userVc;
	}
	public Vector<String> getRoomVc() {
		return roomVc;
	}
	public void setRoomVc(Vector<String> roomVc) {
		this.roomVc = roomVc;
	}
	String ip;
	String userName;
	private int port;
	
	
	private Vector<String> userVc = new Vector<String>();
	private Vector<String> roomVc = new Vector<String>();


	
	
	public Client() {
		init();
		addEventListener();
	}
	private void init() {
		setTitle("클라이언트");
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5,5,5,5));
		mainPanel.setBackground(Color.cyan);
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		ipLabel = new JLabel("IP");
		ipLabel.setBounds(30, 210, 70, 30);
		mainPanel.add(ipLabel);
		ipField = new JTextField();
		ipField.setBounds(30, 240, 325, 30);
		mainPanel.add(ipField);
		ipField.setText("127.0.0.1");
		
		portLabel = new JLabel("PORT");
		portLabel.setBounds(30, 270, 70, 30);
		mainPanel.add(portLabel);
		portField = new JTextField();
		portField.setBounds(30, 300, 325, 30);
		mainPanel.add(portField);
		
		idLabel = new JLabel("ID");
		idLabel.setBounds(30, 330, 70, 30);
		mainPanel.add(idLabel);
		idField = new JTextField();
		idField.setBounds(30, 360, 325, 30);
		mainPanel.add(idField);
		
		loginBt = new JButton("로그인");
		loginBt.setBounds(254, 400, 100, 30);
		mainPanel.add(loginBt);
		
		setVisible(true);
	}
	
	private void loginServer() {
		try {
			socket = new Socket(ip,port);			
			client2 = new Client2();			
			setVisible(false);
			client2.setVisible(true);
			client2.network();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	private void addEventListener() {
		loginBt.addActionListener(this);							
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBt) {			
			if(ipField.getText().length() == 0) {
					ipField.setText("ip를 입력해주세요");
					ipField.requestFocus();
			}else if(portField.getText().length() == 0) {
					portField.setText("포트번호를 입력해주세요");
					portField.requestFocus();
			}else if(idField.getText().length() == 0) {
					idField.setText("아이디를 입력해주세요");
					idField.requestFocus();
			}else {
				ip = ipField.getText();
				try {
					port = Integer.parseInt(portField.getText().trim());
				}catch(Exception e2) {
					portField.setText("잘못 입력했습니다.");
				}
				userName = idField.getText().trim();
				loginServer();
				
			}
			
			
		}
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
			
//		
//		
//	}
	
	
	



}
