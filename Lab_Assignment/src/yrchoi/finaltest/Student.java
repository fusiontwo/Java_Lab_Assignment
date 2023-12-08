package yrchoi.finaltest;

public class Student implements Comparable<Student>{
	String stdID; //학번
	String stdName; //이름	
	
	public Student(String stdID, String stdName) {
		super();
		this.stdID = stdID;
		this.stdName = stdName;
	}

	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.stdID.hashCode() + this.stdName.hashCode();
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Student) {
			Student std = (Student)obj;
			return this.stdID.equals(std.stdID) && this.stdName.equals(std.stdName);
		}
		else
			return super.equals(obj);
	}


	@Override
	public String toString() {
		String str = "학번 : "+this.stdID+" / ";
		str += "이름 : "+this.stdName+"\n";		
		str += "------------------------\n";
		return str;
	}


	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.stdID.compareTo(o.stdID);
	}

}
