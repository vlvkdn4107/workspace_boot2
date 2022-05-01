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
	private boolean roomcheck = true;

	
	private Vector<UserSocket> userSockets = new Vector<>();
	private Vector<Room> roomVc = new Vector<>();
	
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
//
		if ("newUser".equals(protocol[0])) {
			// 기존 사용자들한테 누가 들어 왔는지 알여 주면 된다. (브로드 캐스트)
			// msg = "newUser@유저이름 
			for (UserSocket user : userSockets) {
				if(user.getName().equals("")) {
					user.firstEnter(protocol[1]);
				}
			}
			broadCast(msg);
		} else 	if("Catting".equals(protocol[0])) {
			broadCast(msg);
		}else if ("OldUser".equals(protocol[0])) {
			broadCast(msg);
		}else if("CreateRoom".equals(protocol[0])) {
			for (int i = 0; i < roomVc.size(); i++) {
				Room room = roomVc.get(i);
				if(room.getRoomName().equals(protocol[1])) {
					broadCast("CreateRoomFail@ok");
					roomcheck = false;
					break;
				}else {
					roomcheck = true;
				}
			}
			if(roomcheck = true) {//@@@@@@@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!!같은 방이름이 있어도 생성이됨 왜???
				System.out.println("생성이 왜 되는거지????");
				Room newRoom = new Room(protocol[1], mContext);
				roomVc.add(newRoom);
				broadCast("CreateRoom@" + protocol[1]);
			}
		}else if ("JoinRoom".equals(protocol[0])) {
			System.out.println("서버쪽 inmessage@@@" + msg);
			System.out.println(roomVc.size() + " <<<<<<<<<<<room 벡터의 사이즈");
			for (int i = 0; i < roomVc.size(); i++) {
				Room r = roomVc.get(i);
				if(r.getRoomName().equals(protocol[1])) {
					
				}
			}
			broadCast(msg);
		}
		
		

	}

	@Override
	public void roomBroadcast(String str) {
		

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
