package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
import view.ServerView;

@Getter
@Setter
public class ServerService implements ServerInterface {

	private ServerView mContext;
	
	private ServerSocket serverSocket;
	private Socket socket;
	
	private StringBuffer totalLog;
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	int port;
	private boolean chcheck = true;

	
	private Vector<UserSocket> userSockets = new Vector<>();
	
	public ServerService(ServerView mContext) {
		this.mContext = mContext;
		totalLog = new StringBuffer();
	}

	@Override
	public void starNetwork(int port) {
		try {
			serverSocket = new ServerSocket(port);

			System.out.println("startNetwork서버 시작!");
			mContext.getTextArea().append("서버를 시작합니다.\n");
			connect();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	@Override
	public void connect() {
		Thread th = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("connect소켓!");
						mContext.getTextArea().append("유저를 기다립니다. \n");
						socket = serverSocket.accept();
						
						UserSocket user = new UserSocket(socket, mContext);
						user.start();

					} catch (IOException e) {

						break;
					}
				}

			}
		});
		th.start();
	}

	@Override
	public void broadCast(String msg) {// 전체 사용자에게 보내는 메세지
		for (int i = 0; i < userSockets.size(); i++) {
			System.out.println("broadCast");
			UserSocket user = userSockets.get(i);
			user.sendmessage(msg);

		}

	}

	@Override // 클라1과 서버1의 개인적인 메세지
	public void inmessage(String msg) {
		System.out.println("서버 inMessag :" + msg);
		
		StringTokenizer st = new StringTokenizer(msg, "@");
		String messageHd = st.nextToken();
		System.out.println("msHD: " + messageHd);
		String messageBd = st.nextToken();
		System.out.println("msBody: " + messageBd);

		String[] protocol = new String[2];
		protocol[0] = messageHd;
		protocol[1] = messageBd;
//		runServer(protocol);

		if ("newUser".equals(protocol[0])) {
			System.out.println("inmessage @@@@@@@@@@@@@");
			// 기존 사용자들한테 누가 들어 왔는지 알여 주면 된다. (브로드 캐스트)
			// msg = "newUser@유저이름 
			broadCast(msg);
		} else if("Catting".equals(protocol[0])) {
			System.out.println("서버에서 전체 메세지 보냄 " + msg);
			broadCast(msg);
		}

//		if(chcheck == true) {
//			if(protocol.equals(null));
//			msg= st.nextToken();
//			for (int i = 0; i < serverData.getUserlist().size(); i++) {
//				User u = serverData.getUserlist().get(i);
//				if(u.getUserName().equals(message)) {
//					broadCast(u.getUserName() + ":" + msg);
//				}
//			}
//			
//		}

	}

//	public void runServer(String[] partedMs) {
//		/*  ex>   admission/nickname
//		 *  ex>   Message/reciver>caller@contents
//		 *   (User)protocal -> inmessage() < admission , nickname >
//		 *   
//		 */
//		String[] protocol = partedMs;
//		dataList = ServerData.getinstance();
//		switch (protocol[0]) {
//		case "uewUser/":		
//			dataList.userName("").setUserName(protocol[1]);
//			String msg = "Newuser/" + protocol[1];
//			System.out.println(msg);			
//			broadCast(msg);
//			DataRecept(protocol[1]);
//			break;
//		case "OldUser/":
//			DataRecept(protocol[1]);
//			// OledUser/name
//			break;
//		case "Chatting/":
//			chatting(protocol[1]);
//			break;
//		case "Whisper/":
//			//Whisper/userName
//			break;
//		default:
//			break;
//		}
//	}
	@Override
	public void chatting(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "@");
		String userName = st.nextToken();

	}

	@Override
	public void roomBroadcast(String str) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeRoom() {
		// TODO Auto-generated method stub

	}

	

}
