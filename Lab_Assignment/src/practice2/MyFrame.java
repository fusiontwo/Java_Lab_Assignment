package practice2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
	
	String[] header = {"영어단어", "단어 뜻"};
	DefaultTableModel model;
	JTable table;
	
	JRadioButton asc, desc;
	boolean ascflag = true;
	
	public MyFrame(String filename) {
		
		this.filename = filename;
		
		this.setTitle("202112439 최예름");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);  // 창을 처음에 중앙에 띄움
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  // 프레임과 함께 프로그램 종료시키기
		init();
		this.setVisible(true);
		
		voc = new VocManager("홍길동");
		boolean result = voc.makeVoc(filename);
		if(result) {
			JOptionPane.showMessageDialog(this, "단어장 생성이 완료되었습니다.");
			initTableData();
		} else {
			JOptionPane.showMessageDialog(this, "파일 경로를 확인하세요.");
		}
		
	}
	
	void removeTableData() {
		if (model.getRowCount()>0) {
			model = new DefaultTableModel(header, 0);
			table.setModel(model);
		}
	}
	
	private void initTableData() {
		// TODO Auto-generated method stub
		List<Word> list = null;
		if(ascflag) {  // 오름차순 선택시
			list = voc.voc.stream().sorted((o1,o2)->o1.eng.compareTo(o2.eng)).toList();
		} else {  // 내림차순 선택시
			list = voc.voc.stream().sorted((o1,o2)->o1.eng.compareTo(o2.eng)*-1).toList();			
		}

		// 방법1) 한 행씩 지우는 방법
//		for (int i=model.getRowCount()-1; i>=0; i--) {  // 앞에서부터 지우면 잘못 삭제될 가능성이 있어서 뒤에서부터 삭제
//			model.removeRow(i);
//		}
		
		// 방법2) model 전체를 바꾸기
		removeTableData();
		
		for(Word w : list) {
			model.addRow(new String[] {w.eng, w.kor});
		}
	}

	private void init() {
		// TODO Auto-generated method stub
		initNorthpanel();
		initCenter();
	}


	private void initNorthpanel() {
		// TODO Auto-generated method stub
		this.northpanel = new JPanel();
		this.asc = new JRadioButton("asc", true);
		this.asc.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ascflag = true;
					initTableData();
				}
			}
			
		});
		this.desc = new JRadioButton("desc");
		this.desc.addItemListener(e->{
			if (e.getStateChange() == ItemEvent.SELECTED) {
				ascflag = false;
				initTableData();
			}
		});
		
		ButtonGroup g = new ButtonGroup();
		g.add(asc);
		g.add(desc);
		
		this.northpanel.add(asc);
		this.northpanel.add(desc);
		
		this.northpanel.add(new JLabel("검색할 단어 "));
		this.tf = new JTextField(15);
		this.tf.setFont(new Font("궁서체", Font.BOLD, 20));
		
		this.tf.addActionListener(e -> {
			String eng = tf.getText();

			if(flag) {
				Word w = voc.searchVoc(eng);
				if(w!=null) {
					removeTableData();
					model.addRow(new String[] {w.eng, w.kor});
				}else {
					JOptionPane.showMessageDialog(MyFrame.this, "단어장에 등록되지 않은 단어입니다.");
				}
			}
			else {
				var list = voc.searchVoc2(eng);
				if(!list.isEmpty()) {
					removeTableData();
					for (Word w : list) {
						model.addRow(new String[] {w.eng, w.kor});
					}
				}else {
					JOptionPane.showMessageDialog(MyFrame.this, "단어장에 등록되지 않은 단어입니다.");
				}
			}
			
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
		
		this.model = new DefaultTableModel(header, 0);
		this.table = new JTable(model);
		
		this.frame.add(new JScrollPane(table), BorderLayout.CENTER);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame f = new MyFrame("word3.txt");
	}

}
