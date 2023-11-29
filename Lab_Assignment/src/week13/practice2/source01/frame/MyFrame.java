package week13.practice2.source01.frame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*img 폴더는 프로젝트 클릭 후 Ctrl + V 해야한다.*/

public class MyFrame extends JFrame {

	Container frame = getContentPane();
	JPanel panel1, panel2;
	List<String> strlist = List.of("Red", "Green", "Blue", "Orange", "Gray");
	List<Color> colorlist = List.of(Color.RED, Color.GREEN, Color.BLUE, Color.ORANGE, Color.GRAY);
	
	public MyFrame() {
		this.setTitle("202112439 최예름");
		
		// 프레임의 아이콘 바꾸기
		Toolkit tool = Toolkit.getDefaultToolkit(); 
		Image img = tool.getImage("img/char.png");
		this.setIconImage(img);
		
		this.setSize(500, 500);
//		this.setSize(tool.getScreenSize().width/2, tool.getScreenSize().height/2);  // 전체 화면 너비 기준으로 프레임 사이즈 지정 가능
//		this.setLocation(400, 400);  // 창을 처음에 띄울 위치 지정
		this.setLocationRelativeTo(null);  // 창을 처음에 중앙에 띄움
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  // 프레임과 함께 프로그램 종료시키기
//		init();
//		init2();
//		init3();
		init4();
		this.setVisible(true);
	}


	void init() {
		frame.add(new JButton("greenjoa"));
	}
	
	
	private void init2() {
		frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		for(int i = 0; i < 15; i++) {
			frame.add(new JButton(String.valueOf(i)));
		}
	}
	
	
	private void init3() {
		// TODO Auto-generated method stub
		BorderLayout lm = (BorderLayout)frame.getLayout();
		lm.setHgap(20);
		lm.setVgap(20);
		frame.add(new JButton("greenjoa1"), BorderLayout.WEST);
		frame.add(new JButton("greenjoa1"), BorderLayout.CENTER);
		frame.add(new JButton("greenjoa1"), BorderLayout.NORTH);
	}
	
	
	private void init4() {
		initPanel1();
		initPanel2();
	}


	private void initPanel1() {
		// TODO Auto-generated method stub
		this.panel1 = new JPanel();
		for(int i=0; i<strlist.size(); i++) {
			final int idx = i;
			JButton btn = new JButton(strlist.get(i));
//			btn.addActionListener(new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					panel2.setBackground(colorlist.get(idx));
//				}
//				
//				
//			});
			
			// 위의 주석 처리한 부분처럼 추상 메서드 오직 하나이면 람다 표현식 대체
			btn.addActionListener(e->panel2.setBackground(colorlist.get(idx)));
			this.panel1.add(btn);
		}
		frame.add(this.panel1, BorderLayout.NORTH);
	}


	private void initPanel2() {
		// TODO Auto-generated method stub
		this.panel2 = new JPanel();
		this.panel2.setBackground(colorlist.get(1));
		frame.add(this.panel2, BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame();
	}


}
