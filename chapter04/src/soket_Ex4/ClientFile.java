package soket_Ex4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

	Socket socket;
	BufferedWriter bufferedWriter; // 소켓에다가 연결할 outputStream 이다
	// 주소 필요
	final String IP = "localhost"; // << localhost자기 자신을 나타내는 주소(127.0.0.1)
	final int PORT = 10000; // 서버파일의 포트가 10000번임

	BufferedReader KeybordbufferedReader; // 키보드에 연결할 Stream
	////////////////////
	// 서버에서 보낸 메세지를 읽기 위해 buffer 장착
	// Reader 버퍼
	// 동작시키기 위해서는 새로운 Thread가 필요하다!
	BufferedReader bufferedReader;

	public ClientFile() {

		try {
			System.out.println("1. 클라이언트 소켓 시작");
			socket = new Socket(IP, PORT);

			System.out.println("2. 버퍼 연결");
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			System.out.println("3. 키보드 버퍼 연결");
			KeybordbufferedReader = new BufferedReader(new InputStreamReader(System.in));// 키보드에 연결할꺼기 때문에[ System.in

			// 초기화 처리
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//새로운 쓰레드 생성
			ReadThread readThread = new ReadThread();
			Thread thread = new Thread(readThread);
			thread.start();
			
			while (true) {
				System.out.println("4. 키보드 입력 대기");
				String msg = KeybordbufferedReader.readLine(); // 입력 대기중
				// 사용자한테 문자열을 받았으면 보내야 한다 -->
				// 중요!! msg(메세지 끝을 알려줘야한다 \n)
				bufferedWriter.write(msg + "\n");
				bufferedWriter.flush();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bufferedWriter.close();
				bufferedReader.close();
				KeybordbufferedReader.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	// 내부클래스 생성
	private class ReadThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				try {
					String msg = bufferedReader.readLine();
					System.out.println("서버로 부터 받은 메세지 :" + msg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//end of while
			

		}

	}

	public static void main(String[] args) {

		new ClientFile();

	}

}
