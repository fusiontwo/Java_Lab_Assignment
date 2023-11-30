package lecture0.example04;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class KeyCodeEx extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel();

	KeyCodeEx() {
		setTitle("Key Code 예제 : F1키:초록색, % 키 노란색");  // F1은 유니코드 아님, %는 유니코드임.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());
		contentPane.add(la);
		setSize(300,150);
		setVisible(true);
		contentPane.requestFocus();
	}
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			la.setText(KeyEvent.getKeyText(e.getKeyCode()));
			if(e.getKeyChar() == '%') 
				contentPane.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F1) 
				contentPane.setBackground(Color.GREEN);
		}
	}

	public static void main(String[] args) {
		new KeyCodeEx();
	}
}
