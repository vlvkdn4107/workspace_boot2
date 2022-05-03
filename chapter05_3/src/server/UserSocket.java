package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class UserSocket extends Thread{

	ServerFile mContext;
	
	Socket socket;
	
	InputStream is;
	OutputStream os;
	DataInputStream dis;
	DataOutputStream dos;
	
	public UserSocket(ServerFile mContext, Socket socket) {
		this.mContext = mContext;
		this.socket = socket;
		
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					String msg = dis.readUTF();
					mContext.broadCast(msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	public void sendmessage(String msg) {
		try {
			dos.writeUTF(msg + "\n");
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
