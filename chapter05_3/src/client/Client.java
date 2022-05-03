package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import view.ClientView;
import view.ClientView2;

public class Client {

	Socket socket;
	
	ClientView clientView;
	ClientView2 clientView2;
	
	
	DataOutputStream dos;
	DataInputStream dis;
	String ip;
	int port;
	
	public Client() {
		try {
			socket = new Socket(ip, port);
			
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			
			Thread th = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
				
				try {
					String msg =  clientView2.getTextField().getText();
					dos.writeUTF(msg + "\n");
					dos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
					}
					
				}
			});
			th.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private class InputThread implements Runnable{
		public void run() {
			while(true) {
				try {
					String msg = dis.readUTF();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}
}
