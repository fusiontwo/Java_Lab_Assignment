package week12.practice1.source01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202112439 최예름");
		lab01();
		lab02();
		lab03();
		lab04();
		lab05();
		lab06();
	}

	private static void lab06() {
		List<Word> list = new LinkedList<>();
		
		list.add(new Word("red", "빨강"));
		list.add(new Word("green", "초록"));
		list.add(new Word("blue", "파랑"));

		// 정렬 전
		System.out.println(list);
		
		// 정렬 후
		// 뜻 기준으로 정렬하기 위해 Word 클래스를 수정했음.
		Collections.sort(list);
		System.out.println(list);
	}

	private static void lab05() {
		String[] arr = {"홍길동", "김길동", "이길동", "고길동"};
//		List<String> list = Arrays.asList(arr);
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
		
		Arrays.sort(arr);
		for (String s : arr) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

	private static void lab04() {
		System.out.println("<Deque>");
		Deque<Word> queue = new LinkedList<>();
		queue.offer(new Word("red", "빨강"));
		queue.offer(new Word("green", "초록"));
		queue.offer(new Word("blue", "파랑"));
		
		while(!queue.isEmpty()) {
			System.out.println(queue.pollLast());
		}
		
		System.out.println("-".repeat(20));
	}

	private static void lab03() {
		System.out.println("-".repeat(20));
		System.out.println("<Queue using iterator>");
		
		Queue<Word> queue = new LinkedList<>();
		queue.offer(new Word("red", "빨강"));
		queue.offer(new Word("green", "초록"));
		queue.offer(new Word("blue", "파랑"));
		
//		Iterator<Word> it = queue.iterator();
		var it = queue.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("-".repeat(20));
		System.out.println("<Queue using .poll()>");
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
		System.out.println("-".repeat(20));
	}

	private static void lab02() {
		System.out.println("-".repeat(20));
		
		String exp1 = "3 20 6 * +";
		int result1 = getResult(exp1);
		System.out.println(result1);
		String exp2 = "3 20 6 * 2 * + 20 +";
		int result2 = getResult(exp2);
		System.out.println(result2);
	}

	private static int getResult(String exp) {
		String[] str = exp.split(" ");
		Stack<Integer> stack = new Stack<>();
		for(String s : str) {
			switch(s) {
			case "+" -> {
				int temp = stack.pop() + stack.pop();
				stack.push(temp);
			}
			case "-" -> {
				int temp = stack.pop() - stack.pop();
				stack.push(temp);
			}
			case "*" -> {
				int temp = stack.pop() * stack.pop();
				stack.push(temp);
			}			
			case "/" -> {
				int temp = stack.pop() / stack.pop();
				stack.push(temp);
			}
			default -> {
				stack.push(Integer.parseInt(s));
			}
			}
		}
		int result = stack.pop();
		return result;
	}

	private static void lab01() {
		// TODO Auto-generated method stub
		Stack<Word> stack = new Stack<>();
		stack.push(new Word("red", "빨강"));
		stack.push(new Word("green", "초록"));
		stack.push(new Word("blue", "파랑"));
		
//		Iterator<Word> it = stack.iterator();
		var it = stack.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("-".repeat(20));
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
	
	

}
