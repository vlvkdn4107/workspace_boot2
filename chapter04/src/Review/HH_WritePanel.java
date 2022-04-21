package Review;

import java.awt.Color;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class HH_WritePanel extends JPanel{
	private TextArea textArea;
	private JButton button;
	
	private HH_CallBackCheckButton callBackCheckButton;
	
	public TextArea getTextArea() {
		return textArea;
	}
	public JButton getButton() {
		return button;
	}
	public HH_WritePanel(HH_CallBackCheckButton callBackCheckButton) {
		this.callBackCheckButton = callBackCheckButton;
		initObject();
		initSetting();
		initListener();
		
	}
	private void initObject() {
		textArea = new TextArea("글 쓰기", 30, 80, Scrollbar.VERTICAL);
		button = new JButton("글 저장");
	}
	private void initSetting() {
		setSize(800,600);
		
		textArea.setSize(600,600);
		button.setBackground(Color.WHITE);
		
		add(textArea);
		add(button);
	}
	private void initListener() {
		button.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				callBackCheckButton.clickedButton();
			}
		});
	}
	
}
