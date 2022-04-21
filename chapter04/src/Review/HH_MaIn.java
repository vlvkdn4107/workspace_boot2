package Review;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class HH_MaIn extends JFrame implements HH_CallBackCheckButton{

	private HH_WritePanel writePanel;
	private HH_CheckDate checkDate;
	
	private FileWriter fw;
	private BufferedWriter bw;
	
	private String text;
	
	public HH_MaIn() {
		initObject();
		initSetting();
	}
	private void initObject() {
		checkDate = new HH_CheckDate();
		writePanel = new HH_WritePanel(this);
	}
	private void initSetting() {
		setTitle("다이어리 쓰기");
		setSize(650,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(writePanel);
		
		setVisible(true);
		
	}
	
	
	@Override
	public void clickedButton() {
		try {
			fw = new FileWriter("my_diary.txt",true);
			bw = new BufferedWriter(fw);
			
			text = writePanel.getTextArea().getText();
			bw.write("today date : " + checkDate.checkDate());
			bw.write("\n-----------today diary-----------\n");
			bw.write(text);
			bw.write("\n-----------------------------------");
			bw.write("\n\n\n");
			
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new HH_MaIn();
	}

}
