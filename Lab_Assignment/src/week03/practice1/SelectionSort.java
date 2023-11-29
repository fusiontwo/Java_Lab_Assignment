package week03.practice1;

import java.util.Random;

public class SelectionSort {

	public static void lab01() {
		int[] list = {10, 50, 30, 60, 80, 40};
//		int[] list = null;
//		list = new int[] {10, 50, 30, 60, 80, 40};
		
//		int[] list = new int[6];
	//	list[0] = 10;
	//	list[1] = 50;
	//	list = new int[100];  // 기존 배열은 가비지 컬렉터가 제거함.
		System.out.println("정렬 전 : ");
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();

		for (int i = 0; i < list.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[minIdx] > list[j]) {
					minIdx = j;
				}
			}
			if (i!=minIdx) {
				// 방법1
			//	list[i] = list[i] ^ list[minIdx];
			//	list[minIdx] = list[i]^list[minIdx];
			//	list[i] = list[i]^list[minIdx];
				
				// 방법2
				int temp = list[i];
				list[i] = list[minIdx];
				list[minIdx] = temp;
			}			
		}
		
		System.out.println("정렬 후 : ");
		for (int num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
		
	}
	
	public static void lab02() {
		String[] list = {"홍길동", "고길동", "이길동", "최길동"};
		System.out.println("정렬 전 : ");
		for (String num : list) {
			System.out.print(num + " ");
		}
		System.out.println();

		for (int i = 0; i < list.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j].compareTo(list[minIdx]) < 0) {  // 앞의 것이 작으면 음수 반환
					minIdx = j;
				}
			}
			if (i!=minIdx) {
				// 방법1 (기본형 데이터에 대해서만 사용 가능, 참조형 데이터에는 사용 불가)
			//	list[i] = list[i] ^ list[minIdx];
			//	list[minIdx] = list[i]^list[minIdx];
			//	list[i] = list[i]^list[minIdx];
				
				// 방법2
				String temp = list[i];
				list[i] = list[minIdx];
				list[minIdx] = temp;
			}			
		}
		
		System.out.println("정렬 후 : ");
		for (String num : list) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	public static void lab03() {
		int[] lotto = makeLotto();
		printLotto(lotto);
	}
	
	public static int[] makeLotto() {
		
		int[] lotto = new int[6];
		Random rand = new Random();
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rand.nextInt(46) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[j] == lotto[i]) {
					i--;
					break;
				}					
			}
		}
		return lotto;
	}

	public static void printLotto(int[] lotto) {
		for (int num : lotto)
			System.out.print(num + " ");
		System.out.println();
	}


	public static void main(String[] args) {
		lab01();
		lab02();
		lab03();
	}

}
