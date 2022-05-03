package ch88;

import java.awt.ScrollPane;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Server extends JFrame implements ActionListener {

	// GUI 자원
	private JPanel contentPane;
	private JTextField tfPort;
	private JTextArea textArea;
	private JLabel lblPortNum;
	private JButton btnServerStart;
	private JButton btnServerStop;

	// Network 자원
	private ServerSocket server_socket;
	private Socket socket;
	private int port;

	// 그외 자원들
	private Vector<UserInfomation> vc = new Vector<UserInfomation>();
	private Vector<RoomInfomation> vc_room = new Vector<RoomInfomation>();
	

	public Server() {
		init();
		addListener();
		tfPort.requestFocus();
	}

	// GUI 초기화
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 10, 309, 229);
		textArea = new JTextArea();
		textArea.setBounds(12, 11, 310, 230);
		scrollPane.add(textArea);//스크롤 패인에 텍스트아레아를 넣는다
		contentPane.add(scrollPane); //패널에 스크로롤패인을 넣는다
		textArea.setEditable(false); //이 textArea 텍스트를 편집할수있게 

		lblPortNum = new JLabel("포트번호 :");
		lblPortNum.setBounds(12, 273, 82, 15);
		contentPane.add(lblPortNum);

		tfPort = new JTextField();//포트 적는곳
		tfPort.setBounds(98, 270, 224, 21);
		contentPane.add(tfPort);
		tfPort.setColumns(10);

		btnServerStart = new JButton("서버실행");
		btnServerStart.setBounds(12, 315, 154, 23);
		contentPane.add(btnServerStart);

		btnServerStop = new JButton("서버중지");
		btnServerStop.setBounds(168, 315, 154, 23);
		contentPane.add(btnServerStop);
		btnServerStop.setEnabled(false);

		setVisible(true);
	}

	// 이벤트 리스너
	private void addListener() {

		tfPort.addActionListener(this);
		btnServerStart.addActionListener(this);
		btnServerStop.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnServerStart) {
			if (tfPort.getText().length() == 0) {// start버튼 클릭시 tfPort에 값이 없으면 값을 입력하세요라는 문구가 나오고
				System.out.println("  값을 입력 하세요 ");
			} else if (tfPort.getText().length() != 0) {// start클릭시 tfPort에 값이있으면 밑에 실행

				// 값을 가져와서 port변수에 저장시키기
				port = Integer.parseInt(tfPort.getText());
				startNetwork();
				tfPort.setEditable(false);//네트워크를 시작하면 작동 못하게 만듬
				btnServerStart.setEnabled(false);//네이워크를 시작하면 작동 못하게 만듬
				btnServerStop.setEnabled(true);//네이워크를 시작하면 작동하게 만듬
			}

		} else if (e.getSource() == btnServerStop) {//stop버튼을 누르면 
			try {
				server_socket.close();//서버 끔
				vc.removeAllElements();//모든 요소 삭제
				vc_room.removeAllElements();//모든 요소 삭제
				tfPort.setEditable(true);//다시 재 작동
				btnServerStart.setEnabled(true);//다시 재 작동
				btnServerStop.setEnabled(false); // 작동 못하게 만듬
			} catch (IOException e1) {

			}
		}
	}

	private void startNetwork() {
		try {
			server_socket = new ServerSocket(port);//소켓안에 포트 넣기
			textArea.append("서버를 시작 하겠습니다.\n");
			
			connect();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트입니다.", "알림",
					JOptionPane.ERROR_MESSAGE);//에러 메세지를 보여줘라
			btnServerStart.setEnabled(true);
			btnServerStop.setEnabled(false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "잘못입력하였습니다.", "알림",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void connect() {//멀티 쓰레드 사용해서 유저들을 받는다?
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {//포트번호를 입력하고 서버를 생성후 실행하는 곳
						textArea.append("사용자의 접속을 기다립니다.\n");
						socket = server_socket.accept();

						UserInfomation useInfo = new UserInfomation(socket);//유저 인포생성루 소켓을 넣음
						// 각각의 스레드를 등록시켜준다.
						useInfo.start();
						
						//여기서 백터에 등록 하지 않음!!!!
					} catch (IOException e) {
						textArea.append("서버가 중지됨! 다시 스타트 버튼을 눌러주세요\n");
						break;
					}
				}
			}
		});
		th.start();
	}

	// 전체 사용자에게 메세지를 보내는 부분
	public void broadCast(String str) {
		for (int i = 0; i < vc.size(); i++) {
			UserInfomation uinf = vc.elementAt(i);// 유저인포메이션은 백테의 모든 구성요소를 반환한다?
			// 여기서 프로토콜의 개념을 사용
			
			uinf.sendmessage(str);//유저인포메이션에 보낸다
			
		}
	}

	// 내부클래스
	class UserInfomation extends Thread {
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;
		String nickName;
		String myCurrentRoomName;
		private Socket user_socket;

		private boolean roomCheck = true;

		public UserInfomation(Socket soc) {
			this.user_socket = soc;
			network();
		}

		private void network() {
			try {
				is = user_socket.getInputStream();// 유저의 소켓을 들고와서 읽는다
				dis = new DataInputStream(is);//유저의 데이터스트림을 읽는다?
				os = user_socket.getOutputStream(); //유저의 소켓을 들고와서 다시 내보낸다
				dos = new DataOutputStream(os);

				// 처음 접속시 유저의 id를 입력받는다.
				nickName = dis.readUTF();//dis의 문자열 읽기
				textArea.append("[[" + nickName + "]] 입장\n");

				// 기존사용자들에게 신규 유저의 접속을 알린다.
				broadCast("NewUser/" + nickName);//이시점에는 c1한테만 메세지가 전달된다.
				//클라1 클라2가 실행 시점
				
				

				// 자신에게 기존 사용자들을 알린다.
				for (int i = 0; i < vc.size(); i++) {//유저
					UserInfomation uinf = vc.elementAt(i);//get으로 사용해도됨
					//브로드 캐스트가 아님 x 나와 연결 되어있는 stream을 통해서 보낸다...
					sendmessage("OldUser/" + uinf.nickName);
				}
				for (int i = 0; i < vc_room.size(); i++) {//방
					RoomInfomation room = vc_room.get(i);//get으로 사용해도됨
					sendmessage("OldRoom/" + room.roomName);
				}

				// 사용자에게 자신을 알린후 벡터에 자신을 추가한다.
				vc.add(this);//자신을 알린후 백터에 자신을 추가

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Stream설정에러!", "알림",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		// 브로드캐스트
		@Override
		public void run() {
			while (true) {
				try {
					String msg = dis.readUTF();
					
					textArea.append("[["+ nickName + "]]" + msg + "\n");//유저가 하는 모든 행동에 대한 append
					inmessage(msg);
				} catch (IOException e) {
					try {
						textArea.append(nickName + " : 사용자접속끊어짐\n");
						dos.close();
						dis.close();
						user_socket.close();
						vc.remove(this);
						vc_room.remove(this);
						broadCast("UserOut/" + nickName);
						broadCast("ErrorOutRoom/"+myCurrentRoomName);
						broadCast("UserData_Updata/ok");
						break;
					} catch (IOException e1) {
						break;
					}
				}
			}
		}
        //"Note/안녕" 
		//"createRoom/1번방"
		
		private void inmessage(String str) {
			StringTokenizer st = new StringTokenizer(str, "/");//주석 따옴표 건너뜀 		  
			String protocol = st.nextToken();//nextToken = 존재하는 토근 리턴?
			String message = st.nextToken();

			System.out.println("protocol : " + protocol);
			System.out.println("message : " + message);

			System.out.println(protocol + "맞음?");
			System.out.println(protocol + "가다나다라바마");
			if (protocol.equals("Note")) {//클라이언트에서 버튼을 누르면 Note라고 설정해놓음
				System.out.println(message + "모임?");
				st = new StringTokenizer(message, "@");
				String user = st.nextToken();
				String note = st.nextToken();
				// 백터에서 해당 사용자를 찾아서 쪽지를 전송한다.
				for (int i = 0; i < vc.size(); i++) {
					UserInfomation u = vc.elementAt(i);
					// 쪽지는 반드시 찾은 사용자에게 메세지를 보내줘어야 한다.
					if (u.nickName.equals(user)) {
						u.sendmessage("Note/" + nickName + "@" + note);
					}
				}
			} else if (protocol.equals("CreateRoom")) {
				// 1.현재같은방이 존재하는지 확인한다.
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation room = vc_room.elementAt(i);
					
					if (room.roomName.equals(message)) { // 만들고자하는방이름을 확인한다
						sendmessage("CreateRoomFail/ok");
						roomCheck = false;
						break;
					} else {
						roomCheck = true;
					}
				} // end for
				
				if (roomCheck == true) {
					// 1.방을 생성한다.
					RoomInfomation new_room = new RoomInfomation(message, this);
					// 2. 전체 방 벡터에 생성된 방을 저장한다.
					vc_room.add(new_room);
					// 3.사용자들에게 방과 방이름을 생성되었다고 알려준다.
					sendmessage("CreateRoom/" + message); // 자신에게 방 성공 메세지를 보낸다.
					broadCast("new_Room/" + message);//   유저에서 새로운 방이 생겼다고 알려준다.
				}
			} else if (protocol.equals("Chatting")) {
				String msg = st.nextToken();
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						r.roomBroadcast("Chatting/" + nickName + "/" + msg);
					}
				}
			} else if (protocol.equals("JoinRoom")) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						// 신규접속자를 알린다.
						r.roomBroadcast("Chatting/[[알림]]/(((" + nickName
								+ " 입장))) ");
						r.addUser(this); // 해당 룸 객체에 자신을 추가시킨다.
						sendmessage("JoinRoom/" + message);
					}
				}
			} else if (protocol.equals("OutRoom")) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(message)) {
						r.removeRoom(this);
						sendmessage("OutRoom/ok");
						break;
					}
				}
			}
		}

		private void sendmessage(String msg) { //클라1와 서버1만 개별적으로 보내는 메세지
			try {
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	// 내부클래스
	class RoomInfomation {

		String roomName;
		Vector<UserInfomation> room_user_vc = new Vector<UserInfomation>();

		public RoomInfomation(String roomName, UserInfomation u) {
			this.roomName = roomName;
			this.room_user_vc.add(u);
			//와우 대박. ㅋㅋ
			u.myCurrentRoomName = roomName;
		}

		private void roomBroadcast(String str) { // 현재방의 모든 사람들에게 알린다.
			for (int i = 0; i < room_user_vc.size(); i++) {
				UserInfomation u = room_user_vc.elementAt(i);
				u.sendmessage(str);
			}
		}

		private void addUser(UserInfomation u) {
			room_user_vc.add(u);
		}
		@Override
		public String toString() {
			return roomName;
		}

		private void removeRoom(UserInfomation u) {
			room_user_vc.remove(u);
			boolean empty = room_user_vc.isEmpty();
			if (empty) {
				for (int i = 0; i < vc_room.size(); i++) {
					RoomInfomation r = vc_room.elementAt(i);
					if (r.roomName.equals(roomName)) {
						vc_room.remove(this);
						broadCast("EmptyRoom/"+roomName);
						broadCast("UserData_Updata/ok");
						break;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Server();
	}
}
