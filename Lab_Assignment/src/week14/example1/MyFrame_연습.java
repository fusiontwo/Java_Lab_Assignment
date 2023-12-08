package week14.example1;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame_연습 extends JFrame {

	Container frame = getContentPane();
	JPanel panel1, panel2;
	CardLayout cl = new CardLayout();
	List<Color> colorlist = List.of(Color.RED, Color.GREEN, Color.BLUE,
			Color.ORANGE, Color.GRAY);
	
	JLabel charIcon = new JLabel();
	ImageIcon img = new ImageIcon("img/char.png");
	int xpos = 100;
	
	public MyFrame_연습() {
		this.setTitle("202112439 최예름");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);  // 창을 처음에 중앙에 띄울 때 사용
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);   // 프레임과 함께 프로그램 종료시키기
//		init();
		init2();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		initPanel1();
		initPanel2();
	}

	private void initPanel1() {
		// TODO Auto-generated method stub
		this.panel1 = new JPanel(new GridLayout(1, 3, 10, 10));
		JButton btn1 = new JButton("<<");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.previous(panel2);
			}
		});
		
		JButton btn2 = new JButton("Home");
		btn2.addActionListener(e->cl.show(panel2, "1"));
		
		JButton btn3 = new JButton(">>");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.next(panel2);
			}
		});
		
		this.panel1.add(btn1);
		this.panel1.add(btn2);
		this.panel1.add(btn3);
		
		frame.add(this.panel1, BorderLayout.NORTH);
	}

	private void initPanel2() {
		// TODO Auto-generated method stub
		this.panel2 = new JPanel(cl);
		for(int i=0; i<colorlist.size(); i++) {
			JPanel card = new JPanel();
			card.setBackground(colorlist.get(i));
			this.panel2.add(card, String.valueOf(i));  // i를 문자열로 변환해서 카드 식별자 생성
		}
		
		cl.show(panel2, "1");
		frame.add(panel2, BorderLayout.CENTER);
	}
	
	
	private void init2() {
		// TODO Auto-generated method stub
		initPanel3();
		initPanel4();
	}

	private void initPanel3() {
		// TODO Auto-generated method stub
		this.panel1 = new JPanel(new GridLayout(1, 3, 10, 10));
		JButton btn1 = new JButton("<<");
		btn1.addActionListener(e->{  // btn1에 대한 리스너 1
			if (xpos >= 10) {
				xpos -= 10;
				charIcon.setLocation(xpos, 100);
			}
		});
		
		// 하나의 버튼에 대해 여러 개의 리스너가 달릴 수 있음(등록된 반대 순으로 실행된다.)
		btn1.addActionListener(e->{  // btn1에 대한 리스너2
			charIcon.setSize(img.getIconWidth()-10, img.getIconHeight()-10);
		});
		
		JButton btn2 = new JButton("Home");
		btn2.addActionListener(e->{
			xpos = 100;
			charIcon.setLocation(xpos, 100);
		});
		
		JButton btn3 = new JButton(">>");
		btn3.addActionListener(e->{
			if(xpos <= panel2.getWidth() - img.getIconWidth()) {
				xpos += 10;
				charIcon.setLocation(xpos, 100);
			}
		});
		
		this.panel1.add(btn1);
		this.panel1.add(btn2);
		this.panel1.add(btn3);
		frame.add(this.panel1, BorderLayout.NORTH);
	}

	private void initPanel4() {
		// TODO Auto-generated method stub
		// 배치 관리자가 없는 경우 사이즈, 위치 지정
		this.panel2 = new JPanel(null);
		this.charIcon.setIcon(img);
//		this.charIcon.setSize(img.getIconWidth(), img.getIconHeight());
//		this.charIcon.setLocation(xpos, 100);
		this.charIcon.setBounds(xpos, 100, img.getIconWidth(), img.getIconHeight());
		this.panel2.add(charIcon);
		frame.add(panel2, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame_연습 f = new MyFrame_연습();
	}

}
