package server;

import java.net.Socket;

public class ServerSocket {

	private Socket socket;
	private ServerSocket serverSocket;
	private int port;
	
	private void connet() {
		Thread connectTh = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
		connectTh.start();
	}
	
}
