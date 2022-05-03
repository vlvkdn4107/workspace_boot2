package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import view.ServerView;

public class ServerService implements ServerInterface{

	
	private ServerService mContext;
	private ServerView serverView;
	private User user;

	private ServerSocket serverSocket;
	private Socket socket;
	
	private ServerData dataList;
	private StringBuffer totalLog;
	
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	
	
	int port;
	
	private boolean chcheck = true;
	
	
	
	
	public ServerView getServerView() {
		return serverView;
	}

	public void setServerView(ServerView serverView) {
		this.serverView = serverView;
	}

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}


	public ServerData getDataList() {
		return dataList;
	}

	public void setDataList(ServerData dataList) {
		this.dataList = dataList;
	}

	public StringBuffer getTotalLog() {
		return totalLog;
	}

	public void setTotalLog(StringBuffer totalLog) {
		this.totalLog = totalLog;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ServerService(ServerView serverView) {
		this.mContext = this;
		this.serverView = serverView;
		this.user = user;
		totalLog = new StringBuffer();
		dataList = ServerData.getinstance();
	}
	
	
	
	
	
	@Override
	public void starNetwork(int port) {
		try {
			serverSocket = new ServerSocket(port);
//			totalLog.append("서버를 시작합니다.");
			System.out.println("startNetwork서버 시작!");
			serverView.getTextArea().append("서버를 시작합니다.\n");
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
				while(true) {
					try {
						System.out.println("connect소켓!");
						serverView.getTextArea().append("유저를 기다립니다. \n");
						socket = serverSocket.accept();
						User user = new User(socket, mContext, dataList);
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
	public void broadCast(String msg) {//전체 사용자에게 보내는 메세지
		for (int i = 0; i < dataList.getUserlist().size(); i++) {
			System.out.println("broadCast");
			User user = dataList.getUserlist().get(i);
			user.sendmessage(msg);
			
		}
		
	}

	

	@Override// 클라1과 서버1의 개인적인 메세지
	public void inmessage(String msg) {
		System.out.println("서버 inMessag :" + msg);
		serverView.showLog(msg);
		StringTokenizer st = new StringTokenizer(msg , "@");
		String messageHd = st.nextToken();
		System.out.println("msHD: " + messageHd);
		String messageBd = st.nextToken();
		System.out.println("msBody: " + messageBd);
		
		String[] protocol = new String[2];
		protocol[0] = messageHd; 
		protocol[1] = messageBd;
//		runServer(protocol);
		
		if("newUser".equals(protocol[0])) {
			System.out.println("inmessage @@@@@@@@@@@@@");
			// 
			// 기존 사용자들한테 누가 들어 왔는지 알여 주면 된다. (브로드 캐스트) 
//			broadCast("newUser@" + dataList.userName());
			broadCast("newUser@" + dataList.userName(messageBd) + "dsadasd");
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
		StringTokenizer st = new StringTokenizer(msg,"@");
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

	public void DataRecept(String userName) {
		User user = dataList.userName(userName);
		for(User u : dataList.getUserlist()) {
			user.sendmessage("OldUser/" + u.getUserName());
		}
	}

}
