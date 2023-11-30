package lecture0.example04;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyListenerEx extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel[] keyMessage;

	KeyListenerEx() {
		setTitle("KeyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());

		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel("  getKeyCode()  ");
		keyMessage[1] = new JLabel("  getKeyChar()  ");
		keyMessage[2] = new JLabel("  getKeyText()  ");

		for (int i = 0; i < keyMessage.length; i++) {
			contentPane.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);  // label 배경을 불투명한 배경으로 만들기
			keyMessage[i].setBackground(Color.CYAN);
		}
		setSize(300, 150);
		setVisible(true);
		contentPane.setFocusable(true);  // 패널 객체가 focus를 받을 수 있게 설정
		contentPane.requestFocus();  // focus 요청
	}

	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {  // 오버라이딩
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(KeyEvent.getKeyText(keyCode));
		}
	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}
}