package week06.practice1;

import java.util.Scanner;

public class Vacuum extends HomeAppliance {

	private int strong = 5;
	public static Scanner scan = new Scanner(System.in);
	
	public Vacuum(String haName, int strong) {
		super(haName);
		this.strong = strong;
	}

	public int getStrong() {
		return strong;
	}

	public void setStrong(int strong) {
		this.strong = strong;
	}

	@Override
	void showStatus() {
		// TODO Auto-generated method stub
//		super.showStatus();  // 부모의 메서드를 호출 (여기서는 필요 X)
		if(this.isHaPower()) {
			System.out.println(this.getHaName() 
					+ "의 세기 " + this.getStrong() + " 강도");
		}
		else {
			System.out.println("전원이 꺼져있음.");
		}
	}

	@Override
	void menu() {
		// TODO Auto-generated method stub
//		super.menu();  // 부모의 메서드를 호출 (여기서는 필요 X)
		System.out.println(this.getHaName() + " 청소기를 제어합니다.");
		System.out.println("1) 전원 2) 세기");
		System.out.print("메뉴를 선택하세요 : ");
		int choice = scan.nextInt();
		switch(choice) {
		case 1->{
			this.setHaPower(!this.isHaPower()); 
			this.showStatus();}
		case 2->{
			System.out.print("세기 : ");
			this.setStrong(scan.nextInt());
			this.showStatus();
		}
		default -> System.out.println("메뉴를 확인하세요.");
		}
	}
	
	
}
