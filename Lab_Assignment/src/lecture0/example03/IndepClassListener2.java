package lecture0.example03;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IndepClassListener2 extends JFrame {
	JButton btn = new JButton("Action");  // outer class에 멤버에 버튼을 선언하도록 바꿈.
	IndepClassListener2() {
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		btn.addActionListener(new MyActionListener());
		c.add(btn);
		setSize(250, 120);
		setVisible(true);
	}

	// 내부 클래스로 Action 리스너를 작성한다. (inner class를 쓰면 outer class 멤버에 접근이 쉽다.)
	private class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
//			JButton b = (JButton) e.getSource();
			if (btn.getText().equals("Action"))
				btn.setText("액션");
			else
				btn.setText("Action");

			// InnerClassListener나 JFrame의 멤버 호출 가능
			setTitle(btn.getText()); // 프레임 타이틀에 버튼문자열 출력
		}
	}

	public static void main(String[] args) {
		new IndepClassListener2();
	}
}
