package week03.example01;

import java.util.Scanner;

public class TestMain {

	public static final int AMERICANO = 100;
	public static final int CAFFELATTE = 200;
	public static int americano = 0;
	public static int caffelatte = 0;
	
	public static Scanner scan = new Scanner(System.in);
	
	public static int selectMenu() {
		System.out.println("1) 아메리카노(100원) 2) 카페라떼(200원) 3) 결제 4) 종료");
		System.out.print("선택하세요 : ");
		int menu = scan.nextInt();
		return menu;
	}


	public static void orderAmericano() {
		System.out.println("아메리카노 주문하셨습니다.");
		americano++;
	}
	
	
	public static void orderCaffelatte() {
		System.out.println("카페라떼 주문하셨습니다.");
		caffelatte++;
	}
	
	
	public static void payment() {
		int americanoPrice = americano * AMERICANO;
		int caffelattePrice = caffelatte * CAFFELATTE;
		int total = americanoPrice + caffelattePrice;
		

		System.out.println("=".repeat(20));
		System.out.println("\t 결제 금액");
		System.out.println("=".repeat(20));
		if (americano != 0)	System.out.println("아메리카노 " + americano + "잔 " + americanoPrice + "원");
		if (caffelatte != 0) System.out.println("카페라떼 " + caffelatte + "잔 " + caffelattePrice + "원");
		System.out.println("=".repeat(20));
		System.out.println("총 " + total + "원");
		System.out.println("=".repeat(20));			

		americano = 0;
		caffelatte = 0;
	}	
	

	public static void sysExit() {
		System.out.println("프로그램을 종료합니다.");
		scan.close();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		
		while (true) {
			int menu = selectMenu();
			switch (menu) {
			case 1 -> orderAmericano();
			case 2 -> orderCaffelatte();
			case 3 -> payment();
			case 4 -> sysExit();
			default -> System.out.println("메뉴를 확인하세요.");
			}
		}
		
	}







}
