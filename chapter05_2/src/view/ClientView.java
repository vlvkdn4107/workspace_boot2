package view;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client.ClientInterface;
import client.ClientService;
import server.ServerData;

public class ClientView extends JFrame implements ActionListener {

	private ClientView mContext = this;
	private ClientView2 clientView2; 
	private ClientService clientService;


	JPanel mainPanel;
	JLabel ipLabel;
	JLabel portLabel;
	JLabel idLabel;
	JTextField ipField;
	JTextField portField;
	JTextField idField;
	JButton loginBt;// 로그인

	private String ip;
	private int port;
	private String userName;

	Vector<String> users;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public JTextField getIpField() {
		return ipField;
	}

	public void setIpField(JTextField ipField) {
		this.ipField = ipField;
	}

	public JTextField getPortField() {
		return portField;
	}

	public void setPortField(JTextField portField) {
		this.portField = portField;
	}

	public JTextField getIdField() {
		return idField;
	}

	public void setIdField(JTextField idField) {
		this.idField = idField;
	}

	public JButton getLoginBt() {
		return loginBt;
	}

	public void setLoginBt(JButton loginBt) {
		this.loginBt = loginBt;
	}

	public ClientView() {
		init();
		addEventListener();
	}

	private void init() {
		setTitle("클라이언트");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setBackground(Color.cyan);
		setContentPane(mainPanel);
		mainPanel.setLayout(null);

		ipLabel = new JLabel("IP");
		ipLabel.setBounds(30, 210, 70, 30);
		mainPanel.add(ipLabel);
		ipField = new JTextField();
		ipField.setBounds(30, 240, 325, 30);
		mainPanel.add(ipField);
		ipField.setText("127.0.0.1");

		portLabel = new JLabel("PORT");
		portLabel.setBounds(30, 270, 70, 30);
		mainPanel.add(portLabel);
		portField = new JTextField();
		portField.setBounds(30, 300, 325, 30);
		mainPanel.add(portField);

		idLabel = new JLabel("ID");
		idLabel.setBounds(30, 330, 70, 30);
		mainPanel.add(idLabel);
		idField = new JTextField();
		idField.setBounds(30, 360, 325, 30);
		mainPanel.add(idField);

		loginBt = new JButton("로그인");
		loginBt.setBounds(254, 400, 100, 30);
		mainPanel.add(loginBt);

		setVisible(true);
		
		
	}

	private void addEventListener() {
		loginBt.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(loginBt)) {
			if (ipField.getText().length() == 0) {
				ipField.setText("IP를 입력하세요.");
				ipField.requestFocus();
			} else if (portField.getText().length() == 0) {
				portField.setText("port번호를 입력하세요.");
				portField.requestFocus();
			} else if (idField.getText().length() == 0) {
				idField.setText("ID를 입력하세요.");
				idField.requestFocus();
			} else {
				// connect 동작 !!!
				try {
					ip = ipField.getText().trim();
					port = Integer.parseInt(portField.getText().trim());
					userName = idField.getText().trim();
		
					clientService = new ClientService(this);
					clientService.setUserName(userName);
					
					ClientView2 clientView2 = new ClientView2(mContext, clientService);
				
					clientService.setClientView2(clientView2);
					
					setVisible(false);
					clientView2.setVisible(true);

					clientService.connectServer();
					System.out.println(userName);
					System.out.println("마지막 확인 :::  " + clientService.getUserName());
				} catch (Exception e1) {
					portField.setText("포트번호를 잘못입력 했습니다.");
				}
			}
		}

	}

	public void userUpdate(String user) {
		for (String userName : users) {
			if (userName.equals(user)) {
				return;
			}

		}
		users.add(user);
		System.out.println("@@" + userName);
		clientView2.userList.setListData(users);

	}

	public static void main(String[] args) {

		new ClientView();

	}

}
