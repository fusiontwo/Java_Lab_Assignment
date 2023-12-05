package week15.practice1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	Container frame = getContentPane();

	JPanel northpanel;
	JTextField tf;
	JTextArea ta;
	String filename;
	VocManager voc;
	String[] strarr = {"전체검색", "부분검색"};
	JComboBox<String> combo;
	boolean flag = true;  // 전체검색
	
	public MyFrame(String filename) {
		
		this.filename = filename;
		
		this.setTitle("202112439 최예름");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);  // 창을 처음에 중앙에 띄움
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  // 프레임과 함께 프로그램 종료시키기
		init();
		this.setVisible(true);
		
		voc = new VocManager("홍길동");
		ta.append(voc.makeVoc(filename)+"\n");
		
	}
	
	private void init() {
		// TODO Auto-generated method stub
		initNorthpanel();
		initCenter();
	}


	private void initNorthpanel() {
		// TODO Auto-generated method stub
		this.northpanel = new JPanel();
		this.northpanel.add(new JLabel("검색할 단어 "));
		this.tf = new JTextField(15);
		this.tf.setFont(new Font("궁서체", Font.BOLD, 20));
		this.tf.addActionListener(e -> {
			String eng = tf.getText();
			//System.out.println(eng);
			String kor="";
			if(flag)
				kor = voc.searchVoc(eng);
			else
				kor = voc.searchVoc2(eng);
			//System.out.println(kor);
			ta.append(kor+"\n");
			tf.setText("");
		});
		this.northpanel.add(tf);
		
		this.combo = new JComboBox<>(strarr);
		this.combo.addActionListener(e->{
			flag = combo.getSelectedIndex()==0?true:false;
		});
		
		this.northpanel.add(combo);
		
		this.frame.add(northpanel, BorderLayout.NORTH);
	}

	private void initCenter() {
		// TODO Auto-generated method stub
		this.ta = new JTextArea();
		this.ta.setEditable(false);
		this.ta.setFont(new Font("궁서체", Font.BOLD, 20));
		this.frame.add(new JScrollPane(ta), BorderLayout.CENTER);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame("word3.txt");
	}

}
