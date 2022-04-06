package ch04;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LottoFrame2 extends JFrame {

	private JButton startBtn;
	private int[] lotto = new int[LottoNumber.LOTTO_NUM_SIZE];
	private LottoNumber lottoNumber; // 로또 넘버 클래스를 포합관계로 넣는다.
	private LottoPanel lottoPanel;

	public LottoFrame2() {
		initDate();
		setInitLayout();
		addEventListener();
	}

	private void initDate() {

		setTitle("로또 번호 생성기");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startBtn = new JButton("로또 번호 생성하기");
		lottoNumber = new LottoNumber();
		lottoPanel = new LottoPanel();
	}

	private void setInitLayout() {
		setVisible(true);
		setBackground(Color.gray);
		add(startBtn, BorderLayout.NORTH);
	}

	private void addEventListener() {
	           	startBtn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						lotto = lottoNumber.getLottoNumber();
						repaint();
					}
//						
					
					
	           	});
	           	
	}

	// 내부 클래스
	// 정적 내부 클래스 <--
	private class LottoPanel extends JPanel {
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setFont(new Font("궁서체", Font.BOLD, 20));
			if (lotto[0] == 0) {
				g.drawString("로또 버튼을 클릭하세요", 200, 200);

				return;
			}
			int xPosition = 150;
			for (int i = 0; i < lotto.length; i++) {
				g.drawString(lotto[i] + "", xPosition, 150);
				xPosition += 50;
			}
		}

	}// end of innerClass
	

}
