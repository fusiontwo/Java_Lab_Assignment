package week06.practice1;

import java.util.Scanner;

public class Refrigerator extends HomeAppliance {
	
	private int temperature = 2;
	public static Scanner scan = new Scanner(System.in);
	
	public Refrigerator(String haName) {
//		super(haName);
		this(haName, 2);
	}

	public Refrigerator(String haName, int temperature) {
		super(haName);
		this.temperature = temperature;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	void showStatus() {
		// TODO Auto-generated method stub
//		super.showStatus();  // 부모의 메서드를 호출 (여기서는 필요 X)
		if(this.isHaPower()) {
			System.out.println(this.getHaName() 
					+ "의 냉장온도 " + this.getTemperature() + "도");
		}
		else {
			System.out.println("전원이 꺼져있음.");
		}
	}

	@Override
	void menu() {
		// TODO Auto-generated method stub
//		super.menu();  // 부모의 메서드를 호출 (여기서는 필요 X)
		System.out.println(this.getHaName() + " 냉장고를 제어합니다.");
		System.out.println("1) 전원 2) 냉장온도");
		System.out.print("메뉴를 선택하세요 : ");
		int choice = scan.nextInt();
		switch(choice) {
		case 1->{
			this.setHaPower(!this.isHaPower()); 
			this.showStatus();}
		case 2->{
			System.out.print("냉장 온도 : ");
			this.setTemperature(scan.nextInt());
			this.showStatus();
		}
		default -> System.out.println("메뉴를 확인하세요.");
		}
	}
}
