package week10.practice2.source01;

public class TestMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArray<Integer> arr = new MyArray<Integer>(10);
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		try {
			int num = arr.getElement(5);
		} catch(NullPointerException e) {
			System.out.println("인덱스 참조 오류");
		}
		
		Integer num = arr.getElement(5);
		if (num == null)
			System.out.println("인덱스 참조 오류");
		
		System.out.println(arr);

		MyArray<Word> arr2 = new MyArray<>(5);
		arr2.add(new Word("red", "빨강"));
		arr2.add(new Word("blue", "파랑"));
		Word num2 = arr2.getElement(1);
		System.out.println(arr2);
	}
		
}
