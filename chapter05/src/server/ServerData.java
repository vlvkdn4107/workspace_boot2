package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ServerData implements ServerInterface{

	
	
	//서버뷰 포함 관계
	ServerView serverView;
	
	private Vector<Users> vc = new Vector<Users>();
	private Vector<Rooms> roomvc = new Vector<Rooms>();

	public Vector<Users> getVc() {
		return vc;
	}

	public void setVc(Vector<Users> vc) {
		this.vc = vc;
	}
	public Vector<Rooms> getRoomvc() {
		return roomvc;
	}

	public void setRoomvc(Vector<Rooms> roomvc) {
		this.roomvc = roomvc;
	}

	

	
	
	@Override
	public void broadCast(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			Users users = vc.get(i);
			
			users.sendmessage(msg);
		}
		
	}

	//내부 클래스
	class Users extends Thread{
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		String userName;
		String myCurrentRoomName;
		private Socket userSocket;
		ServerData mContext;
		
		private boolean roomCheck = true;
		
		public Users(ServerData mContext,Socket soc) {
			this.mContext = mContext;
			this.userSocket = soc;
			network();
		}
		
		public void network() {
			try {
				is = userSocket.getInputStream();
				dis = new DataInputStream(is);
				os = userSocket.getOutputStream();
				dos = new DataOutputStream(os);
				
				//처음 접속시 유저의 id를 받는다
				userName = dis.readUTF();
				serverView.getTextArea().append("[" + userName +"] 님이 입장했습니다.\n");
				
				broadCast("NewUser/" + userName);
				
				for (int i = 0; i < vc.size(); i++) {
					Users users = vc.get(i);
					sendmessage("OldUser/" + users.userName);
				}
				for (int i = 0; i < roomvc.size(); i++) {
					Rooms rooms = roomvc.get(i);
					sendmessage("OldRoom/" + rooms.roomName);
				}
				vc.add(this);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream설정에러!", "알림",
						JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
		@Override
		public void run() {
			new Thread(new Runnable() {			
				@Override
				public void run() {
					while(true) {
						try {
							String msg = dis.readUTF();
							System.out.println("rkskek");
							serverView.getTextArea().append(userName + "가" + msg + "\n");
							System.out.println("akqktk");
							inmessage(msg);
						} catch (IOException e) {
							
							try {
								serverView.getTextArea().append(userName + " : 유저가 접속 끊어졌습니다.\n");
								dos.close();
								dis.close();
								userSocket.close();
								vc.remove(this);
								roomvc.remove(this);
								broadCast(userName + "님이 나갔습니다.");
//								broadCast();
								break;
							} catch (IOException e1) {
								break;
							}
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
	
	
	

	@Override
	public void inmessage(String str) {
		StringTokenizer st = new StringTokenizer(str, "/");//주석,따옴표 건너뜀
		String protocol = st.nextToken();
		String message = st.nextToken();
		if(protocol.equals("Chatting")) {
			String msg = st.nextToken();
			
			
		}
	}

	

	
	


	class Rooms{
		String roomName;
		Vector<Users> userRoomVc = new Vector<Users>();
		public Rooms(String roomName, Users u) {
			this.roomName = roomName;
			this.userRoomVc.add(u);
			u.myCurrentRoomName = roomName;//Users에 myCurrentRoomName = roomName이다.
			
		}
		public void roomBroadcast(String str) {
			for (int i = 0; i < userRoomVc.size(); i++) {
				Users u = userRoomVc.get(i);
				u.sendmessage(str);
			}
			
		}
		public void addUser(Users u) {
			userRoomVc.add(u);
			
		}
		@Override
		public String toString() {
			return roomName;
		}

		public void removeRoom(Users u) {
			userRoomVc.remove(u);
			boolean empty = userRoomVc.isEmpty();
			if(empty) {
				for (int i = 0; i < roomvc.size(); i++) {
					Rooms r = roomvc.get(i);
					if(r.roomName.equals(roomName)) {
						roomvc.remove(this);
						broadCast("EmptyRoom/" + roomName);
						broadCast("UserData_Update/ok");
						break;
					}
				}
			}
			
		}

	}




	



	



	




	









	



	

	

	
	
}
