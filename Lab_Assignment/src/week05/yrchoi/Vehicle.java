package week05.yrchoi;

public class Vehicle {
   public String color="검정색";
   public int speed;
   public int mileage;
   public char gearStatus='P';
   TV tv = new TV();
   
   public Vehicle(Vehicle car1) {//복사 생성자
      this(car1.color,car1.speed,car1.mileage,car1.gearStatus);
      this.tv = new TV(car1.tv);
//      this.color = car1.color;
//      this.speed = car1.speed;
//      this.mileage = car1.mileage;
//      this.gearStatus = car1.gearStatus;
   }
   
   public Vehicle(String color, int speed) {
      this(color, speed, 400, 'p');
   }
   
   public Vehicle(String color, int speed, int mileage, char gearStatus) {
      this.color = color;
      this.speed = speed;
      this.mileage = mileage;
      this.gearStatus = gearStatus;
   }
   
   public Vehicle() {
      this("빨강색", 0, 5000, 'p');
   }
   
   public void accelerate(int s) {
      if(gearStatus!='P' && gearStatus!='N' ) {
         speed+=s;
         mileage += s;
      }
      showStatus();
   }
   
   public void breaker(int b) {
      if(gearStatus!='P' && gearStatus!='N' )
         speed-=b;
      showStatus();
   }
   
   public void changeGear(char g) {
      switch(g) {
//      case 'P' -> {gearStatus='P'; speed=0;}
//      case 'N' -> {gearStatus='N'; speed=0;}
//      case 'D' -> gearStatus='D';
//      case 'R' ->   gearStatus='R';
      case 'P':
    	  gearStatus='P';
    	  speed=0;
    	  break;
      case 'N':
    	  gearStatus='N';
    	  speed=0;
    	  break;
      case 'D':
    	  gearStatus='D';
    	  break;
      case 'R':
    	  gearStatus='R';
    	  break;
      }
   }
   
   public void showStatus() {
//      String status = switch(gearStatus){
//      case 'P' -> "주차";
//      case 'N' -> "중립";
//      case 'D' -> "주행";
//      case 'R' ->   "후진";   
//      default -> "주차";
//      };
	  String status;
	  switch(gearStatus) {
	  case 'P':
		  status = "주차";
		  break;
	  case 'N':
		  status = "중립";
		  break;
	  case 'D':
		  status = "주행";
		  break;
	  case 'R':
		  status = "후진";
		  break;  
	  default:
		  status = "주차";
		  break;
	  }
      System.out.println("-".repeat(5)+"차량상태"+"-".repeat(5));
      System.out.println("색  상 : "+color);
      System.out.println("마일리지 : "+mileage);
      System.out.println("기어상태 : "+status);
      System.out.println("속  도 : "+speed);
      tv.showTV();
   }
}