package yrchoi.finaltest;

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
public class YrchoiFinalFrame extends JFrame {
	SubjectManager manager;	
	
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
	
	public YrchoiFinalFrame(String title, SubjectManager manager){
		super(title);
		this.manager = manager;		
		this.setSize(500,250);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
		
		manager = new SubjectManager("컴퓨터공학부");
		
		initTableData(comboflag);
	}

	
	private void removeTableData() {
		// TODO Auto-generated method stub
		if (model.getRowCount() > 0) {
			model = new DefaultTableModel(header1, 0);
			table.setModel(model);
		}
	}
	
	
	private void removeTableData2() {
		if (model.getRowCount() > 0) {
			model = new DefaultTableModel(header2, 0);
			table.setModel(model);
		}
	}
	
	
	private void initTableData(int comboflag) {
		// TODO Auto-generated method stub
		List<Subject> list = null;
		list = manager.sublist.stream().toList();			

		// model 전체를 바꾸는 방법으로 삭제
		removeTableData();
		
		for (Student std : list.get(comboflag).stdset) {  // sbj.stdset으로 쓰는 부분 자꾸 헷갈렸음.
			model.addRow(new String[] {std.stdID, std.stdName});				
		}
	}
	
	
	private void initTableData2(String stdID) {
		List<Subject> list = null;
		list = manager.sublist.stream().toList();
		
		// model 전체를 바꾸는 방법으로 삭제
		removeTableData2();

	    if (ascflag) {  // 오름차순 선택시
	        list = list.stream().sorted((o1, o2) -> (o1.stdset.size() - o2.stdset.size())).toList();
	    } else {  // 내림차순 선택시
	        list = list.stream().sorted((o1, o2) -> (o1.stdset.size() - o2.stdset.size()) * -1).toList();
	    }
		
		for (Subject sbj : list) {
			for (Student std : sbj.stdset) {
				if (std.stdID.equals(stdID)) {
					model.addRow(new String[] {sbj.subID, sbj.subName, Integer.toString(sbj.stdset.size())});
				}
			}
		}
	}


	public void init() {
		initNorthpanel();
		initCenterPanel();
	}
	

	private void initCenterPanel() {
		// TODO Auto-generated method stub
		this.ta = new JTextArea();
		this.ta.setEditable(false);
		
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
		this.combo.setSelectedIndex(0);  // 콤보박스의 요소 중 0번째를 기본으로 띄움.
		this.combo.addActionListener(e->{
			comboflag = combo.getSelectedIndex();  // 사용자가 선택한 콤보박스 요소의 인덱스를 저장
			initTableData(comboflag);
		});
		
		this.northpanel.add(combo);
		
		// northpanel의 검색할 학번 (JLable)
		this.northpanel.add(new JLabel("  검색할 학번  "));
		
		// northpanel의 텍스트 레이블 (JTextLabel)
		this.tf = new JTextField(10);
		
		this.tf.addActionListener(e -> {
			String stdID = tf.getText();
			
			List<Subject> subList = manager.findStudent(stdID);
			if (subList != null && !subList.isEmpty()) {  // subList가 null이 아니라는 조건을 빠뜨리면 안 됨.
				initTableData2(stdID);
			} else {
				JOptionPane.showMessageDialog(YrchoiFinalFrame.this, "학번을 확인해 주세요", "학번 확인", JOptionPane.ERROR_MESSAGE);
			}
			tf.setText("");
		});
		
		this.northpanel.add(tf);
		
		// northpanel의 라디오 버튼(JRadioButton)
		this.asc = new JRadioButton("ASC", true);
		this.asc.addItemListener(new ItemListener() {  // 메서드 오버라이딩 사용한 ItemListener
			
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
