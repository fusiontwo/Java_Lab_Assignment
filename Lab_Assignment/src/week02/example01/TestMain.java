package week02.example01;

public class TestMain {
	
	public static String getBinaryString(int num) {
		if (num < 0) {
			return Integer.toBinaryString(num);
		}
		else {
			String tmpStr = "0".repeat(32) + Integer.toBinaryString(num);
			String result = tmpStr.substring(tmpStr.length()-32); 
			return result;
		}
	}
	

	public static void main(String[] args) {
		int a = 10;
		int b = -8;
		int c = a & b;  // AND
		int d = a | b;  // OR
		int e = a ^ b;  // Exclusive OR
		
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		System.out.println("d : " + d);
		System.out.println("d : " + e);
		System.out.println("-".repeat(40));
		
		String tmpStr = "0".repeat(32) + Integer.toBinaryString(a);
		System.out.println(tmpStr);
		String result = tmpStr.substring(tmpStr.length()-32);  // 오른쪽 끝에서부터 32비트만 가져온다.
		System.out.println(result);
		System.out.println("-".repeat(40));
		
		System.out.println("a : " + Integer.toBinaryString(a));
		System.out.println("b : " + Integer.toBinaryString(b));
		System.out.println("c : " + Integer.toBinaryString(c));
		System.out.println("d : " + Integer.toBinaryString(d));
		System.out.println("d : " + Integer.toBinaryString(e));
		System.out.println("-".repeat(40));
		
		System.out.println(getBinaryString(a));
		System.out.println(getBinaryString(b));
		System.out.println(getBinaryString(c));
		System.out.println("-".repeat(40));
		
		System.out.println("a : " + getBinaryString(a<<2));
		System.out.println("b : " + getBinaryString(b>>2));
		System.out.println("b : " + getBinaryString(b>>>2));
		System.out.println("-".repeat(40));
		
		// swap 연산
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println(a);
		System.out.println(b);

		// Exclusive OR는 swap에도 쓰인다.
		System.out.println("a : " + getBinaryString(a));
		System.out.println("b : " + getBinaryString(b));
		System.out.println("-".repeat(40));

		a = a^b;
		System.out.println("a : " + getBinaryString(a));
		System.out.println("b : " + getBinaryString(b));
		System.out.println("-".repeat(40));

		b = a^b;
		System.out.println("a : " + getBinaryString(a));
		System.out.println("b : " + getBinaryString(b));  // b값이 다시 a가 되었다.
		System.out.println("-".repeat(40));
		
		a = a^b;
		System.out.println("a : " + getBinaryString(a));
		System.out.println("b : " + getBinaryString(b));
		System.out.println("-".repeat(40));
	}

}
