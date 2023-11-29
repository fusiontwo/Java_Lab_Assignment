package week03.practice1;

import java.util.Scanner;

public class ArrayAccess {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray;
		intArray = new int[5];
		int max = 0; // 현재 가장 큰 수
		System.out.println("양수 5개를 입력하세요.");

		int idx = 0;
		for (int i = 0; i < 5; i++) {
			intArray[i] = scanner.nextInt(); // 입력 받은 정수를 배열에 저장
			if (intArray[i] > max) {
				max = intArray[i]; // max 변경
				idx = i;
			}
		}
		System.out.print("가장 큰 수는 " + max + "입니다.");
		System.out.println("가장 큰 수의 인덱스는 " + idx + "입니다.");
		scanner.close();
	}
}
