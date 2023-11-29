package week13.practice1.source01;

public class Student_연습 implements Comparable<Student_연습>{
	String name;
	String sid;
	int score;
	
	public int getScore() {
		return score;
	}

	public Student_연습(String name, String sid, int score) {
		this.name = name;
		this.sid = sid;
		this.score = score;
	}

	@Override
	public String toString() {
		return this.name + " : " + this.sid + " : " + this.score;
	}

	@Override
	public int compareTo(Student_연습 o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
}
