package yrchoi.finaltest2;

import java.util.HashSet;

public class Subject2 implements Comparable<Subject2>{
	String subID; //과목 번호
	String subName; //과목 이름
	HashSet<Student2> stdset = new HashSet<>(); // 수강생 저장구조
	
	public Subject2(String subID) {
		this(subID, null);		
	}

	public Subject2(String subID, String subName) {
		super();
		this.subID = subID;
		this.subName = subName;
	}
	
	public void register(Student2 std) {
		if (stdset.contains(std)) {
			System.out.println("이미 수강 등록되어 있습니다.");
		} else {
			stdset.add(std);
			System.out.println("수강 등록이 잘 되었습니다.");
		}
	}		

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.subID.hashCode() + this.subName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Subject2) {
			Subject2 sbj = (Subject2)obj;
			return this.subID.equals(sbj.subID) && this.subName.equals(sbj.subName);
		}
		else {
			return super.equals(obj);
		}
	}
	
	

	@Override
	public String toString() {		
		String str = "과목번호 : "+this.subID+"\n";
		str += "과목이름 : "+this.subName+"\n";
		str += "등록 학생 명단\n";
		str += "------------------------\n";		
		
		if (stdset.isEmpty()) {
			str += "등록한 학생이 존재하지 않습니다.\n\n";
		}
		else {
			for (Student2 student : stdset) {
				str += student.toString();
			}			
		}
		return str;
	}

	@Override
	public int compareTo(Subject2 o) {
		// TODO Auto-generated method stub
		return this.subID.compareTo(o.subID);
	}
	
}
