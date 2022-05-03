package client;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
import view.ClientView;
import view.ClientView2;

@Getter
@Setter
public class ClientService implements ClientInterface {

	private ClientView mContext;
	private ClientView2 clientView2;

	private Socket socket;

	private InputStream is;
	private DataInputStream dis;
	private OutputStream os;
	private DataOutputStream dos;

	private String userName;

	private String ip;
	private int port;

	public ClientService(ClientView mContext) {// 생성자
		this.mContext = mContext;
		this.clientView2 = mContext.getClientView2();
	}

	@Override
	public void connectServer() {

		try {
			socket = new Socket(mContext.getIp(), mContext.getPort());
			network();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void network() {
		
		try {
			System.out.println("networkOK");
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);

			userName = mContext.getIdField().getText().trim();
			sendmessage("newUser@" + userName);
			// this.userName = clientView.getIdField().getText().trim();

			new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							String msg = dis.readUTF();
							System.out.println(msg + " <<<<<<<  Server");
							getLog(msg);
							
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "서버가 종료됨!", "알림", JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			}).start();
			// sendmessage(userName);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		}

	}



	public void chat(String msg) {
		// 멤버 변수 userName

		System.out.println("@@@@chat@@@@" + userName);
		msg = "Catting@" + userName + " : " + msg + "\n";
		System.out.println("chat userName" + userName);
		System.out.println("chat :" + msg);

		sendmessage(msg);
	}

	@Override
	public void sendmessage(String msg) {
		System.out.println("snedMS" + msg);
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void getLog(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "@");
		String logHd = st.nextToken();
		String logBd = st.nextToken();

		String[] protocol = new String[2];

		protocol[0] = logHd;
		protocol[1] = logBd;

		runServer(protocol);

	}

	@Override
	public void runServer(String[] protocal) {
		
		switch (protocal[0]) {
		case "newUser":
			System.out.println(mContext.getClientView2().getUserListVector().size());
			System.out.println("프로토콜 @@@@@@@@@@@@@@@@@@@@@@@@@uewUser");
			mContext.getClientView2().getTextArea().append(protocal[0] + protocal[1]);
			mContext.getClientView2().getUserListVector().add(protocal[1]);
			
			for (String string : mContext.getClientView2().getUserListVector()) {
				System.out.println(string);
			}
			
			mContext.getClientView2().getUserList().setListData(mContext.getClientView2().getUserListVector());
			break;
		case "OldUser":
			mContext.getClientView2().getTextArea().append(protocal[0] + protocal[1]);
			mContext.getClientView2().getUserListVector().add(protocal[1]);
			mContext.getClientView2().getUserList().setListData(mContext.getClientView2().getUserListVector());
			break;

		case "Catting":
			clientView2.getTextArea().append(protocal[1]);
			break;
		default:
			break;
		}
	}

	
}
