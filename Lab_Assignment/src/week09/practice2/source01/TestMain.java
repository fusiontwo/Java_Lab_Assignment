package week09.practice2.source01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("202112439 최예름");
		mergeFile(args[0], args[1], args[2]);  // 입력 파일1, 입력 파일2, 출력 파일명
		mergeFile2(args[0], args[1], "dict.txt");
	}

	private static void mergeFile2(String filename1, String filename2, String filename3) {
		// TODO Auto-generated method stub
		try(Scanner file1 = new Scanner(new File(filename1));  // FileNotFoundException 발생 가능(빨간줄)
				Scanner file2 = new Scanner(new File(filename2));
				PrintWriter outfile = new PrintWriter(new File(filename3));) {
			
			writeFile(file1, outfile);
			writeFile(file2, outfile);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}

	private static void mergeFile(String filename1, String filename2, String filename3) {
		// TODO Auto-generated method stub
		Scanner file1 = null, file2 = null;
		PrintWriter outfile = null;
		try {
			file1 = new Scanner(new File(filename1));  // FileNotFoundException 발생 가능(빨간줄)
			file2 = new Scanner(new File(filename2));
			outfile = new PrintWriter(new File(filename3));
		
			writeFile(file1, outfile);
			writeFile(file2, outfile);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("파일을 찾을 수 없습니다.");
		} finally {
			if (file1 != null) file1.close();
			if (file2 != null) file2.close();
			if (outfile != null) outfile.close();  // 파일 close()를 주석처리 한다면 제대로 내용이 안 써짐.
		}
		
	}

	private static void writeFile(Scanner file, PrintWriter outfile) {
		// TODO Auto-generated method stub
		
		while(file.hasNextLine()) {  // 읽어올 다음 줄이 있으면 true, 없으면 false
			String str = file.nextLine();
			outfile.println(str);
		}
	}

}
