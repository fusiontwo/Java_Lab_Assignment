package week11.practice1.source01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202112439 최예름");
		
		/* HashSet 사용하기 */
		// 빈출단어
		HashSet<Word> set1 = new HashSet<>();
		set1.add(new Word("red1", "빨강색1"));
		set1.add(new Word("red2", "빨강색2"));
		set1.add(new Word("red3", "빨강색3"));
		set1.add(new Word("red4", "빨강색4"));
		set1.add(new Word("red5", "빨강색5"));
		
		// 오답노트
		HashSet<Word> set2 = new HashSet<>();
		set2.add(new Word("red1", "빨강색1"));
		set2.add(new Word("red7", "빨강색7"));
		set2.add(new Word("red3", "빨강색3"));
		set2.add(new Word("red8", "빨강색8"));
		
		HashSet<Word> set3 = new HashSet<>(set1);
		set3.retainAll(set2);
		System.out.println(set3);
		
		
		
		/* ArrayList와 LinkedList 시간 비교하기*/
//		ArrayList<Integer> arrlist = new ArrayList<>();		
//		LinkedList<Integer> linkedlist = new LinkedList<>();
//		
//		long starttime = System.nanoTime();
//		for(int i = 0; i < 10000; i++) {
////			arrlist.add(0, i);  // ArrayList는 데이터 하나 넣고 미는 동작을 반복
//			arrlist.add(i);  // ArrayList와 LinkedList의 시간이 별로 차이 안 나는 방식
//		}
//		long endtime = System.nanoTime();
//		System.out.println("ArrayList : " + (endtime-starttime));
//
//		starttime = System.nanoTime();
//		for(int i = 0; i < 10000; i++) {
////			linkedlist.add(0, i);  // ArrayList는 데이터 하나 넣고 미는 동작을 반복
//			linkedlist.add(i);  // ArrayList와 LinkedList의 시간이 별로 차이 안 나는 방식
//		}
//		endtime = System.nanoTime();
//		System.out.println("LinkedList : " + (endtime-starttime));
		
		/* Iterator 사용하기 */
//		LinkedList<Word> list = new LinkedList<>();
//		list.add(new Word("red1", "빨강색1"));
//		list.add(new Word("red2", "빨강색2"));
//		list.add(new Word("red3", "빨강색3"));
//		list.add(new Word("red4", "빨강색4"));
//		list.add(new Word("red5", "빨강색5"));
//		
//		// ListIterator는 뒤로만 쭉 가는 Iterator와 달리 앞/뒤로 이동 가능
//		ListIterator<Word> it = list.listIterator();  
//		while(it.hasNext()) {
//			Word w = it.next();
//			System.out.println(w);
//		}
//		System.out.println("==============");
//		while(it.hasPrevious()) {
//			Word w = it.previous();
//			if(w.eng.equals("red4"))
//				it.remove();
//			System.out.println(w);
//		}
//		System.out.println(list);
		
		/* 순서가 존재하지 않고 중복이 제외되는 HashSet
		 * Word 클래스에서 hashCode() 메서드를 override 해야 중복이 제거됨.*/
//		HashSet<Word> list = new HashSet<>();
//		list.add(new Word("red1", "빨강색1"));
//		list.add(new Word("red2", "빨강색2"));
//		list.add(new Word("red3", "빨강색3"));
//		list.add(new Word("red4", "빨강색4"));
//		list.add(new Word("red5", "빨강색5"));
//		// 중복해서 요소 넣기
//		list.add(new Word("red2", "빨강색2"));
//		list.add(new Word("red3", "빨강색3"));
//		list.add(new Word("red4", "빨강색4"));
//		list.add(new Word("red5", "빨강색5"));
//		
//		Iterator<Word> it = list.iterator();  
//		while(it.hasNext()) {
//			Word w = it.next();
//			System.out.println(w);
//		}
//		System.out.println(list);
		
		
		Vector<Word> list = new Vector<>();
		list.add(new Word("red1", "빨강색1"));
		list.add(new Word("red2", "빨강색2"));
		list.add(new Word("red3", "빨강색3"));
		list.add(new Word("red4", "빨강색4"));
		list.add(new Word("red5", "빨강색5"));
		
//		list.add(new Word("red1", "빨강색1"));
//		list.add(new Word("red2", "빨강색2"));
//		list.add(new Word("red3", "빨강색3"));
//		list.add(new Word("red4", "빨강색4"));
//		list.add(new Word("red5", "빨강색5"));
//		list.add(new Word("red1", "빨강색1"));
//		list.add(new Word("red2", "빨강색2"));
//		list.add(new Word("red3", "빨강색3"));
//		list.add(new Word("red4", "빨강색4"));
//		list.add(new Word("red5", "빨강색5"));
//		
//		Word w = new Word("red6", "빨강색6");
////		list.add(2, new Word("red6", "빨강색6"));
//		list.add(2, w);
//		System.out.println(list);
//		
////		list.remove(2);
////		list.remove(new Word("red6", "빨강색6"));

		
		/* equals 오버라이딩 해서 사용하기 */
//		while(list.contains(new Word("red4","빨강색4"))) {
//			int idx = list.indexOf(new Word("red4", "빨강색4"));
//			list.remove(idx);
//		}
//		
//		list.remove(new Word("red4", "빨강색4"));
//		
//		
//		Word w = list.get(1);
//		w.setKor("빨강2");
//		list.remove(1);
//		
//		System.out.println(list);
//		System.out.println(w);
//		
//		
//		List<Word> arr = list.subList(1, 4);
//		arr.get(0).setKor("빨강2");
//		arr.clear();  // arr의 요소를 지웠는데 원본 데이터도 지워짐.
//		
//		System.out.println(list);
//		System.out.println(arr);
		
		/* ArrayList */
//		ArrayList<Word> list2 = new ArrayList<>();
//		list2.add(new Word("red1", "빨강색1"));
//		list2.add(new Word("red2", "빨강색2"));
//		list2.add(new Word("red3", "빨강색3"));
//		list2.add(new Word("red4", "빨강색4"));
//		list2.add(new Word("red5", "빨강색5"));
//		
//		Object[] objarr = list2.toArray();
//		for (Object o : objarr) {
//			if (o instanceof Word) {
//				Word w = (Word)o;
//				System.out.println(o);
//			}
//		}
//		
//		Word[] arr2 = list2.toArray(new Word[list2.size()]);
//		for (Word w : arr2)
//			System.out.println(w);
	}

}
