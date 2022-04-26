package soket_Ex6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class UserSocket extends Thread{

	ServerFile mContext;
	
	Socket socket;//인풋스트림 아웃스트림을 가지고있다.
	//버퍼 리더 달기
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	
	public UserSocket(ServerFile mContext, Socket socket) {//데이터 타입으로 소켓을 넣으면 의존성 컴포지션 관계
		//생성자 객체가 메모리에 올라 갈때 필요한 데이터 초기화
		this.mContext = mContext;
		this.socket = socket;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));//여기에 들어오는 소켓이랑 buffered드랑 연결된다
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						String msg = bufferedReader.readLine();
						System.out.println("서버--> UserSocket : msg : " + msg);
						mContext.broadCast(msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
	}
	public void sendmessage(String msg) {
		try {
			bufferedWriter.write(msg + "\n");
			bufferedWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
