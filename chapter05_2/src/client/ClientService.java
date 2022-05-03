package client;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import view.ClientView;
import view.ClientView2;

public class ClientService implements ClientInterface {

	private ClientView clientView;
	private ClientView2 clientView2;

	private Socket socket;

	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;

	
	private String userName = "";
	private String ip;
	private int port;

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
//	public ClientService(ClientView clientView, ClientView2 clientView2) {
//		this.clientView = clientView;
//		this.clientView2 = clientView2;
//	}
	
	public ClientService(ClientView clientView) {//생성자
		this.clientView = clientView;
	}
	
	public void setClientView2(ClientView2 clientView2) { //메서드로 처리해서 사용
		this.clientView2 = clientView2;
	}
	

	@Override
	public void connectServer() {

		try {
			socket = new Socket(clientView.getIp(), clientView.getPort());
			network();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void network() {

		try {
			System.out.println("networkOK");
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			//this.userName = clientView.getIdField().getText().trim();

		

			Thread cht = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							String msg = dis.readUTF();
							inmessage(msg);
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "서버가 종료됨!", "알림", JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			});
			cht.start();
			
			newUser(userName);

			//sendmessage(userName);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		}

	}

	
	public void newUser(String msg) {//작동 @@
		msg = "newUser@"+ userName;
		System.out.println("-------------------");
		System.out.println(msg);
		System.out.println("-------------------");
		sendmessage(msg);
	}

	public void chat(String msg) {
		// 멤버 변수 userName 
		
		System.out.println("@@@@chat@@@@" + userName);
		msg =  "Catting@" + msg;
		System.out.println("chat userName" + userName);
		System.out.println("chat :" +msg);
		
		sendmessage(msg);
	}

	@Override
	public void sendmessage(String msg) {
		System.out.println("snedMS" + msg);
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String[] getLog(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "@");
		String logHd = st.nextToken();
		String logBd = st.nextToken();

		String[] protocol = new String[2];

		protocol[0] = logHd;
		protocol[1] = logBd;

		
		return protocol;
		
	}
	@Override
	public void runServer() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {

						String msg = dis.readUTF();
						System.out.println(userName + "@@@" + msg);
						String[] protocal = getLog(msg);

						switch (protocal[0]) {
						case "uewUser":
							clientView.userUpdate(protocal[1]);
							break;
						case "OldUser":
							clientView.userUpdate(protocal[1]);
						case "Chatting":
							chat(msg);
							clientView2.getTextArea().append(protocal[1]);
						default:
							break;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

	}
	@Override
	public void inmessage(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "@");
		String protocol = st.nextToken();
		String message = st.nextToken();

		if (protocol.equals("Catting")) {
			msg = st.nextToken();
			clientView2.getTextArea().append(message + "@" + msg + "@");
		} else if (protocol.equals("newUser")) {
			runServer();
			
		}
	}
}
