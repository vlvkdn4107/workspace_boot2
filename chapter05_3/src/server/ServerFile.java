package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import view.ServerView;

public class ServerFile {

	ServerView serverView;
	ServerSocket serverSocket;
	Vector<UserSocket> sockets = new Vector<>();
	
	public ServerFile() {
		try {
			serverSocket = new ServerSocket();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			try {
				Socket socket = serverSocket.accept();
				serverView.getTextArea().append("서버시작");
				UserSocket userSocket = new UserSocket(this, socket);
				userSocket.start();
				sockets.add(userSocket);
				new UserSocket(this, socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void broadCast(String msg) {
		for (int i = 0; i < sockets.size(); i++) {
			sockets.get(i).sendmessage(msg);
		}
	}
	
	
	
}
