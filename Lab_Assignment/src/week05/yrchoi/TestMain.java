package week05.yrchoi;

public class TestMain {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Vehicle car1 = new Vehicle("빨강색", 0, 10000, 'P');
      Vehicle car2 = new Vehicle(car1);
      
      car1.showStatus();
      car2.showStatus();
      
      car2.color = "보라색";
      car1.tv.powerOnOff();
      car1.tv.channelUP();
      car1.tv.channelUP();
      car1.tv.channelUP();
      
      
      car1.showStatus();
      car2.showStatus();
      
      
      car1.showStatus();
      
      car1.changeGear('D');
      car1.accelerate(20);
      car1.accelerate(40);
      car1.breaker(5);
   }

}