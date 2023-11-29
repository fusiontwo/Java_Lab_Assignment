package week13.practice1.source01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202112439 최예름");
		var list = new ArrayList<Student>();
		list.add(new Student("홍길동", "2020", 75));
		list.add(new Student("이길동", "2023", 90));
		list.add(new Student("박길동", "2021", 88));
		list.add(new Student("고길동", "2019", 85));
		list.add(new Student("최길동", "2009", 95));
		
		/* 방법1 */
		Predicate<Student> p = new Predicate<>() {

			@Override
			public boolean test(Student t) {
				// TODO Auto-generated method stub
				return t.score>=90;
			}
			
		};
		
		/* 방법2 */
//		Predicate<Student> p1 = t->t.score>=90;
		
		/* 방법3 */
		// 람다표현식을 바로 인자로 넣어도 됨.
//		list.removeIf(t->t.score>=90);
//		System.out.println(list);
		
		/* 방법4 */
		Consumer<Student> c = new Consumer<>() {
			
			@Override
			public void accept(Student t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}

		};
		
		list.forEach(t->System.out.println(t));
		System.out.println(list);
		
		// 점수가 가장 높은 사람 찾기
		/* 방법5 */	
		Comparator<Student> cmp = new Comparator<>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.score - o2.score;
			}
			
		};
		
		System.out.println(Collections.max(list, cmp));

		/* 방법6 */
		System.out.println(Collections.max(list, (o1,o2)->o1.score - o2.score));
		
		// 학번이 가장 이전인 사람 찾기
		/* 방법7 */
		// 내가 시도한 거
		System.out.println(Collections.min(list, (o1,o2)->Integer.parseInt(o1.sid) - Integer.parseInt(o2.sid)));
		// 교수님 코드
		System.out.println(Collections.min(list, (o1,o2)->o1.sid.compareTo(o2.sid)));
		
		System.out.println("-".repeat(30));
		
		/* 스트림 */
		// 방법1
		list.stream().sorted().forEach(t->System.out.println(t));
		System.out.println("-".repeat(30));
		// 방법2
		list.stream().sorted().forEach(System.out::println);
		System.out.println("-".repeat(30));
		
		// 성적 순 정렬
		list.stream().sorted((o1,o2)->(o1.score-o2.score)*-1).forEach(System.out::println);
		System.out.println("-".repeat(30));
		
		// 성적 순 정렬 (3명의 학생 정보만 출력)
		list.stream().sorted((o1,o2)->(o1.score-o2.score)*-1).limit(3).forEach(System.out::println);
		System.out.println("-".repeat(30));
		
		// 성적이 90점 이상인 학생들만 filter 하여 점수로 정렬하고 출력
		list.stream().filter(o1 -> o1.score >= 90).sorted((o1,o2)->(o1.score-o2.score)*-1).forEach(System.out::println);;
	
		// 성적이 90점 이상인 학생 정보를 리스트에 저장
		var result = list.stream().filter(o1 -> o1.score >= 90).collect(Collectors.toList());
		System.out.println(result);
		
		// 성적 총합 구하기
		int sum = list.stream().collect(Collectors.summingInt(t->t.score));
		System.out.println("총합 : " + sum);
		IntSummaryStatistics summary = list.stream().collect(Collectors.summarizingInt(t->t.score));
		System.out.println("평균 : " + summary.getAverage());		
		System.out.println("최대값 : " + summary.getMax());
		System.out.println("최소값 : " + summary.getMin());
		System.out.println("총합 : " + summary.getSum());
		
		// 중복 제거
		list.add(new Student("홍길동", "2020", 75));

		// 중복 제거 못한 부분 해보기
//		@Override
//		public boolean equals(Object o1, Object o2) {
//			return (o1,o2)->o1.sid.compareTo(o2.sid);
//		}

		list.stream().distinct().forEach(System.out::println);
		
	}


}
