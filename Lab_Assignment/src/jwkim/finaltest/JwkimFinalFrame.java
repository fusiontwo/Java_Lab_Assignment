package jwkim.finaltest;

import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JwkimFinalFrame extends JFrame {
	Container frame = this.getContentPane();
	
	JPanel northpanel;
	JTextField tf;
	JComboBox<String> cb;
	Vector<String> subIDList;
	
	String[] header = {"학번", "이름"};
	DefaultTableModel model;
	JTable table;
	
	JRadioButton asc;
	JRadioButton desc;
	
	ButtonGroup group = new ButtonGroup();
	SubjectManager subManager;
	
	int subindex = 0;
	boolean ascflag = true;
	
	public JwkimFinalFrame (String name, SubjectManager csManger){
		this.setTitle("202012602 김종우");
		this.setSize(750, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		subManager = csManger;
		init();
		this.setVisible(true);
	}

	private void init() {
		// TODO Auto-generated method stub
		initNorth();
		initCenter();
	}

	private void removeTable() {
		// TODO Auto-generated method stub
		if(model.getRowCount() > 0) {
			model = new DefaultTableModel(header, 0);
			table.setModel(model);
		}
	}

	private void initCenter() {
		// TODO Auto-generated method stub
		this.model = new DefaultTableModel(header, 0);
		this.table = new JTable(model);
		cb.setSelectedIndex(0); // 초기 화면에서 표나오게 하기위해 여기서 이벤트 호출해줌
		this.frame.add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	private void initNorth() {
		// TODO Auto-generated method stub
		this.northpanel = new JPanel();
		
		subIDList = new Vector<>();
		for(Subject sub : subManager.sublist) {
			subIDList.add(sub.subID);
		}
		this.cb = new JComboBox(subIDList);	// subIDList가 0일 때는 고려하지 않음	
		this.cb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				removeTable();
				subindex = cb.getSelectedIndex();
				Subject sub = subManager.sublist.get(subindex);
				Iterator<Student> it = sub.stdset.iterator();			
				while(it.hasNext()) {
					Student std = it.next();
					model.addRow(new String[] {std.id, std.name});
				}
			}
			
		});
		this.northpanel.add(cb);
		
		this.northpanel.add(new JLabel("검색할 학번"));
		this.tf = new JTextField(20);
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ID = tf.getText();
				if(subManager.findStudent(ID) != null) {
					var list = subManager.findStudent(ID);
					removeTable();
					model = new DefaultTableModel(new String[] {"과목번호", "과목명", "신청인원"}, 0);
					if (ascflag) 
						list.sort((o1, o2)-> o1.stdnum - o2.stdnum);
					else 
						list.sort((o1, o2)-> (o1.stdnum - o2.stdnum)*(-1));					
					for(Subject sub : list) {
						model.addRow(new String[] {sub.subID, sub.subName, Integer.toString(sub.stdnum)});
					}
					table.setModel(model);
				}else {
					JOptionPane.showMessageDialog(JwkimFinalFrame.this, "학번을 확인해 주세요");
				}
			}			
		});
		this.northpanel.add(tf);
		
		asc = new JRadioButton("ASC", true);
		asc.addItemListener(e->{
			ascflag = true;
			initTable();
		});
		desc = new JRadioButton("DESC");
		desc.addItemListener(e->{
			ascflag = false;
			initTable();
		});
		group.add(asc);
		group.add(desc);
		this.northpanel.add(asc);
		this.northpanel.add(desc);
		
		this.frame.add(northpanel,BorderLayout.NORTH);
	}

	private void initTable() { // tf에서 입력값 가져오고, 학생정보 찾고, 있으면 리스트로 저장하고, 리스트 정렬하고, 테이블 지우고, model 다시 정의, model에 addRow하고, table에 올리기
		// TODO Auto-generated method stub
		String ID = tf.getText();
		if(subManager.findStudent(ID) != null) {
			var list = subManager.findStudent(ID);
			removeTable();
			model = new DefaultTableModel(new String[] {"과목번호", "과목명", "신청인원"}, 0);
			if (ascflag) 
				list.sort((o1, o2)-> o1.stdnum - o2.stdnum);
			else 
				list.sort((o1, o2)-> (o1.stdnum - o2.stdnum)*(-1));					
			for(Subject sub : list) {
				model.addRow(new String[] {sub.subID, sub.subName, Integer.toString(sub.stdnum)});
			}
			table.setModel(model);
		}
	}
}
