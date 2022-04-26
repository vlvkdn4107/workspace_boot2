package soket_Ex6;

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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class ServerFile extends JFrame{
	
	ServerSocket serverSocket; // 다른 클라이언트 연결 대기하는 녀석(10000포트 번호 설정)
	
	Vector<UserSocket> sockets = new Vector<>(); // 객체가 하나 생성될때
	
	
	
	public ServerFile() {
		System.out.println("1. >>>>>서버 소켓 시작<<<<<");
		try {
			serverSocket = new ServerSocket(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//10000번째의 포트
		
		//새로운 소켓 생성(실제 통신할 녀석)
		while(true) {
			try {
				Socket socket = serverSocket.accept();//멈췄다가 유저가 들어오면 한번 돌았다가 또 멈춤
				UserSocket userSocket = new UserSocket(this,socket);//생성된 소켓 넣기
				userSocket.start();
				sockets.add(userSocket);
				new UserSocket(this, socket);//소켓하나를 유저 소켓이랑 연결한 상태
				System.out.println("계속 돔?");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
	//생서된 UserSocket에 접근해서 하나씩 메세지 보내기
	// 방송하자 (전체방송)broadCast
	public void broadCast(String msg){
		for (int i = 0; i < sockets.size(); i++) {
			sockets.get(i).sendmessage(msg);
		}
		
	}
	
	
	public static void main(String[] args) {
			
		new ServerFile(); 
		
		
	}
}
