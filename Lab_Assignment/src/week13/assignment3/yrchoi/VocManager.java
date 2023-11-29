package week13.assignment3.yrchoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class VocManager {
   String userName;
   ArrayList<Word> voc = new ArrayList<>();
   
   static Scanner scan = new Scanner(System.in);
   static Random ran = new Random();
   
   
   public VocManager(String userName) {
      super();
      this.userName = userName;
   }
   
   
   void addWord(Word w) {
      voc.add(w);
   }
   
   
   void makeVoc(String filename) {
      try(Scanner file = new Scanner(new File(filename));) {  // try 안에 넣어서 자동 close
         while(file.hasNextLine()) {
            String str = file.nextLine();
            String[] result = str.split("\t");
            this.addWord(new Word(result[0].trim(), result[1].trim(), 0, 0));
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
         System.out.println("\n" + "-".repeat(6) + " " + userName + "의 영단어 퀴즈 " + "-".repeat(7));
         System.out.println("1) 주관식 퀴즈  2) 객관식 퀴즈  3) 오답노트  4) 단어검색  5) 종료");
         System.out.print("메뉴를 선택하세요 : ");
         try {
        	 choice = scan.nextInt();
        	 scan.nextLine();  // 버퍼 비우기
         } catch (InputMismatchException e) {
        	 System.out.println("메뉴 1 ~ 5에 해당하는 숫자를 입력하세요.");
        	 scan.nextLine();  // 버퍼 비우기
         }
         switch(choice) {
         case 1 -> shortAnswer();
         case 2 -> multiChoice();
         case 3 -> wrongAnswer();
         case 4 -> searchVoc();
         case 5 -> {System.out.println("\n" + userName + "의 단어장 프로그램을 종료합니다."); return;}
         default -> {System.out.println("1 ~ 5번 메뉴 중에 선택해주세요.");}
         }
      }
   }

   
	private void shortAnswer() {
		int correctCnt = 0;
		Set<String> usedQuiz = new HashSet<>();
		
		long starttime = System.currentTimeMillis();
		
		Collections.shuffle(voc);
		
		for(int i = 0; i <= 9; i++) {
			Word word = voc.get(ran.nextInt(voc.size()));
			
	        if (!usedQuiz.add(word.kor)) {
	            i--;
	            continue;
	        }

			System.out.println("-".repeat(6) + " 주관식 퀴즈 " + (i+1) + "번 " + "-".repeat(6));
			System.out.println("\"" + word.kor + "\"의 뜻을 가진 영어 단어는 무엇일까요?");
			System.out.print("답을 입력하세요 : ");
			String answer = scan.nextLine();
			answer.trim();	

			
			if (word.eng.equals(answer)) { 
				System.out.println("정답입니다.");
				correctCnt++;
			}
			else {
				System.out.println("틀렸습니다. 정답은 " + word.eng + "입니다.");
				word.wrongCnt++;
			}
			
			for(Word w : voc) {
				if (w.kor.equals(word.kor)) {
					w.wordFrequency++;
				}
			}
		}
		long endtime = System.currentTimeMillis();
		System.out.println("\n홍길동님 10문제 중 " + correctCnt + "개 맞추셨고, 총" + ((endtime-starttime)/1000.0) + "초 소요되었습니다.");
	}
	

	private void multiChoice() {
	    int correctCnt = 0;
	    long starttime = System.currentTimeMillis();

	    Collections.shuffle(voc);

	    for (int i = 0; i <= 9; i++) {
	        int answerRanIdx = ran.nextInt(4);
	        Word word = voc.get(i);
	        System.out.println("-".repeat(6) + " 객관식 퀴즈 " + (i + 1) + "번 " + "-".repeat(6));
	        System.out.println(word.eng + "의 뜻은 무엇일까요?");

	        List<String> choices = new ArrayList<>();

	        for (int j = 0; j <= 3; j++) {
	            String choiceKor;

	            if (j == answerRanIdx) {
	                choiceKor = word.kor;
	            } else {
	                do {
	                    Collections.shuffle(voc);
	                    choiceKor = voc.get(j).kor;
	                } while (choices.contains(choiceKor) || choiceKor.equals(word.kor));
	            }

	            choices.add(choiceKor);
	            System.out.println(j + 1 + ") " + choiceKor);
	        }

	        System.out.print("답을 입력하세요 : ");
	        try {
	            int answer = scan.nextInt();
	            scan.nextLine();  // 버퍼 비우기
	            if (answer == answerRanIdx + 1) {
	                System.out.println("정답입니다.");
	                correctCnt++;
	            } else {
	                System.out.println("틀렸습니다. 정답은 " + (answerRanIdx + 1) + "입니다.");
	                word.wrongCnt++;
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("객관식 번호 1 ~ 4 중에 골라주세요.");
	            scan.nextLine();  // 버퍼 비우기
	            word.wrongCnt++;
	        }

	        for (Word w : voc) {
	            if (w.kor.equals(word.kor)) {
	                w.wordFrequency++;
	            }
	        }
	    }

	    long endtime = System.currentTimeMillis();
	    System.out.println("\n홍길동님 10문제 중 " + correctCnt + "개 맞추셨고, 총" + ((endtime - starttime) / 1000.0) + "초 소요되었습니다.");
	}
	
	
	private void wrongAnswer() {
		boolean wrongExists = false;
		
		for(Word w : voc) {
		if (w.wrongCnt > 0) wrongExists = true;}
		
		voc.stream().filter(w -> w.wrongCnt > 0).sorted((w1, w2) -> Integer.compare(w2.wrongCnt, w1.wrongCnt))
		.forEach(w -> {
			System.out.println(w.eng + " 뜻 : " + w.kor);
			System.out.println("출제회수 : " + w.wordFrequency + "\t오답회수 : " + w.wrongCnt);
			System.out.println("-".repeat(30));
		});
		
		if (!wrongExists) System.out.println("틀린 문제가 없습니다.");
	}
	
	
	private void searchVoc() {
	    System.out.println("\n" + "-".repeat(6) + " 단어 검색 " + "-".repeat(6));
	    System.out.print("검색할 단어를 입력하세요 : ");
	    String word = scan.nextLine();
	    word = word.trim();
	    boolean wordExists = false;
	      
	    for(Word w : voc) {
	    	if(w.eng.equals(word)) {
	    		System.out.println(word + " 뜻 : " + w.kor);
	    		System.out.println("출제회수 : " + w.wordFrequency + "\t오답회수 : " + w.wrongCnt);
	    		wordExists = true;
	    		break;
	    	}
	    }
	      
	    if (!wordExists) {
	    	System.out.println("단어장에 등록된 단어가 아닙니다.");  	  
	    }
	}

}