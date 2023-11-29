package week11.practice2.source01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import week10.practice2.source01.Word;

public class VocManager {
	String userName;
	Word[] voc = new Word[100];
	int count = 0;
	Map<String, Word> map = new HashMap<>();

	static Scanner scan = new Scanner(System.in);
	
	public VocManager(String userName) {
		super();
		this.userName = userName;
	}
	
	void addWord(Word w) {
		if (this.count < voc.length)
			voc[count++] = w;
		else {
			System.out.println("더 이상 단어를 저장할 수 없습니다.");
		}
	}
	
	void makeVoc(String filename) {
		try(Scanner file = new Scanner(new File(filename));) {  // try 안에 넣어서 자동 close
			while(file.hasNextLine()) {
				String str = file.nextLine();
				String[] result = str.split("\t");
				this.addWord(new Word(result[0].trim(), result[1].trim()));
			}
			System.out.println(this.userName+"의 단어장이 생성되었습니다.");
			menu();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("파일 이름을 확인해 주세요.");
		}
	}

	private void menu() {
		// TODO Auto-generated method stub
		int choice = 0;
		while(true) {
			System.out.println("1)단어검색 2)종료 3)부분단어검색");
			System.out.print("메뉴를 선택하세요 : ");
			choice = scan.nextInt();
			scan.nextLine();  // 버퍼 비우기
			switch(choice) {
			case 1 -> searchVoc();
			case 2 -> {System.out.println("단어장을 종료합니다."); return;}
			case 3 -> searchVoc2();
			}
		}
	}

	private void searchVoc2() {
		// TODO Auto-generated method stub
		System.out.println("*** 영단어 뜻 검색 ***");
		System.out.print("영단어의 일부를 입력하세요 : ");
		String word = scan.nextLine();
		word = word.trim();
		
		Set<Entry<String, Word>> entryset = map.entrySet();
		Iterator<Entry<String, Word>> iterator = entryset.iterator();
		
		while(iterator.hasNext()) {
			Entry<String, Word> entry = iterator.next();
			String key = entry.getKey();
			Word value = entry.getValue();
			System.out.println(value);
		}
	}

	private void searchVoc() {
		// TODO Auto-generated method stub
		System.out.println("*** 영단어 뜻 검색 ***");
		System.out.print("영단어를 입력하세요 : ");
		String word = scan.nextLine();
		word = word.trim();
		Word w = map.get(word);
		if (w != null)
			System.out.println(w);
		else
			System.out.println("존재하지 않음");
	}
	
	
}
