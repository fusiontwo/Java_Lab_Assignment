package week04.practice2.source06;

public class Book {
	String title;
	String author;

	public Book(String t) { // 생성자
		title = t;
		author = "작자미상";
	}

	public Book(String t, String a) { // 생성자
		title = t;
		author = a;
	}

	public static void main(String [] args) {
		Book javaBook = new Book("Java", "홍길동"); 
		Book bible = new Book("Bible"); 							
	}
}
