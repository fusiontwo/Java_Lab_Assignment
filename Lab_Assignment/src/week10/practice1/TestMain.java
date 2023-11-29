package week10.practice1;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String re = "\\d{6}-[1-4]\\d{6}$";
		
		String sid1 = "000512-1234568";
		if (sid1.matches(re)) {
			System.out.println("일치합니다.");
		} else {
			System.out.println("일치하지 않습니다.");
		}

		String sid2 = "000512-5234568";
		if (sid2.matches(re)) {
			System.out.println("일치합니다.");
		} else {
			System.out.println("일치하지 않습니다.");
		}
		
		// 단어장 만들기
		VocManager voc = new VocManager("홍길동");
		voc.makeVoc("word3.txt");
	}

}
