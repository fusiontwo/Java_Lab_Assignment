package week06.practice1;

import java.util.Scanner;

public class Home {
	private HomeAppliance[] apps;
	private final int capacity;
	private int count = 0;
	public static Scanner scan = new Scanner(System.in);
	
	public Home(int capacity) {
		super();
		this.capacity = capacity;
		this.apps = new HomeAppliance[this.capacity];
	}
	
	public void buyHA(HomeAppliance ha) {
		if (this.count < this.capacity) {
			this.apps[this.count++] = ha;
			System.out.println("배치 완료");
		}
		else {
			System.out.println("공간 부족");
		}
	}
	
	public void open() {
		System.out.println("가전제품 제어를 시작합니다.");
		while(true) {
			for(int i = 0; i < this.count; i++) {
				System.out.println((i+1) + "번)" + this.apps[i].getHaName());
			}
			System.out.println("0번)종료");
			System.out.print("메뉴를 선택하세요 : ");
			int index = scan.nextInt();
			if(index >= 1 && index <= this.count) {
				this.apps[index-1].menu();
			}
			else {
				System.out.println("제어를 종료합니다.");
				break;
			}
		}
	}
	
}
