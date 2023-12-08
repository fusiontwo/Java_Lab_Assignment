package yrchoi.finaltest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectManager {
	String deptName; // 학과명
	List<Subject> sublist = new ArrayList<>(); // 과목 저장하기 위한 리스트
	
	SubjectManager(String deptName){		
		this.deptName = deptName;
	}
	
	// 중복 제거를 위해 Subject 클래스에서 hashCode()와 equals() 메서드를 오버라이딩 한 후 사용 가능
	void addSubject(Subject sub) {
		if (sublist.contains(sub)) {
			System.out.println("이미 등록된 과목입니다.");
		}
		else {
			System.out.println("과목 등록이 완료되었습니다.");
			sublist.add(sub);			
		}
	}
	
	Subject findSubject(String subID) {
		List<Subject> copiedSublist = new ArrayList<Subject>(sublist);
		Collections.sort(copiedSublist);
		int index = Collections.binarySearch(copiedSublist, new Subject(subID, ""));
		if (index >= 0)
			return copiedSublist.get(index);
		else
			return null;
	}
	
	List<Subject> findStudent(String stdID) {	
		List<Subject> enrolledSubject = new ArrayList<>();  // 특정 학생이 수강하는 과목을 저장할 리스트
		for (Subject subject : sublist) {
			for (Student student : subject.stdset) {
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
		
		for (Subject subject : sublist) {
			str += subject.toString();
		}
		return str;
	}

	public Subject getMaxSubject() {	
		var result = sublist.stream().sorted((o1, o2) -> (o1.stdset.size()-o2.stdset.size()) * -1).limit(1).collect(Collectors.toList());	
		return result.isEmpty() ? null : result.get(0);
	}
}
