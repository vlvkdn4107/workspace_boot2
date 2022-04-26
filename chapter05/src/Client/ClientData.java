package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

import server.ServerData;
import server.ServerView;

public class ClientData implements ClientInterface, ActionListener{

	
	
	
	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;
	
	private StringTokenizer st;
	
	private String myRoomName;
	
	ClientView clientView = new ClientView();
	ClientView2 clientView2 = new ClientView2();
	
	
	
	private Vector<String> user_Vclist = new Vector<String>();
	private Vector<String> roomList_vc = new Vector<String>();
	
	public String getMyRoomName() {
		return myRoomName;
	}
	public void setMyRoomName(String myRoomName) {
		this.myRoomName = myRoomName;
	}
	public ClientData() {
		
	}

	@Override
	public void connectServer() {
		try {
			//서버 접속
			System.out.println("&&&&&&&&&&&");
			clientView.socket = new Socket(clientView.getIp(),clientView.getPort());		
			
			network();
			clientView.setVisible(false);
			clientView2.setVisible(true);
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림",
					JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	@Override
	public void network() {
		try {
			is = clientView.getSocket().getInputStream();
			dis = new DataInputStream(is);
			os = clientView.getSocket().getOutputStream();
			dos = new DataOutputStream(os);
			
			clientView.userId = clientView.getIdField().getText().trim();
			sendmessage(clientView.userId);
			
			
			user_Vclist.add(clientView.userId);
			clientView2.getUserList().setListData(user_Vclist);
			
			Thread cth = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						
						try {
							String msg = dis.readUTF();
							inmessage(msg);
						} catch (IOException e) {							
							try {
								user_Vclist.removeAll(user_Vclist);
								roomList_vc.removeAll(roomList_vc);
								clientView2.getUserList().setListData(user_Vclist);
								clientView2.getRoomList().setListData(roomList_vc);
								is.close();
								os.close();
								dis.close();
								dos.close();
								clientView.socket.close();
								JOptionPane.showMessageDialog(null, "서버가 종료됨!", "알림",
										JOptionPane.ERROR_MESSAGE);
								break;
							} catch (IOException e1) {
								break;
							}
							
						}
						
					}
					
				}
			});
			cth.start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림",
					JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	@Override
	public void inmessage(String str) {
		st = new StringTokenizer(str, "/");
		String protocol = st.nextToken();
		String message = st.nextToken();
		
		if(protocol.equals("Chatting")){
			String msg = st.nextToken();
			clientView2.getTextArea().append(message + " : " + msg + "/n");
		}
		
	}
	@Override
	public void sendmessage(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
