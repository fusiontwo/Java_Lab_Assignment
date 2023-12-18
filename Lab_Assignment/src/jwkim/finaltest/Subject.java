package jwkim.finaltest;

import java.util.HashSet;
import java.util.Iterator;

public class Subject implements Comparable<Subject> {
	String subID;
	String subName;
	int stdnum = 0;
	HashSet<Student> stdset = new HashSet<>();
	
	public Subject(String subID) {
		this(subID, null);		
	}
	
	public Subject(String subID, String subName) {
		super();
		this.subID = subID;
		this.subName = subName;
	}
	
	void register(Student st) {
		if (stdset.add(st)) {
			System.out.println("수강 등록이 잘 되었습니다.");
			stdnum++;
		}
		else
			System.out.println("이미 수강 등록되어 있습니다.");
	}

	@Override
	public String toString() {
		String str = "과목번호 : "+this.subID+"\n";
		str += "과목이름 : "+this.subName+"\n";
		str += "등록 학생 명단\n";
		str += "------------------------\n";	
		Iterator<Student> it = this.stdset.iterator();
		if (!it.hasNext())
			str += "등록한 학생이 존재하지 않습니다.\n\n";
		
		while(it.hasNext()) {
			str += it.next();
		}
		
		return str;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Subject) {
			Subject sub = (Subject)obj;
			return this.subID.equals(sub.subID);
		}
		else
			return false;
	}

	@Override
	public int compareTo(Subject sub) {
		// TODO Auto-generated method stub
		return this.subID.compareTo(sub.subID);
	}
	
	
}
