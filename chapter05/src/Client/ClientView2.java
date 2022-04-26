package Client;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientView2 extends JFrame implements ActionListener{

	JPanel panel;	
	JButton logoutButton;
	JButton addRoomBt;//방 생성
	JButton entranceRoomBt;//방 입장
	JButton outRoomBt;//방 나가기
	JButton whisperBt;//귓속말
	JButton button;
	JTextArea textArea;
	JTextField textField;
	
	JLabel label;
	JList userList;
	JList roomList;
	
	ClientData clientData;
	ClientView clientView;
	
	public JButton getLogoutButton() {
		return logoutButton;
	}
	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}
	public JButton getAddRoomBt() {
		return addRoomBt;
	}
	public void setAddRoomBt(JButton addRoomBt) {
		this.addRoomBt = addRoomBt;
	}
	public JButton getEntranceRoomBt() {
		return entranceRoomBt;
	}
	public void setEntranceRoomBt(JButton entranceRoomBt) {
		this.entranceRoomBt = entranceRoomBt;
	}
	public JButton getOutRoomBt() {
		return outRoomBt;
	}
	public void setOutRoomBt(JButton outRoomBt) {
		this.outRoomBt = outRoomBt;
	}
	public JButton getWhisperBt() {
		return whisperBt;
	}
	public void setWhisperBt(JButton whisperBt) {
		this.whisperBt = whisperBt;
	}
	public JList getUserList() {
		return userList;
	}
	public void setUserList(JList userList) {
		this.userList = userList;
	}
	public JList getRoomList() {
		return roomList;
	}
	public void setRoomList(JList roomList) {
		this.roomList = roomList;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JButton getButton() {
		return button;
	}
	public void setButton(JButton button) {
		this.button = button;
	}
	
	
	public ClientView2() {
		init();
		addEventListener();
		
	}
	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		panel.setBackground(Color.cyan);
		setContentPane(panel);
		panel.setLayout(null);
		
		logoutButton = new JButton("로그아웃");
		logoutButton.setBounds(285, 430, 90, 20);
		panel.add(logoutButton);
		
		addRoomBt = new JButton("방생성");
		addRoomBt.setBounds(10, 10, 90, 30);
		panel.add(addRoomBt);
		
		entranceRoomBt = new JButton("방입장");
		entranceRoomBt.setBounds(10, 80, 90, 30);
		panel.add(entranceRoomBt);
		
		whisperBt = new JButton("귓속말");
		whisperBt.setBounds(285, 10, 90, 30);
		panel.add(whisperBt);
		
		ScrollPane scroll = new ScrollPane();
		scroll.setBounds(120, 10, 140, 100);
		userList = new JList();
		scroll.add(userList);
		panel.add(scroll);
		
//		ScrollPane roomscroll = new ScrollPane();
//		roomscroll.setBounds(10, 120, 365, 300);
//		roomList = new JList();
//		roomscroll.add(roomList);
//		panel.add(roomscroll);
		textArea = new JTextArea();
		textArea.setBounds(10, 120, 365, 300);
		panel.add(textArea);
		
		textField = new JTextField();
		textField.setBounds(10,430, 140,20);
		panel.add(textField);
		
		button = new JButton("전송");
		button.setBounds(160,430,60,20);
		panel.add(button);
		
		
		setVisible(false);
	}
	private void addEventListener() {
		logoutButton.addActionListener(this);
		button.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logoutButton) {
			System.out.println("로그아웃 클릭");
			setVisible(false);
			clientView.setVisible(true);
			try {
				clientView.socket.close();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == button) {
			System.out.println("전송 클릭");
//			clientData.sendmessage("Chatting/" + textArea.getText().trim()  + "/");
			textArea.append(getTextField().getText() + "\n");
			
		}
		
	}
	
	
	
	
}
