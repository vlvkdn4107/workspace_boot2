package view;

import java.awt.Color;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client.ClientInterface;
import client.ClientService;
import lombok.Getter;


@Getter
public class ClientView2 extends JFrame implements ActionListener{

	private ClientView mContext;
	private ClientService clientService;

	
	JPanel panel;	
	JButton logoutButton;
	JButton addRoomBt;//방 생성
	JButton joinRoomBt;//방 입장
	JButton outRoomBt;//방 나가기
	JButton whisperBt;//귓속말
	JButton button;
	JTextArea textArea;
	JTextField textField;
	
	JLabel label;
	JList<String> userList;
	JList<String> roomList;
	
	
	
	Vector<String> userListVector = new Vector<>();
	Vector<String> rooms = new Vector<>();
	
	
	
	
	
	public ClientView2(ClientView mContext, ClientService clientService) {
		this.mContext = mContext;
		System.out.println(mContext.getIdField().getText());
		
		
		init();
		addEventListener();
		
		
		// 다른 객체 입니다. !!! 
		this.clientService = clientService;
		
		// heap --> clientService 두개 새성 
	
		
	}
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		panel.setBackground(Color.cyan);
		setContentPane(panel);
		panel.setLayout(null);
		
		JTabbedPane jtab = new JTabbedPane();
		jtab.setBounds(9,90, 366,335);
		panel.add(jtab);
		
		
		logoutButton = new JButton("로그아웃");
		logoutButton.setBounds(285, 430, 90, 20);
		panel.add(logoutButton);
		
		addRoomBt = new JButton("방생성");
		addRoomBt.setBounds(285, 10, 90, 30);
		panel.add(addRoomBt);
		
		joinRoomBt = new JButton("방입장");
		joinRoomBt.setBounds(285, 59, 90, 30);
		panel.add(joinRoomBt);
		
		whisperBt = new JButton("귓속말");
		whisperBt.setBounds(10, 10, 90, 30);
		panel.add(whisperBt);
		
		ScrollPane scroll = new ScrollPane();
		scroll.setBounds(120, 10, 140, 100);
		userList = new JList<String>();
		scroll.add(userList);
		panel.add(scroll);
		
		JPanel panel2 = new JPanel();       /////탭 패널
		jtab.addTab("대기실", panel2);
		panel2.setLayout(null);
		
		ScrollPane roomscroll = new ScrollPane();
		roomscroll.setBounds(0, 0, 365, 300);
		roomList = new JList<String>();
		roomscroll.add(roomList);
		panel2.add(roomscroll);
		
		JPanel panel3 = new JPanel();
		jtab.addTab("채팅방", panel3);
		panel3.setLayout(null);
		
		ScrollPane textScroll = new ScrollPane();
		textScroll.setBounds(0, 0, 365, 310);
		textArea = new JTextArea();
		textScroll.add(textArea);
		panel3.add(textScroll);
		
		textField = new JTextField();
		textField.setBounds(10,430, 140,20);
		panel.add(textField);
		
		button = new JButton("전송");
		button.setBounds(160,430,60,20);
		panel.add(button);
		
		
//		userListVector.add(mContext.getIdField().getText());
		//userList.setListData(userListVector);
		
		setVisible(false);
	}
	private void addEventListener() {
		logoutButton.addActionListener(this);
		button.addActionListener(this);
		addRoomBt.addActionListener(this);
		joinRoomBt.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logoutButton) {
		}else if(e.getSource() == button) {
			String msg = textField.getText().trim();
			System.out.println("전송 버튼 클릭했을때 : " +msg);
			clientService.chat(msg);		
		}else if(e.getSource() == addRoomBt) {
			String roomName = JOptionPane.showInputDialog("방 이름을 입력하세요");
			if(roomName != null) {
				clientService.sendmessage("CreateRoom@" + roomName);
			}
		}else if(e.getSource() == joinRoomBt) {
			String joinRoom = (String) roomList.getSelectedValue();
			clientService.sendmessage("JoinRoom@" + joinRoom);
		}
		
	}
	
	
	
	
}
