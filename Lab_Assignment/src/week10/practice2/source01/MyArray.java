package week10.practice2.source01;

public class MyArray <E>{  // 파라미터
	private final int CAPACITY; // 배열크기
	private int count = 0; // 저장된 개수
	E[] arr;  // 저장되는 데이터 타입 E

	@SuppressWarnings("unchecked")
	public MyArray(int CAPACITY) {
		super();
		this.CAPACITY = CAPACITY;
		arr = (E[])new Object[this.CAPACITY];  // 타입 파라미터로는 객체 생성 불가 -> 모든 타입을 다 담는 Object로 객체 생성
	}

	public void add(E e) {
		if (this.count < this.CAPACITY)
			arr[count++] = e;
		else
			System.out.println("공간부족");
	}

	public E getElement(int index) {
		if (index >= 0 && index < count)
			return arr[index];
		else
			return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result = "";
		for(E e : arr) {	
			if(e != null)
				result += e.toString()+"\n";
		}
		return result;
	}
			
}
