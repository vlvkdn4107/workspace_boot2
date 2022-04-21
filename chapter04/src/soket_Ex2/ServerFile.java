package soket_Ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
	
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;//들어오는 입장이라서 Reader쓴다.
	
	public ServerFile() {
		
		System.out.println("1. >>>>>서버 소켓 시작<<<<<");
		try {
			serverSocket = new ServerSocket(10000);//10000번째의 포트
			
			System.out.println("2 서버 소켓 생성 완료");
			socket = serverSocket.accept();//accept메소드란? 클라이언트 연결 대기 하고 있는 상태(while문을 쓰면서 계속 대기중이다)
			System.out.println("3. 클라이언트  연결 완료");
			
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String msg = bufferedReader.readLine();
				System.out.println("4. 클라이언트로 받은 메세지 :" + msg);
				
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("예외 발생");
		}
	}
	
	
	public static void main(String[] args) {
			
		new ServerFile(); 
		
		
	}
}
