package chapter05_1;

import java.awt.Font;
import java.awt.Scrollbar;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame{
	private JPanel panel;
	private JTextField ipTextFd;
	private JTextField portTextFd;
	private JTextField idTextFd;
	private JTextField chattingTextFd;
	private JTextArea viewChatTextFd;
	private JButton connectBt;
	private JButton confirmBt;
	private JButton sendNoteBt;
	private JButton joinRommBt;
	private JList totalList; // 전체접속자 리스트
	private JList roomList; // 방 리스트
	private JButton makeRoomBt;
	private JButton outRoomBt;
	private JButton endBt;
	private JPanel panel_1;
	
	
	// network 자원
		private Socket socket;
		private String ip;
		private int port;
		private String user_id;
		private InputStream is;
		private OutputStream os;
		private DataInputStream dis;
		private DataOutputStream dos;

		// 그외 변수들
		private Vector<String> user_Vclist = new Vector<String>();
		private Vector<String> roomList_vc = new Vector<String>();
		private StringTokenizer st;
		private String my_roomName;

	
	
	public Client() {
		init();
	}
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 483);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);

		JTabbedPane Jtab = new JTabbedPane(JTabbedPane.TOP);
		Jtab.setBounds(12, 27, 328, 407);
		panel.add(Jtab);

		panel_1 = new JPanel();
		Jtab.addTab("로그인", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel hostIP_lbl = new JLabel("Host_IP ");		
		hostIP_lbl.setBounds(12, 25, 91, 15);
		panel_1.add(hostIP_lbl);//로그인 패널 안에 Host_IP 라벨 추가

		ipTextFd = new JTextField();
		ipTextFd.setBounds(112, 21, 199, 21);
		panel_1.add(ipTextFd);//로그인 패널 안에 Host_IP에 입력할수있는 텍스트필드 추가
		ipTextFd.setColumns(10);

		JLabel port_lbl = new JLabel("Server_Port");
		port_lbl.setBounds(12, 72, 91, 15);
		panel_1.add(port_lbl);//로그인 패널 안에 Server_Port 라벨 추가

		portTextFd = new JTextField();
		portTextFd.setBounds(112, 69, 199, 21);
		panel_1.add(portTextFd);//로그인 패널 안에 Server_Port에 입력할수있는 텍스트필드 추가
		portTextFd.setColumns(10);

		JLabel userID_lbl = new JLabel("User_ID");
		userID_lbl.setBounds(12, 122, 91, 15);
		panel_1.add(userID_lbl);//로그인 패널 안에 User_ID 라벨 추가

		idTextFd = new JTextField();
		idTextFd.setBounds(112, 119, 199, 21);
		panel_1.add(idTextFd);//로그인 패널 안에 User_ID에 입력할수있는 텍스트필드 추가
		idTextFd.setColumns(10);

		JLabel img_lbl = new JLabel("input the image");//이미지 넣을수 있게 해놓음
		img_lbl.setIcon(new ImageIcon());
		img_lbl.setBounds(12, 213, 299, 155);
		panel_1.add(img_lbl);//로그인 패널안에 이미지를 넣는다

		connectBt = new JButton("connect");
		connectBt.setBounds(214, 162, 97, 23);
		panel_1.add(connectBt);//로그인 패널 안에 connect에 입력할수있는 텍스트필드 추가

		JPanel panel = new JPanel();
		Jtab.addTab("대기실", null, panel, null);
		panel.setLayout(null);

		JLabel totalList_lbl = new JLabel("전체접속자");
		totalList_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		totalList_lbl.setBounds(12, 28, 102, 15);
		panel.add(totalList_lbl);

		JLabel roomList_lbl = new JLabel("방 리스트");
		Scrollbar scrollbar = new Scrollbar();
		roomList_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		roomList_lbl.setBounds(209, 27, 102, 15);
		
		panel.add(roomList_lbl);

		totalList = new JList();
		totalList.setBounds(12, 69, 102, 257);
		panel.add(totalList);

		roomList = new JList();
		roomList.setBounds(209, 69, 102, 257);
		panel.add(roomList);

		sendNoteBt = new JButton("쪽지보내기");
		sendNoteBt.setBounds(12, 345, 102, 23);
		panel.add(sendNoteBt);

		joinRommBt = new JButton("채팅방참여");
		joinRommBt.setBounds(209, 345, 102, 23);
		panel.add(joinRommBt);
		ipTextFd.setText("127.0.0.1");

		JPanel panel_2 = new JPanel();
		Jtab.addTab("채팅", null, panel_2, null);
		panel_2.setLayout(null);

		viewChatTextFd = new JTextArea();
		viewChatTextFd.setEnabled(false);
		viewChatTextFd.setEditable(false);
		viewChatTextFd.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		viewChatTextFd.setBounds(0, 0, 323, 337);
		panel_2.add(viewChatTextFd);

		chattingTextFd = new JTextField();
		chattingTextFd.setFont(new Font("휴먼모음T", Font.BOLD, 11));
		chattingTextFd.setBounds(0, 347, 214, 21);
		panel_2.add(chattingTextFd);
		chattingTextFd.setColumns(10);

		confirmBt = new JButton("전 송");
		confirmBt.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		confirmBt.setBounds(226, 346, 97, 23);
		panel_2.add(confirmBt);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(0, 0, 323, 337);
		panel_2.add(scrollPane);

		makeRoomBt = new JButton("방 만들기");
		makeRoomBt.setFont(new Font("휴먼모음T", Font.BOLD, 11));
		makeRoomBt.setBounds(352, 93, 97, 23);
		panel.add(makeRoomBt);

		outRoomBt = new JButton("방 나가기");
		outRoomBt.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		outRoomBt.setBounds(352, 150, 97, 23);
		panel.add(outRoomBt);
		outRoomBt.setEnabled(false);
		endBt = new JButton("종료");
		endBt.setFont(new Font("휴먼모음T", Font.BOLD, 12));
		endBt.setBounds(352, 398, 97, 23);
		panel.add(endBt);
		setVisible(true);

	}
	
	
	
	public static void main(String[] args) {
		new Client();

	}

}
