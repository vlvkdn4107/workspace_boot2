package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import view.ServerView;

public class User extends Thread {
	
	private ServerService mContext;
	private ServerData serverData;
	private ServerView serverView;
	
	
	private String userName;
	private Socket userSocket;
	
	private DataInputStream dis;
	private DataOutputStream dos;
	
	StringBuffer check;
	
	private User userContext;
	
	
	

	public ServerData getServerData() {
		return serverData;
	}
	public void setServerData(ServerData serverData) {
		this.serverData = serverData;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Socket getUserSocket() {
		return userSocket;
	}
	public void setUserSocket(Socket userSocket) {
		this.userSocket = userSocket;
	}
	public DataInputStream getDis() {
		return dis;
	}
	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}
	public DataOutputStream getDos() {
		return dos;
	}
	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}
	public StringBuffer getCheck() {
		return check;
	}
	public void setCheck(StringBuffer check) {
		this.check = check;
	}
	
	
	public User(Socket userSocket, ServerService mContext , ServerData serverData ) {
		System.out.println("흐름이 여기까지 들어 오나요 ? 11111111");
		this.serverData = serverData;
		this.userSocket = userSocket;
		this.mContext = mContext;
		userName = "";
//		serverData.getUserlist().add(this);
//		check = new StringBuffer();
//		check.append("");
		
	}
	
	
	
	
	@Override
	public void run() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						dis = new DataInputStream(userSocket.getInputStream());
						dos = new DataOutputStream(userSocket.getOutputStream());
						userName = dis.readUTF();
						
						 mContext.getServerView().getTextArea().append("[" + userName + "]님이 입장했습니다.\n" );
						 String msg = dis.readUTF();
						
//						 serverInterface.inmessage(msg);
						 System.out.println("user socket msg : " +  msg);
						 mContext.inmessage(msg);
						 
						
						// 메세지 를 어디에 넣을건지 만들어야된다
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
	
	public void sendmessage(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
