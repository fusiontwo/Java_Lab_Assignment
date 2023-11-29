package week13.assignment3.yrchoi;

public class Word {
	String eng;
	String kor;
	int wordFrequency;
	int wrongCnt;
	
	public Word(String eng, String kor, int wordFrequency, int wrongCnt) {
		super();
		this.eng = eng;
		this.kor = kor;
		this.wordFrequency = wordFrequency;
		this.wrongCnt = wrongCnt;
	}
	

	@Override
	public int hashCode() {
//		return super.hashCode();
		return this.eng.hashCode() + this.kor.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
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
