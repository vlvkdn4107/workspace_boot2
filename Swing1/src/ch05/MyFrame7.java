package ch05;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MyFrame7 extends JFrame implements KeyListener{

	private JTextArea textArea;
	//키보드 이벤트
	
	public MyFrame7() {
		initData();
		setInitLayout();
		addEventListener();
	}
	private void initData() {
	  setTitle("키이벤트 연습");
	  setSize(500, 500);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  textArea = new JTextArea();
	}
	
	private void setInitLayout() {
		setVisible(true);
		add(textArea);
	}
	private void addEventListener() {
		textArea.addKeyListener(this);
	}
	
	
	//키보드를 눌렀을때 반응	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
    //키보드를 눌렀다가 땠을 때 반응
	@Override
	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();// 어떤 문자인지 받아내는 녀석!
		int keyCode = e.getKeyCode();
		
//		textArea.setText(c+"");
		
		
//		System.out.println("c :" + c);
//		System.out.println("keyCode :" + keyCode);
////		// 도전 과제
////		//textArea에 키코드 그리고 char c 값을 보이게 코딩해 주세요
//		textArea.append("\n" + "c :" + c + " :" + "   keyCode :" + keyCode);
		//콘솔창에 왼쪽 화살표, 오른쪽, 아래 , 위 
		// 위  오른쪽 아래 왼쪽
//		   38   39  40  37
//		if(keyCode == 38) {
//			System.out.println("코드키는: "+ keyCode +" \n 방향키 : ↑");
//		}else if(keyCode == 39) {
//			System.out.println("코드키는: "+ keyCode +" \n 방향키 : →");
//		}else if(keyCode == 40) {
//			System.out.println("코드키는: "+ keyCode +" \n 방향키 : ↓");
//		}else if(keyCode == 37){
//			System.out.println("코드키는: "+ keyCode +" \n 방향키 : ←");
//		}
		if(keyCode == KeyEvent.VK_LEFT) {
			System.out.println("왼쪽");
		}else if(keyCode == KeyEvent.VK_RIGHT) {
			System.out.println("오른쪽");
		}else if(keyCode == KeyEvent.VK_DOWN) {
			System.out.println("아래");
		}else if(keyCode == KeyEvent.VK_UP) {
			System.out.println("위");
		}
		
		
	}
    //
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	public static void main(String[] args) {
		new MyFrame7();
	}
	
}
