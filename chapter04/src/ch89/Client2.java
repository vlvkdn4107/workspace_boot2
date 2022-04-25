package ch89;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Client2 extends JFrame implements ActionListener{

	Client client;
	
	
	JPanel panel;	
	JButton logoutButton;
	JButton addRoomBt;//방 생성
	JButton entranceRoomBt;//방 생성
	JButton outRoomBt;//방 나가기
	JButton whisperBt;//귓속말
	
	JLabel label;
	
	
	JList userList;
	JList roomList;
	
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	
	
	private StringTokenizer st;
	private String roomName;
	
//	private Vector<String> userVc = new Vector<String>();
//	private Vector<String> roomVc = new Vector<String>();
	
	public Client2() {
		init();
		addEventListener();
	}
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		panel.setBackground(Color.cyan);
		setContentPane(panel);
		panel.setLayout(null);
		
		logoutButton = new JButton("로그아웃");
		logoutButton.setBounds(285, 430, 90, 20);
		panel.add(logoutButton);
		
		addRoomBt = new JButton("방생성");
		addRoomBt.setBounds(10, 10, 90, 30);
		panel.add(addRoomBt);
		
		entranceRoomBt = new JButton("방입장");
		entranceRoomBt.setBounds(10, 80, 90, 30);
		panel.add(entranceRoomBt);
		
		whisperBt = new JButton("귓속말");
		whisperBt.setBounds(285, 10, 90, 30);
		panel.add(whisperBt);
		
		ScrollPane scroll = new ScrollPane();
		scroll.setBounds(120, 10, 140, 100);
		userList = new JList();
		scroll.add(userList);
		panel.add(scroll);
		
		ScrollPane roomscroll = new ScrollPane();
		roomscroll.setBounds(10, 120, 365, 300);
		roomList = new JList();
		roomscroll.add(roomList);
		panel.add(roomscroll);
		
		setVisible(false);
	}
	private void addEventListener() {
		logoutButton.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logoutButton) {
			client = new Client();
			setVisible(false);
			client.setVisible(true);
		}
		
	}
	public void network() {
		try {
			
			is = client.socket.getInputStream();
			dis = new DataInputStream(is);
			os = client.socket.getOutputStream();
			dos = new DataOutputStream(os);
			
			
			client.userName = client.idField.getText().trim();
			sendmessage(client.userName);
			
			client.getUserVc().add(client.userName);
			userList.setListData(client.getUserVc());
			
			Thread networkTh = new Thread(new Runnable() {			
				@Override
				public void run() {
					while(true) {
						try {
							String msg; msg = dis.readUTF();
							 inmessage(msg);
						} catch (IOException e) {
							
							try {
								client.getUserVc().removeAll(client.getUserVc());
								userList.setListData(client.getUserVc());
								is.close();
								os.close();
								dis.close();
								dos.close();
								client.socket.close();
								break;
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								return;
							}
							
						}
					
					}
				}
			});
			networkTh.start();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
private void inmessage(String str) {
		
		st = new StringTokenizer(str, "/");
		
		String protocol = st.nextToken();
		String message = st.nextToken();
		if(protocol.equals("NewUser")){
			client.getUserVc().add(message);
			userList.setListData(client.getUserVc());
		}
	}
	private void sendmessage(String msg){
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
