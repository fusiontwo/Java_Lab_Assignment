package noname;

import java.io.IOException;

public class testMain2 {

	// main에서 예외를 throws 해버리면 JVM이 받는다. 실제 예외가 발생하면 프로그램이 kill된다.
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int code;
		// end of Stream(-1)이 아닐 때까지 입력을 받는다.
		while ((code = System.in.read()) != -1) {
			//  포맷팅 문자열과 입력값 순서가 다를 때 $1, $2 사용
			System.out.printf("code=%2$d, char=%1$c\n", (char)code, code);
		}
		System.out.println("입력 종료1");

		// 입력 버퍼에 -1이 남아있어서 위의 while문에서 Ctrl+Z 누르면 동시에 종료된다.
		while ((code = System.in.read()) != -1) {
			//  포맷팅 문자열과 입력값 순서가 다를 때 $1, $2 사용
			System.out.printf("code=%2$d, char=%1$c\n", (char)code, code);
		}
		System.out.println("입력 종료2");

	}

}
