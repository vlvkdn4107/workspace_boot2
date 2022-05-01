package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import client.ClientService;
import lombok.Getter;
import lombok.Setter;
import view.ServerView.ImagePanel;

@Getter
@Setter
public class ClientView extends JFrame implements ActionListener {

	private ClientView mContext = this;
	
	private ClientView2 clientView2;
	private ClientService clientService;

	
	JLabel ipLabel;
	JLabel portLabel;
	JLabel idLabel;
	JTextField ipField;
	JTextField portField;
	JTextField idField;
	JButton loginBt;// 로그인
	private BufferedImage img = null;
	private String ip;
	private int port;
	

	//Vector<String> users;

	public ClientView() {
		try {
			img = ImageIO.read(new File("images/background.png"));
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "이미지 불러오기 실패");
		}
		init();
		addEventListener();
	}

	private void init() {
		setTitle("클라이언트");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImagePanel panel = new ImagePanel();
		setContentPane(panel);
		panel.setLayout(null);

		ipLabel = new JLabel("IP");
		ipLabel.setBounds(30, 210, 70, 30);
		panel.add(ipLabel);
		ipField = new JTextField();
		ipField.setBounds(30, 240, 325, 30);
		panel.add(ipField);
		ipField.setText("127.0.0.1");

		portLabel = new JLabel("PORT");
		portLabel.setBounds(30, 270, 70, 30);
		panel.add(portLabel);
		portField = new JTextField();
		portField.setBounds(30, 300, 325, 30);
		panel.add(portField);
		portField.setText("10000");

		idLabel = new JLabel("ID");
		idLabel.setBounds(30, 330, 70, 30);
		panel.add(idLabel);
		idField = new JTextField();
		idField.setBounds(30, 360, 325, 30);
		panel.add(idField);
		idField.setText("1");

		loginBt = new JButton("로그인");
		loginBt.setBounds(254, 400, 100, 30);
		panel.add(loginBt);

		setVisible(true);

	}
 
	class ImagePanel extends JPanel{
		public void paint(Graphics g) {
			g.drawImage(img, 3, 0, null);
		}
		
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
				System.out.println("1111111111111");
				// connect 동작 !!! 로그인 버튼
				try {
					ip = ipField.getText().trim();
					port = Integer.parseInt(portField.getText().trim());
					

					clientService = new ClientService(mContext);
					
					clientView2 = new ClientView2(mContext, clientService);
					

					// clientService.setClientView2(clientView2);

					setVisible(false);
					clientView2.setVisible(true);
					String msg = idField.getText().trim();
					//clientService.setUserName(msg);
					clientService.connectServer();
					// todo 삭제 요망
					
					
					System.out.println("마지막 확인 :::  " + clientService.getUserName());
					// 
				} catch (Exception e1) {
					e1.printStackTrace();
					portField.setText("포트번호를 잘못입력 했습니다.");
				}
			}
		}

	}


	public static void main(String[] args) {

		new ClientView();

	}

}
