package week14.example2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame2 extends JFrame {

	public MyFrame2() {
		this.setTitle("202112439 최예름");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);  // 창을 처음에 중앙에 띄움
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  // 프레임과 함께 프로그램 종료시키기
		init();
		this.setVisible(true);
	}
	
	private void init() {
		// TODO Auto-generated method stub
		this.addWindowListener(new MyWindowListener(this));  // this는 frame 정보임.
		this.addWindowListener(new MyWindowAdapter(this));  // this는 frame 정보임.
		this.addWindowListener(new MyWindowAdapter(this) {  

			@Override
			public void windowClosing(WindowEvent e) {  // 익명 클래스 (window가 종료되려 할 때 호출됨)
				// TODO Auto-generated method stub
//				super.windowClosing(e);
				JOptionPane.showMessageDialog(null, "안녕히 가세요");
				System.exit(0);
			}
			
		});
	}

	class MyWindowAdapter2 extends WindowAdapter {  // inner class

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			String name = JOptionPane.showInputDialog("닉네임을 입력하세요");
			MyFrame2.this.setTitle(name+"님 환영합니다.");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame2 f = new MyFrame2();
	}

}
