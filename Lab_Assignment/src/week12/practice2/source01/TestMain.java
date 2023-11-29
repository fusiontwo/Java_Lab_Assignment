package week12.practice2.source01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

class StdComparator implements Comparator<Student> {
	int flag = 0;
	
	public StdComparator(int flag) {
		super();
		this.flag = flag;
	}

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		switch(flag) {
		case 1->{return o1.name.compareTo(o2.name);}
		case 2->{return o1.name.compareTo(o2.name)*-1;}
		case 3->{return o1.score-o2.score;}
		case 4->{return (o1.score-o2.score)*-1;}
		default->{return o1.sid.compareTo(o2.sid);}
		}
	}
	
}


public class TestMain {

	public static void main(String[] args) {
		System.out.println("202112439 최예름");
//		var list = new ArrayList<Integer>();  // var 타입이면 Integer처럼 타입을 명시해야 한다.
//		for(int i = 10; i < 100; i+=10) {
//			list.add(i);
//		}
//		
//		Collections.shuffle(list);
//		System.out.println(list);
//		
//		Collections.sort(list, Collections.reverseOrder());
//		System.out.println(list);
		
		var list = new ArrayList<Student>();
		list.add(new Student("홍길동", "2020", 75));
		list.add(new Student("이길동", "2023", 90));
		list.add(new Student("박길동", "2021", 88));
		list.add(new Student("고길동", "2019", 85));
		list.add(new Student("최길동", "2009", 95));
		
		lab01(list);
		lab02(list);
		lab03(list);
		lab04(list);
		lab05(list);
		
	}




	private static void lab01(ArrayList<Student> list) {
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
	}


	private static void lab02(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		/* 2 */
		Collections.shuffle(list);
		System.out.println(list);

		Collections.sort(list, new StdComparator(2));
		System.out.println(list);
		
		/* 1 */
//		// 익명 클래스의 객체 생성
//		Comparator<Student> cmp = new Comparator<>() {
//			
//			@Override
//			public int compare(Student o1, Student o2) {
//				// TODO Auto-generated method stub
//				return o1.score - o2.score;
//			}
//			
//			
//		};
//		
//	//		Collections.sort(list, cmp);
//		Collections.sort(list, new Comparator<>() {
//			
//			@Override
//			public int compare(Student o1, Student o2) {
//				// TODO Auto-generated method stub
//	//				return o1.score - o2.score;
//				return (o1.score - o2.score)*-1;
//			}
//			
//			
//		});
		System.out.println(list);
	}
	

	private static void lab03(ArrayList<Student> list) {
		// TODO Auto-generated method stub
		StdComparator cmp = new StdComparator(3);
		Collections.sort(list, cmp);
		Collections.sort(list);
//		int index = Collections.binarySearch(list, new Student("박길동", "", 0), cmp);
		int index = Collections.binarySearch(list, new Student("", "", 88), cmp);
		if (index >= 0)
			System.out.println(list.get(index));
	}
	
	
	private static void lab04(ArrayList<Student> list) {
		// TODO Auto-generated method stub
//		@Override
//		public int compare(Student o1, Student o2) {
//			// TODO Auto-generated method stub
//			return o1.score - o2.score;
//		}
		Collections.sort(list, (o1, o2)->o1.score - o2.score);  // (Student o1, Student o2) 타입 생략, return문 대신 식으로

		
//		Comparator<Student> cmp = new Comparator<>() {
//		
//		@Override
//		public int compare(Student o1, Student o2) {
//			// TODO Auto-generated method stub
//			return o1.score - o2.score;
//		}
//		
//		
//	};
		
		Comparator<Student> cmp = (o1, o2)->o1.score - o2.score;
		Collections.sort(list, cmp);
	}

	
	private static void lab05(ArrayList<Student> list) {
		// TODO Auto-generated method stub
//		Predicate<Student> scoreCheck = new Predicate<>() {
//
//			@Override
//			public boolean test(Student t) {
//				// TODO Auto-generated method stub
//				return t.score >= 90;
//			}
//			
//		};
		
		Predicate<Student> scoreCheck = std->std.score>=90;
		for(Student s : list)
			if(scoreCheck.test(s))
				System.out.println(s);
	}

}