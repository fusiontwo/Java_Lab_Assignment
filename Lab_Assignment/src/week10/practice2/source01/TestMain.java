package week10.practice2.source01;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202112439 최예름");
		Integer[] arr = {10,20,30,40};  // Integer 타입으로 생성
		printArray(arr);
		
		String[] arr2 = {"홍길동", "김길동", "고길동"};
		printArray(arr2);
		
		Word[] word = {new Word("red", "빨강색"), new Word("blue", "파랑색")};
		printArray(word);
	}

	private static <T> void printArray(T[] arr) {
		// TODO Auto-generated method stub
		for(T data : arr)
			System.out.println(data);
	}

//	private static void printArray(int[] arr) {
//		// TODO Auto-generated method stub
//		for(int data : arr)
//			System.out.println(data);
//	}

}
