package week04.practice1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class TestMain {
	
	public static void main(String[] args) {
//		lab01();
//		lab02();
		lab03();
	}
	
	
	public static void lab03() {
		String filename = "map.txt";
		int[][] map = makeMap(filename);
		if (map != null)
			showMap(map);
	}
	

	public static int[][] makeMap(String filename) {
		
		int[][] map = null;
		File file = new File(filename);  // 파일 객체 생성
		try {
			Scanner filescan = new Scanner(file);
			
			// map.txt 형식 확인하기!
			final int ROW = filescan.nextInt();
			final int COL = filescan.nextInt();
			map = new int[ROW][COL];
			
			// 방법 1. foreach 사용
			for(int[] row : map) {
				for(int i = 0; i < row.length; i++) {
					row[i] = filescan.nextInt();
				}
			}

			// 방법 2. 이중 for문 사용
//			for (int i = 0; i < map.length; i++) {
//				for (int j = 0; j < map[i].length; j++) {
//					map[i][j] = filescan.nextInt();
//				}
//			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("파일을 찾을 수 없습니다.");
//			e.printStackTrace();
		}  // Scanner()안에 System.in이 아닌, file 객체를 넣어야 한다.
		return map;
	}

	
	public static void showMap(int[][] map) {
		for(int[] row : map) {
			for (int col : row) {
				switch(col) {
				case 0 -> System.out.print("□");
				case 1 -> System.out.print("■");
				case 2 -> System.out.print("★");
				}
			}
			System.out.println();
		}
	}

	public static void lab02() {
		String[] names = {"홍길동","고길동","김길동","이길동"};
		int[][] scores = {{10,20,30,0},  // {점수1, 점수2, 점수3, 총점}
				{50,60,10,0},
				{60,50,30,0},
				{60,50,90,0}};
		getTotalScores(scores);
		printScores(names, scores);
	}

	
	public static void getTotalScores(int[][] scores) {
		for (int[] arr : scores) {
			for (int i = 0; i < arr.length - 1; i++) {
				arr[arr.length-1] += arr[i];  // 총점 부분에 모든 점수를 누적해서 더함.
			}
		}
	}

	
	public static void printScores(String[] names, int[][] scores) {
		
		for(int i = 0; i < names.length; i++) {
			System.out.print(names[i] + " >>> ");
			
			// 방법 1. foreach, 변수 사용
			int k = 0;
			for (int score : scores[i]) {
				if (k == scores[i].length-1)
					System.out.print(": ");
				System.out.print(score + " ");
				k++;
			}
			
			// 방법 2. 일반 for문 사용
//			for(int j = 0; j < scores[i].length; j++) {
//				if(j == scores[i].length - 1)
//					System.out.print(": ");
//				System.out.print(scores[i][j] + " ");
//			}
//			System.out.println();
		}
		
	}


	public static void lab01() {
		int[] answer = {1,2,4,4,3,3,1,1,2,4,4,3,3,1};
		int[] std1 = {1,1,1,1,1,1,1};
		int[] std2 = {2,2,2,2,2,2,2};
		int[] std = new int[answer.length];
		System.arraycopy(std1,  0, std, 0, std1.length);
		System.arraycopy(std2,  0, std, std1.length, std2.length);
		
		int[] quizResult = checkQuiz(answer, std.clone());
		printQuiz("정   답 : ", answer);
		printQuiz("제출한답 : ", std);
		printQuiz("채점결과 : ", quizResult);
	}


	public static void printQuiz(String string, int[] arr) {
		System.out.print(string);
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		
	}


	public static int[] checkQuiz(int[] answer, int[] std) {
		
		for (int i=0; i < answer.length; i++) {
			if (answer[i] == std[i])
				std[i] = 1;
			else 
				std[i] = 0;
		}
		return std;
	}

}
