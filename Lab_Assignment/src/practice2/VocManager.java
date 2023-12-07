package week15.practice2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VocManager {
	String userName;
	
	ArrayList<Word> voc = new ArrayList<>();

	public VocManager(String userName){
		this.userName = userName;
	}
	
	public void addWord(Word word) {	
		if(!voc.add(word)) {
			System.out.println("단어장에 단어가 등록되지 않았습니다.");
		}
	}
	
	public boolean makeVoc(String fileName) {		
		try(Scanner scan = new Scanner(new File(fileName))){
			while(scan.hasNextLine()) {
				String str = scan.nextLine();
				String[] temp = str.split("\t");
				this.addWord(new Word(temp[0].trim(), temp[1].trim()));
			}
			
		}catch(FileNotFoundException e) {			
			return false;
		}
		return true;		
	}
	
	public List<Word> searchVoc2(String sWord) {
//		String str="";
		List<Word> list = new ArrayList<>();
		for(Word word : voc) {			
			if(word.eng.contains(sWord)) {
				list.add(word);
//				str += word+"\n";					
			}
		}
		return list;
	}
	

	public Word searchVoc(String sWord) {
		String result = "";
		for(Word word : voc) {
			if(word.eng.equals(sWord)) {
				return word;
//				result = "단어의 뜻 : "+word.kor;
//				return result;
			}
		}
		return null;
//		result = "단어장에 등록되어 있지 않습니다.";			
//		return result;		
	}
		
}








