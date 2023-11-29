//package week04.practice.source07;
//
//public class Vehicle {
//	public String color="검정색";
//	public int speed;
//	public int mileage;
//	public char gearStatus='P';
//	
//	public Vehicle(String color, int speed, int mileage, char gearStatus) {
//		this.color = color;
//		this.speed = speed;
//		this.mileage = mileage;
//		this.gearStatus = gearStatus;
//	}
//
//	
//	public Vehicle(String color, int mileage) {
//		this(color, 0, mileage, 'P');  // 다른 생성자를 통해 초기화 (위임 생성자)
////		this.color = color;
////		this.mileage = mileage;
//	}
//
//	
//	public Vehicle(String color) {
//		this(color, 0, 10000, 'P');  // 다른 생성자를 통해 초기화 (위임 생성자)
////		this.color = color;
//	}
//
//	public Vehicle() {
//		this("검정색", 0, 5000, 'P');  // 다른 생성자를 통해 초기화 (위임 생성자)
//	}
//
//
//	public Vehicle(Vehicle car1) {
//		// TODO Auto-generated constructor stub
//		TV tv = new TV();
//		this(car1.color, car1.speed, car1.mileage, car1.gearStatus); / // 얕은 복사 생성자
////		this.color = car1.color;
////		this.gearStatus = car1.gearStatus;
////		this.speed = car1.speed;
////		this.mileage = car1.mileage;
//	}
//
//
//	public void accelerate(int s) {
//		if(gearStatus!='P' && gearStatus!='N' ) {
//			speed+=s;
//			mileage += s;
//		}
//		showStatus();
//	}
//	
//	public void breaker(int b) {
//		if(gearStatus!='P' && gearStatus!='N' )
//			speed-=b;
//		showStatus();
//	}
//	
//	public void changeGear(char g) {
//		switch(g) {
//		case 'P' -> {gearStatus='P'; speed=0;}
//		case 'N' -> {gearStatus='N'; speed=0;}
//		case 'D' -> gearStatus='D';
//		case 'R' ->	gearStatus='R';
//		}
//	}
//	
//	public void showStatus() {
//		String status = switch(gearStatus){
//		case 'P' -> "주차";
//		case 'N' -> "중립";
//		case 'D' -> "주행";
//		case 'R' ->	"후진";	
//		default -> "주차";
//		};
//		System.out.println("-".repeat(5)+"차량상태"+"-".repeat(5));
//		System.out.println("색  상 : "+color);
//		System.out.println("마일리지 : "+mileage);
//		System.out.println("기어상태 : "+status);
//		System.out.println("속  도 : "+speed);	
//		tv.showTV();
//	}
//}
