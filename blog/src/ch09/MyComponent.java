package ch09;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MyComponent extends JFrame {

	// 컴포넌트안의 포함관계
	private JPanel panel;
	private JButton button;
	private JLabel label;
	JTextField textField;
	private JPasswordField passwordField;
	private JCheckBox checkbox;

	public MyComponent() {
		initData();
		setInitLayout();
	}

	private void initData() {
		setTitle("컴포넌트 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);

		Dimension dimension = new Dimension(300, 300);
		panel = new JPanel();
		panel.setPreferredSize(dimension);

		button = new JButton("버튼");
		label = new JLabel("라벨");
		textField = new JTextField("hint", 20);
		passwordField = new JPasswordField(20);
		checkbox = new JCheckBox("checkbox", true);
	}

	private void setInitLayout() {
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEFT, 100, 200));

		add(panel);
		panel.setBackground(Color.cyan);
		panel.add(button);
		panel.add(label);
		panel.add(textField);
		panel.add(passwordField);
		panel.add(checkbox);

		
		
		
		
	}

	public static void main(String[] args) {
		new MyComponent();

	}

}
