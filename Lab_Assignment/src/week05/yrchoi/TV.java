package week05.yrchoi;

public class TV {
   public boolean power;
   public int channel;
   public int volume;
   
   public TV(boolean power) {
      this(power, 10, 5);
//      this.power = power;
//      this.channel = 10;
//      this.volume = 5;
   }

   public TV(boolean power, int channel) {
      this(power, channel, 7);
//      this.power = power;
//      this.channel = channel;
//      this.volume = 7;
   }
   
   public TV(boolean power, int channel, int volume) {
//      this.power = power;
//      this.channel = channel;
//      this.volume = volume;
   }
   
   public TV() {
      this(false, 5, 20);
   }
   
   public TV(TV tv1) {
      this(tv1.power, tv1.channel, tv1.volume);
   }

   public void showTV() {
      if(power) {
      System.out.println("전원 : "+power);
      System.out.println("채널 : "+channel+" 시청중");
      System.out.println("볼륨 : "+volume);
      } else {
         System.out.println("전원이 꺼져있습니다.");
      }
   }

   public void powerOnOff() {
      power = !power;
   }

   public void channelUP() {
      if(power)
         ++channel;
   }

   public void channDown() {
	   if(power)
		 --channel;
   }
   
   public void volumeUp() {
      if (volume >= 0 && volume < 20)
         ++volume;
   }
   
   public void volumeDown() {
      if (volume > 0 && volume <= 20)
         --volume;
   }
}
