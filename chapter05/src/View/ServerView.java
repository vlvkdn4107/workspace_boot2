package server;

import java.awt.Color;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class ServerView extends JFrame implements ActionListener{
	private JPanel panel;
	private JTextArea textArea;
	private JLabel portlabel;
	private JTextField textField;
	private JTextField textField2;
	private JButton button;
	private JButton portstartbutton;
	private JButton portstopbutton;
	
	BufferedWriter bufferedWriter;
	BufferedReader bufferedReader;
	BufferedReader keyboardBr;
	
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JLabel getPortlabel() {
		return portlabel;
	}
	public void setPortlabel(JLabel portlabel) {
		this.portlabel = portlabel;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	public JButton getPortstartbutton() {
		return portstartbutton;
	}
	public void setPortstartbutton(JButton portstartbutton) {
		this.portstartbutton = portstartbutton;
	}
	public JButton getPortstopbutton() {
		return portstopbutton;
	}
	public void setPortstopbutton(JButton portstopbutton) {
		this.portstopbutton = portstopbutton;
	}
	public JButton getLogbutton() {
		return logbutton;
	}
	public void setLogbutton(JButton logbutton) {
		this.logbutton = logbutton;
	}
	public ServerSocket getServerSocket() {
		return serverSocket;
	}
	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	private JButton logbutton;
	private BufferedImage img;
	
	


	private ServerSocket serverSocket;
	private Socket socket;
	private int port;
	
	private String file = "text12.txt";
	
	
	ServerData serverData = new ServerData();
	
	public JTextField getTextField2() {
		return textField2;
	}
	public void setTextField2(JTextField textField2) {
		this.textField2 = textField2;
	}
	public JButton getButton() {
		return button;
	}
	public void setButton(JButton button) {
		this.button = button;
	}
	
	public ServerView() {
		init();	
		addEventListener();
		textField.requestFocus();
	}
	private void init() {
		setSize(500,600);
		setTitle("????????????");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		//??????
		try {
			img = ImageIO.read(new File("images/lion.png"));
		} catch (IOException e) {
			System.out.println("?????? x");
			e.printStackTrace();
		}
		panel = new JPanel();
		panel.setBackground(Color.BLUE);
		
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);		
		panel.setLayout(null);
		
		//????????? ?????????
		ScrollPane scroll = new ScrollPane();
		scroll.setBounds(12, 10, 360, 300);
		scroll.setBackground(Color.white);
		textArea = new JTextArea();
		scroll.add(textArea);
		panel.add(scroll);
		textArea.setEditable(false);
		
		//?????? ??????
		portlabel = new JLabel("?????? ??????");
		portlabel.setBounds(12, 320, 100, 30);
		panel.add(portlabel);
		
		//?????? ????????? ??????
		textField = new JTextField();
		textField.setBounds(80, 320, 293, 30);
		panel.add(textField);
		
		
		logbutton = new JButton("?????? ??????");
		logbutton.setBounds(25, 380, 100, 30);
		panel.add(logbutton);
		
		portstartbutton = new JButton("?????? ??????");
		portstartbutton.setBounds(172, 355, 200, 30);
		panel.add(portstartbutton);
		
		portstopbutton = new JButton("?????? ??????");
		portstopbutton.setBounds(172, 400, 200, 30);
		panel.add(portstopbutton);
		portstopbutton.setEnabled(false);
		
		textField2 = new JTextField();
		textField2.setBounds(10, 440, 200,20);
		panel.add(textField2);
		
		button = new JButton("??????");
		button.setBounds(220, 440, 100, 20);
		panel.add(button);
		
		
		setVisible(true);
	}
	
	
	
	
	public void addEventListener() {
		portstartbutton.addActionListener(this);
		portstopbutton.addActionListener(this);
		button.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == portstartbutton) {
			if(textField.getText().length() == 0) {
			}else if(textField.getText().length() != 0) {				
				port = Integer.parseInt(textField.getText());
				startNetwork();
				textField.setEditable(false);
				portstartbutton.setEnabled(false);
				portstopbutton.setEnabled(true);
			}
		}else if(e.getSource() == portstopbutton) {
			try {
				serverSocket.close();
				serverData.getVc().removeAllElements();
				serverData.getRoomvc().removeAllElements();
				textField.setEditable(true);
				portstartbutton.setEnabled(true);
				portstopbutton.setEnabled(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == button) {
			WriteThread writeThread = new WriteThread();
			Thread thread = new Thread(writeThread);
			thread.start();
			while(true) {
				try {
					String msg = keyboardBr.readLine();
					
					bufferedWriter.write(msg + "\n" + getTextArea().getText());
					bufferedWriter.flush();
					BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
					bw.write("????????? ?????? :" + msg + "\n");
					bw.flush();
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		}
		
	}
	private class WriteThread implements Runnable{

		@Override
		public void run() {
			while(true) {
				try {
					String msg = keyboardBr.readLine();
					bufferedWriter.write(msg + "\n");
					bufferedWriter.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	public void startNetwork() {
		try {
			serverSocket = new ServerSocket(port);
			
			textArea.append("????????? ?????????????????????\n");
			connect();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "?????? ???????????? ???????????????.", "??????",
					JOptionPane.ERROR_MESSAGE);//?????? ???????????? ????????????
			portstartbutton.setEnabled(true);;
			portstopbutton.setEnabled(false);;
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "?????? ???????????? ???????????????.", "??????",
					JOptionPane.ERROR_MESSAGE);//?????? ???????????? ????????????
		}
		
	}
	
	public void connect() {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {					
					try {
						textArea.append("????????? ????????? ???????????????.\n");
						socket = serverSocket.accept();
						
					} catch (IOException e) {
						textArea.append("????????? ?????????????????????.?????? ????????? ?????????.\n");
						break;
					}
				}
				
			}
		});
		th.start();
	}


	
		
		
		
	

	public static void main(String[] args) {
		new ServerView();
	}
}
