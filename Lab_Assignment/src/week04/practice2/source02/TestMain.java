package week04.practice2.source02;

public class TestMain {

	public static void replaceChar(char[] arr, char a, char b) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == a)
				arr[i] = b;
		}
	}
	
	public static char[] replaceChar(String str, char a, char b) {
		char[] result = str.toCharArray();  // 문자열을 문자 배열로 변환
		replaceChar(result, a, b);  // 재귀 호출이 아니라 오버로딩한 메서드를 호출하는 것임.
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] result = replaceChar("greenjoa", 'e', 'E');
		for (char c : result) 
			System.out.print(c);
		System.out.println();
		
//		TV tv = new TV();
//		tv.powerOnOff();
//		tv.channelUP();
//		tv.channelUP();
//		tv.channelUP();
//		tv.showTV();
//		tv.volumeDown();
//		tv.volumeUp();
//		for(int i = 0; i < 15; i++)
//			tv.volumeUp();
	}

}
