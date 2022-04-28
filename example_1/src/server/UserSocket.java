package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import view.ServerView;


public class UserSocket extends Thread {

	private ServerView mContext;
	private String userName;
	private Socket userSocket;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	
	public UserSocket(Socket userSocket, ServerView mContext) {
		this.userSocket = userSocket;
		this.mContext = mContext;
		
		// 기능 구현 
		// 새로운 유저가 왔다라고 알려야 한다. 
		// 완전 첫 사용자 !!! --> 
		
		// 서버 서비스가 관리하는 소켓리스에 나 자신을 더해 준다.!!!
		mContext.getServerService().getUserSockets().add(this);
	}
	

	@Override
	public void run() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						dis = new DataInputStream(userSocket.getInputStream());
						dos = new DataOutputStream(userSocket.getOutputStream());
						userName = dis.readUTF();

						mContext.getTextArea().append("[" + userName + "]님이 입장했습니다.\n");
						String msg = dis.readUTF();
						System.out.println("user socket msg : " + msg);
						mContext.getServerService().inmessage(msg);

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
