package jwkim.finaltest;

public class Student {
	String id;
	String name;
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student st = (Student)obj;
			return this.id.equals(st.id);
		}
		else
			return false;
	}
	@Override
	public String toString() {
		String str = "학번 : "+this.id+" / ";
		str += "이름 : "+this.name+"\n";		
		str += "------------------------\n";
		return str;
	}
	
}
