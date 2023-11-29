package week13.yrchoi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VocManager {
   String userName;
   ArrayList<Word> voc = new ArrayList<>();
   
   static Scanner scan = new Scanner(System.in);
   
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
            this.addWord(new Word(result[0].trim(), result[1].trim(), 0));
         }
         System.out.println(this.userName+"의 단어장이 생성되었습니다.\n");
         menu();
         
      } catch (FileNotFoundException e) {
//         e.printStackTrace();
         System.out.println("파일 이름을 확인해 주세요.");
      }
   }

   private void menu() {
      int choice = 0;
      while(true) {
         System.out.println("\n" + "-".repeat(7) + " " + userName + "의 단어장 " + "-".repeat(7));
         System.out.println("1) 단어검색 2) 단어검색2 3) 빈출단어 4) 종료");
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
        	searchFreqVoc(); 
        	break;
         case 4 : 
            {System.out.println("\n" + userName + "의 단어장 프로그램을 종료합니다."); return;}
         }
      }
   }

   private void searchVoc() {
      System.out.println("\n" + "-".repeat(6) + " 단어 검색 " + "-".repeat(6));
      System.out.print("검색할 단어를 입력하세요 (영단어) : ");
      String word = scan.nextLine();
      word = word.trim();
      boolean wordExists = false;
      
      for(Word w : voc) {
    	  if(w.eng.equals(word)) {
    		  System.out.println("단어의 뜻 : " + w.kor);
    		  w.searchCnt++;
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
      boolean wordExists = false;
		
      for(Word w : voc) {
    	  if(w.eng.contains(word)) {
    		  System.out.println(w);
    		  w.searchCnt++;
    		  wordExists = true;
          }
      }
      
      if (!wordExists) {
    	  System.out.println("단어장에 등록된 단어가 아닙니다.");  	  
      }
   }
   
   private void searchFreqVoc() {
	   
	   voc.stream().sorted((o1,o2)->(o1.searchCnt-o2.searchCnt)*-1).limit(5).forEach(o1->System.out.println(o1.searchCnt + "번->" + o1.eng + " : " + o1.kor));
   }

}
