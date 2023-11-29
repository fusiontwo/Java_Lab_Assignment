package week09.practice1.source01;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// 예외 클래스 만들기
class RangeCheckException extends RuntimeException {

	public RangeCheckException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}

public class TestMain {

	public static void method(String str) throws NullPointerException{
		System.out.println(str.length());
		try {
			System.out.println(str.length());			
		} catch (NullPointerException e) {
			System.out.println("NULL 값이 입력되었습니다.");
		} finally {
			
		}
	}
	
	private static void lab01() {
		int num = 100;
		Random rand = new Random();
//		while (true) {
		try {
			method("greenjoa");
			method(null);
			Class clazz = Class.forName("eek09.practice1.source1.TestMain");
			int result = num / rand.nextInt(100);
			System.out.println(result);	
			if (result > 2)
				return;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//					e.printStackTrace();
			System.out.println("클래스 이름 확인 요함");
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음.");
		} catch(NullPointerException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("다음 연산을 수행합니다.");
		}
	}

	public static Scanner scan = new Scanner(System.in);
	private static void lab02() {
		
		while(true) {
			try {
				System.out.println("1)커피 2)빵 3)종료");
				int choice = scan.nextInt();
				if (!(choice >= 1 && choice <= 3)) {
//					System.out.println("메뉴 범위를 체크하세요.");
					throw new RangeCheckException("메뉴 범위를 체크하세요.");
				}
			} catch (week09.practice1.source01.RangeCheckException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("정수값을 입력하세요.");
				scan.nextLine();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lab01();
		lab02();
	}

}
