package soket_Ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
	
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;//들어오는 입장이라서 Reader쓴다.
	
	
	/////////////////////////////////
	
	BufferedWriter bufferedWriter;//클라이언트 쪽으로 데이터를 보내는 녀석
	BufferedReader keyboardBufferReader;
	
	public ServerFile() {
		
		System.out.println("1. >>>>>서버 소켓 시작<<<<<");
		try {
			serverSocket = new ServerSocket(10000);//10000번째의 포트
			
			System.out.println("2 서버 소켓 생성 완료");
			socket = serverSocket.accept();//accept메소드란? 클라이언트 연결 대기 하고 있는 상태(while문을 쓰면서 계속 대기중이다)
			System.out.println("3. 클라이언트  연결 완료");
			
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//코드의 흐름상 와일문 앞에 설정해줘야한다
			//초기화 처리
			keyboardBufferReader = new BufferedReader(new InputStreamReader(System.in));
			
			//클라이언트 쪽으로 보낼 스트림 연결(outputStream)
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//쓰레드 처리
			WriteThread writeThread = new WriteThread();//객체먼저 생성
			Thread thread = new Thread(writeThread);
			thread.start();
			
			while(true) {
				String msg = bufferedReader.readLine();
				System.out.println("4. 클라이언트로 받은 메세지 :" + msg);
				
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("예외 발생");
		} finally{
			
			try {
				bufferedReader.close();
				bufferedWriter.close();
				socket.close();
				serverSocket.close();
				keyboardBufferReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//내부클래스로 쓰레드 생성
	private class WriteThread implements Runnable{
		@Override
		public void run() {
			
			while(true) {
				try {
					//키보드에서 데이터를 읽어 줌
					String msg = keyboardBufferReader.readLine();
					//클라이언트로 데이터 보내기 -->소켓에 연결 해야된다
					bufferedWriter.write(msg + "\n");
					bufferedWriter.flush();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//end of while
			
			
		}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
			
		new ServerFile(); 
		
		
	}
}
