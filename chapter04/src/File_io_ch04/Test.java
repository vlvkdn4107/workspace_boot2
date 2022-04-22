package File_io_ch04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Test extends JFrame{

	JPanel panel;
	static JTextArea textArea;
	JTextField field;
	JButton button;
//	ICallback callback = new ICallback() {
		
//		@Override
//		public void addText() {
//			textArea.setText("");
//			
//			
//			
//		}
//	};
//		
	
	public Test() {
		initData();
		setInitLayout();
		addEventListner();
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	
//	public ICallback setTextArea(JTextArea textArea) {
//		this.textArea = textArea;
//		return this.callback;
//	}
	
	
	public void initData(){
		setTitle("글자 보내기");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		button = new JButton("보내기");
		textArea = new JTextArea("",10,10);
		
	
		
	}
	public void setInitLayout() {
		setVisible(true);
		add(panel);				
		panel.add(button);	
		
		panel.add(textArea);
		panel.setBackground(Color.cyan);
		

	
	}
	
	public void addEventListner() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {			    
				 try {
					 String file = "test.txt";		
						String text = textArea.getText();
						BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
						
						bw.write(text);
						bw.flush();
						bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				
			}
		});
		
	}

	
	
	
	public static void main(String[] args) {
		
		Test test = new Test();
		
	}
	
}

