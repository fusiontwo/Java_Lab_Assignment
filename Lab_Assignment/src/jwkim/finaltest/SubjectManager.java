package jwkim.finaltest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class SubjectManager {
	String deptName; // 학과명
	List<Subject> sublist = new ArrayList<>(); // 과목 저장하기 위한 리스트
	
	SubjectManager(String deptName){		
		this.deptName = deptName;
	}
	
	void addSubject(Subject sub) {
		Iterator<Subject> it = sublist.iterator();
		while(it.hasNext()) {
			if(it.next().equals(sub)) {
				System.out.println("이미 등록된 과목입니다.");
				return;
			}
		}
		sublist.add(sub);
		System.out.println("과목 등록이 완료 되었습니다.");
	}
	
	Subject findSubject(String subID) {
		List<Subject> list;
		list = sublist.stream().sorted().toList();
		int index = Collections.binarySearch(list, new Subject(subID, null));
		if(index == -1)
			return null;
		else
			return list.get(index);
	}
	
	List<Subject> findStudent(String stdID) {	
		List<Subject> list = new ArrayList<>();
		
		for(Subject sub : sublist) {
			Iterator<Student> it = sub.stdset.iterator();
			while(it.hasNext()) {
				if(it.next().id.equals(stdID)) {
					list.add(sub);
					break;
				}
			}
		}
		if(list.size() == 0)
			return null;
		else
			return list;		
	}
	
	@Override
	public String toString() {

		String str = "학과명 : "+this.deptName+"\n";	
		str += "개설 과목 현황\n";
		str += "=========================\n";
		for(Subject sub: sublist) {
			str += sub;
		}
		return str;
	}

	public Subject getMaxSubject() {		
		List<Subject> list = sublist.stream().sorted(new Comparator<>(){

			@Override
			public int compare(Subject o1, Subject o2) {
				// TODO Auto-generated method stub
				return (o1.stdset.size() - o2.stdset.size())*(-1);
			}
			
		}).toList();
		Subject sub = list.get(0);
		if(sub == null)
			return null;
		else
			return sub;	
	}

}
