package week05.yrchoi.예제4;

public class AdvanceTicket extends Ticket {
    private int advanceDays;

    public AdvanceTicket(int number, double price, int advanceDays) {
        super(number, price);
        this.advanceDays = advanceDays;
    }
  
	public int getAdvanceDays() {
		return advanceDays;
	}

	public void setAdvanceDays(int advanceDays) {
		this.advanceDays = advanceDays;
	}
	
    @Override
    public double getPrice() {    	
    	
        if (this.advanceDays >= 30 ) 
        	return super.getPrice() * 0.7;
        else if (this.advanceDays >= 20) 
        	return super.getPrice() * 0.8;
        else if (this.advanceDays >= 10) 
        	return super.getPrice() * 0.9;
        else
        	return super.getPrice();
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"\n예약일: "+this.getAdvanceDays()+"일 전\n결재금액:"+this.getPrice()+"\n";
	}

    
}
