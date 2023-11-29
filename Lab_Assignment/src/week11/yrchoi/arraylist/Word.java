package week11.yrchoi.arraylist;

public class Word {
	String eng;
	String kor;
	
	public Word(String eng, String kor) {
		super();
		this.eng = eng;
		this.kor = kor;
	}

	
	
	public void setKor(String kor) {
		this.kor = kor;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
//		return super.hashCode();
		return this.eng.hashCode() + this.kor.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Word) {
			Word w = (Word)obj;
			return this.eng.equals(w.eng) && this.kor.equals(w.kor);
		}else
			return super.equals(obj);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.eng + ": " + this.kor;
	}
	
	
}
