package soket_Ex4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class ServerFile extends JFrame{
	
	ServerSocket serverSocket;
	Socket socket;
	BufferedReader bufferedReader;//들어오는 입장이라서 Reader쓴다.
	
	
	/////////////////////////////////
	
	BufferedWriter bufferedWriter;//클라이언트 쪽으로 데이터를 보내는 녀석
	BufferedReader keyboardBufferReader;
	
	
	private String file = "Socket.txt"; // 내용 저장할 파일
	
	JPanel jPanel;
	JButton jButton;
	JTextArea textArea;
	
	
	public ServerFile() {
		initObject();
		initsetting();
		addEventListener();
		
		System.out.println("1. >>>>>서버 소켓 시작<<<<<");
		try {
			serverSocket = new ServerSocket(10000);//10000번째의 포트
			
			System.out.println("2 서버 소켓 생성 완료");
			socket = serverSocket.accept();//accept메소드란? 클라이언트 연결 대기 하고 있는 상태(while문을 쓰면서 계속 대기중이다)
			System.out.println("3. 클라이언트  연결 완료");
			
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			
			//초기화 처리
			keyboardBufferReader = new BufferedReader(new InputStreamReader(System.in));
			
			//클라이언트 쪽으로 보낼 스트림 연결(outputStream)
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//코드의 흐름상 와일문 앞에 설정해줘야한다
			WriteThread writeThread = new WriteThread();//객체먼저 생성
			Thread thread = new Thread(writeThread);
			thread.start();
			
			while(true) {
				try {
					//키보드에서 데이터를 읽어 줌
					String msg = keyboardBufferReader.readLine();
					//클라이언트로 데이터 보내기 -->소켓에 연결 해야된다
					bufferedWriter.write(msg + "\n");
					bufferedWriter.flush();
					BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
					bw.write("서버가 보냄 : " + msg + "\n");
					bw.flush();
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}//end of while
			
		
		
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
	
	private void initObject(){
		setTitle("채팅방");
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jPanel = new JPanel();
		jButton = new JButton("메세지 보내기");
		textArea = new JTextArea("", 25, 40);
	}
	private void initsetting() {
		setVisible(true);
		jPanel.setSize(500,500);
		jPanel.setBackground(Color.gray);
		add(jPanel);
		textArea.setSize(300,300);
		jPanel.add(textArea);
		jPanel.add(jButton);
		
	}
	private void addEventListener() {
		jButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
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
