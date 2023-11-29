package week10.practice2.source02;

import java.util.List;
import java.util.Vector;

public class testMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list1 = new Vector<String>();
		List<String> list2 = new Vector<>();
		Vector<String> list3 = new Vector<>();
		Vector<String> list4 = new Vector<>(3, 5);  // 방을 5개씩 증가시킨다.
		System.out.println(list3.size() + " : " + list3.capacity());
		System.out.println(list4.size() + " : " + list4.capacity());
	
		for(int i = 0; i < 12; i++)
			list3.add(i + "");
		for(int i = 0; i < 8; i++)
			list4.add(i+"");
		
		Vector<String> list5 = new Vector<>(list4);
		System.out.println(list5);
		
		list5.remove(0);
		list5.remove(0);
		list5.remove(0);
		
		list5.trimToSize();
		
		System.out.println(list5);
		System.out.println(list5.size() + " : " + list5.capacity());
		
//		System.out.println(list3.size() + " : " + list3.capacity());		
//		System.out.println(list4.size() + " : " + list4.capacity());
		
	}

}
