package yrchoi.finaltest2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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


@SuppressWarnings("serial")
public class YrchoiFinalFrame2 extends JFrame {
	SubjectManager2 manager;	
	
	Container frame = getContentPane();
	JPanel northpanel;
	String[] strarr;  // 콤보 박스에 넣을 문자열
	JComboBox<String> combo;
	JTextField tf;
	JRadioButton asc, desc;
	
	JTextArea ta;
	JTable table;
	DefaultTableModel model;
	String[] header1 = {"학번", "이름"};
	String[] header2 = {"과목번호", "과목명", "신청인원"};
	
	int comboflag = 0;  // 콤보박스의 인덱스
	boolean ascflag = true;
	
	
	public YrchoiFinalFrame2(String title, SubjectManager2 manager){
		super(title);
		this.manager = manager;		
		this.setSize(500,250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
		
		manager = new SubjectManager2("컴퓨터공학부");
		
		initTableData(comboflag);
	}

	private void initTableData(int comboflag) {
		// TODO Auto-generated method stub
		List<Subject2> list = null;
		list = manager.sublist.stream().toList();
		
		// model 전체를 바꾸는 방법으로 삭제
		removeTableData();
		
		for (Student2 std : list.get(comboflag).stdset) {
			model.addRow(new String[] {std.stdID, std.stdName});
		}
	}
	
	private void initTableData2(String stdID) {
		// TODO Auto-generated method stub
		List<Subject2> list = null;
		list = manager.sublist.stream().toList();
		
		removeTableData2();
		
		if (ascflag) {
			list = list.stream().sorted((o1, o2) -> (o1.stdset.size() - o2.stdset.size())).toList();
		} else {
			list = list.stream().sorted((o1, o2) -> (o1.stdset.size() - o2.stdset.size()) * -1).toList();
		}
		
		for (Subject2 sbj : list) {
			for (Student2 std : sbj.stdset) {
				if (std.stdID.equals(stdID)) {
					model.addRow(new String[] {sbj.subID, sbj.subName, Integer.toString(sbj.stdset.size())});
				}
			}
		}
	}
	

	private void removeTableData() {
		// TODO Auto-generated method stub
		if (model.getRowCount() > 0) {
			model = new DefaultTableModel(header1, 0);
			table.setModel(model);
		}
	}

	private void removeTableData2() {
		// TODO Auto-generated method stub
		if (model.getRowCount() > 0) {
			model = new DefaultTableModel(header2, 0);
			table.setModel(model);
		}
	}

	public void init() {
		initNorthpanel();
		initCenterPanel();
	}

	private void initCenterPanel() {
		// TODO Auto-generated method stub
//		this.ta = new JTextArea();
//		this.ta.setEditable(true);
//		this.frame.add(ta);
		
		this.model = new DefaultTableModel(header1, 0);
		this.table = new JTable(model);
		
		this.frame.add(new JScrollPane(table), BorderLayout.CENTER);
	}

	private void initNorthpanel() {
		// TODO Auto-generated method stub
		// northpanel의 콤보 박스
		this.northpanel = new JPanel();
		this.strarr = manager.sublist.stream().map(subject -> subject.subID).toArray(String[]::new);
		
		this.combo = new JComboBox<>(strarr);
		this.combo.setSelectedIndex(0);
		this.combo.addActionListener(e->{
			comboflag = combo.getSelectedIndex();
			initTableData(comboflag);
		});
		
		this.northpanel.add(combo);
		
		
		// northpanel의 검색할 학번 (JLabel)
		this.northpanel.add(new JLabel("  검색할 학번  "));
		
		
		// northpanel의 텍스트 레이블 (JTextLabel)
		this.tf = new JTextField(10);
		
		this.tf.addActionListener(e -> {
			String stdID = tf.getText();
			
			List<Subject2> subList = manager.findStudent(stdID);
			if (subList != null && !subList.isEmpty()) {
				initTableData2(stdID);
			} else {
				JOptionPane.showMessageDialog(YrchoiFinalFrame2.this, "학번을 확인해 주세요", "학번 확인", JOptionPane.ERROR_MESSAGE);
			}
			tf.setText("");
		});
		
		this.northpanel.add(tf);
		
		
		// northpanel의 라디오 버튼(JRadioButton)
		this.asc = new JRadioButton("ASC", true);
		this.asc.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					ascflag = true;
					initTableData2("");
				}
			}
		});
		
		this.desc = new JRadioButton("DESC");
		this.desc.addItemListener(e->{
			if (e.getStateChange() == ItemEvent.SELECTED) {
				ascflag = false;
				initTableData2("");
			}
		});
		
		ButtonGroup g = new ButtonGroup();
		g.add(asc);
		g.add(desc);
		
		this.northpanel.add(asc);
		this.northpanel.add(desc);
		
		
		// 배치 관리자로 frame의 NORTH에 northpanel을 추가
		this.frame.add(northpanel, BorderLayout.NORTH);
		
	}

}
