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
			// this.userName = clientView.getIdField().getText().trim();

			Thread cht = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							String msg = dis.readUTF();
							inmessage(msg);
						} catch (IOException e) {
							JOptionPane.showMessageDialog(null, "서버가 종료됨!", "알림", JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			});
			cht.start();

			newUser(userName);

			// sendmessage(userName);

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "연결실패!", "알림", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void newUser(String msg) {// 작동 @@
		msg = "newUser@" + userName;
		System.out.println("-------------------");
		System.out.println(msg);
		System.out.println("-------------------");
		sendmessage(msg);
	}

	public void chat(String msg) {
		// 멤버 변수 userName

		System.out.println("@@@@chat@@@@" + userName);
		msg = "Catting@" + msg;
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
	public String[] getLog(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "@");
		String logHd = st.nextToken();
		String logBd = st.nextToken();

		String[] protocol = new String[2];

		protocol[0] = logHd;
		protocol[1] = logBd;

		return protocol;

	}

	@Override
	public void runServer() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {

						String msg = dis.readUTF();
						System.out.println(userName + "@@@" + msg);
						String[] protocal = getLog(msg);

						switch (protocal[0]) {
						case "uewUser":
							// mContext.userUpdate(protocal[1]);

							break;
						case "OldUser":
							// mContext.userUpdate(protocal[1]);
							break;
							
						case "Catting":
							System.out.println("-------------");
							System.out.println(protocal[0]);
							System.out.println(protocal[1]);
							System.out.println("-------------");
							clientView2.getTextArea().append(protocal[1]);
							break;
						default:
							break;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}).start();

	}

	@Override
	public void inmessage(String msg) {
		StringTokenizer st = new StringTokenizer(msg, "@");
		String protocol = st.nextToken();
		String message = st.nextToken();

		if (protocol.equals("Catting")) {
			System.out.println("여기에 들어 와야해 !!!!");
			 
			mContext.getClientView2().getTextArea().append(message);
			//clientView2.getTextArea().append(message + "@" + msg + "@");
			
		} else if (protocol.equals("newUser")) {
			runServer();

		}
	}
}
