package week06.practice1;

import java.util.Scanner;

public class TV extends HomeAppliance {
	private int channel = 10;
	public static Scanner scan = new Scanner(System.in);
	
	public TV(String haName, int channel) {
		super(haName);
		this.channel = channel;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	@Override
	void showStatus() {
		// TODO Auto-generated method stub
//		super.showStatus();  // 부모의 메서드를 호출 (여기서는 필요 X)
		if(this.isHaPower()) {
			System.out.println(this.getHaName() 
					+ "의 채널 " + this.getChannel() + "번");
		}
		else {
			System.out.println("전원이 꺼져있음.");
		}
	}

	@Override
	void menu() {
		// TODO Auto-generated method stub
//		super.menu();  // 부모의 메서드를 호출 (여기서는 필요 X)
		System.out.println(this.getHaName() + " TV를 제어합니다.");
		System.out.println("1) 전원 2) 채널");
		System.out.print("메뉴를 선택하세요 : ");
		int choice = scan.nextInt();
		switch(choice) {
		case 1->{
			this.setHaPower(!this.isHaPower()); 
			this.showStatus();}
		case 2->{
			System.out.print("채널 : ");
			this.setChannel(scan.nextInt());
			this.showStatus();
		}
		default -> System.out.println("메뉴를 확인하세요.");
		}
	}
	
}
