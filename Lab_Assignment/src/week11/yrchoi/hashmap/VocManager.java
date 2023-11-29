package week11.yrchoi.hashmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class VocManager {
	String userName;
	Map<String, Word> voc = new HashMap<>();
	
	static Scanner scan = new Scanner(System.in);
	
	public VocManager(String userName) {
		super();
		this.userName = userName;
	}
	
	void addWord(Word w) {
		voc.put(w.eng, w);  
	}
	
	void makeVoc(String filename) {
		try(Scanner file = new Scanner(new File(filename));) {  // try 안에 넣어서 자동 close
			while(file.hasNextLine()) {
				String str = file.nextLine();
				String[] result = str.split("\t");
				this.addWord(new Word(result[0].trim(), result[1].trim()));
			}
			System.out.println(this.userName+"의 단어장이 생성되었습니다.\n");
			menu();
			
		} catch (FileNotFoundException e) {
			System.out.println("파일 이름을 확인해 주세요.");
		}
	}

	private void menu() {
		int choice = 0;
		while(true) {
			System.out.println("\n" + "-".repeat(7) + " " + userName + "의 단어장 " + "-".repeat(7));
			System.out.println("1) 단어검색 2) 단어검색2 3) 종료");
			System.out.print("메뉴를 선택하세요 : ");
			choice = scan.nextInt();
			scan.nextLine();  // 버퍼 비우기
			switch(choice) {
			case 1 :
				searchVoc();
				break;
			case 2 :
				searchVoc2();
				break;
			case 3 : 
				{System.out.println("\n" + userName + "의 단어장 프로그램을 종료합니다."); return;}
			}
		}
	}

	private void searchVoc() {
		System.out.println("\n" + "-".repeat(6) + " 단어 검색 " + "-".repeat(6));
		System.out.print("검색할 단어를 입력하세요 (영단어) : ");
		String word = scan.nextLine();
		word = word.trim();
		Set<Entry<String, Word>> entryset = voc.entrySet();
		Iterator<Entry<String, Word>> iterator = entryset.iterator();
		boolean wordExists = false;
		
		while(iterator.hasNext()) {
			Entry<String, Word> entry = iterator.next();
			String key = entry.getKey();
			Word value = entry.getValue();
			if (key.equals(word)) {
				System.out.println("단어의 뜻 : " + value.kor);
				wordExists = true;
				break;
			}
		}
		
		if (!wordExists) {
			System.out.println("단어장에 등록된 단어가 아닙니다.");
		}
	}

	private void searchVoc2() {
		System.out.println("\n" + "-".repeat(6) + " 단어 검색 " + "-".repeat(6));
		System.out.print("검색할 부분 단어를 입력하세요 (영단어) : ");
		String word = scan.nextLine();
		word = word.trim();
		Set<Entry<String, Word>> entryset = voc.entrySet();
		Iterator<Entry<String, Word>> iterator = entryset.iterator();
		boolean wordExists = false;
		
		while(iterator.hasNext()) {
			Entry<String, Word> entry = iterator.next();
			String key = entry.getKey();
			Word value = entry.getValue();
			if (key.contains(word)) {
				System.out.println(value);
				wordExists = true;
			}
		}
		
		if (!wordExists) {
			System.out.println("단어장에 등록된 단어가 아닙니다.");
		}
	}

}
