package ch04;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class EventListener4 extends JFrame implements MouseListener{

	private JLabel label1;
	
	public EventListener4() {
		initDate();
		setInitLayout();
		addEventListener();
	}
	private void initDate() {
		setTitle("마우스 이벤트 확인");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label1 = new JLabel("hello java~~~~~~~~~~~~");
	}
	private void setInitLayout() {
		setVisible(true);
		setLayout(null);
		add(label1);
		label1.setSize(100, 100);
		label1.setLocation(-500,-600);
		
	}
	
	private void addEventListener() {
		this.addMouseListener(this);
	}
	

	
	//마우스가 클릭되었을때 호출
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("x 좌표값 : " + e.getX());
		System.out.println("y 좌표값 : " + e.getY());
		
		
		
		System.out.println(label1.getBounds());
		System.out.println("label width :" + label1.getBounds().width);
		System.out.println("label height :" + label1.getBounds().height);
		//문제 현재 간격을 최소화로 만들어서 정확성을 높여 보자
		System.out.println("getHeight: "+ getHeight());
		label1.setLocation(e.getX(), e.getY());
	}
	//마우스가 눌러졌을때
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//마우스가 눌렀다가 떨어졌을때
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//마우스가 어떤 영역안으로 들어왔을때 호츨
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	// 마우스가 어떤 영역밖으로 나갔을때 호출!
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	//메인
	public static void main(String[] args) {
		new EventListener4();
	}//end of main
}
