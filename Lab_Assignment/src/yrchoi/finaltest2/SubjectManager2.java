package yrchoi.finaltest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectManager2 {
	String deptName; // 학과명
	List<Subject2> sublist = new ArrayList<>(); // 과목 저장하기 위한 리스트
	
	SubjectManager2(String deptName){		
		this.deptName = deptName;
	}
	
	void addSubject(Subject2 sub) {
		if (sublist.contains(sub)) {
			System.out.println("이미 등록된 과목입니다.");
		}
		else {
			System.out.println("과목 등록이 완료되었습니다.");
			sublist.add(sub);
		}
	}
	
	Subject2 findSubject(String subID) {
		List<Subject2> copiedSublist = new ArrayList<Subject2>(sublist);
		Collections.sort(copiedSublist);
		int index = Collections.binarySearch(copiedSublist, new Subject2(subID, ""));
		if (index >= 0)
			return copiedSublist.get(index);
		else
			return null;
	}
	
	List<Subject2> findStudent(String stdID) {
		List<Subject2> enrolledSubject = new ArrayList<>();  // 특정 학생이 수강하는 과목을 저장할 리스트
		for (Subject2 subject : sublist) {
			for (Student2 student : subject.stdset) {
				if (student.stdID.equals(stdID)) {
					enrolledSubject.add(subject);
					break;
				}
			}
		}
		if (enrolledSubject.isEmpty()) {
			return null;
		} else {
			return enrolledSubject;		
		}
	}
	
	@Override
	public String toString() {

		String str = "학과명 : "+this.deptName+"\n";	
		str += "개설 과목 현황\n";
		str += "=========================\n";
		
		for (Subject2 subject : sublist) {
			str += subject.toString();
		}
		return str;
	}

	public Subject2 getMaxSubject() {	
		var result = sublist.stream().sorted((o1, o2) -> (o1.stdset.size()-o2.stdset.size()) * -1).limit(1).collect(Collectors.toList());
		return result.isEmpty() ? null : result.get(0);		
	}
}
