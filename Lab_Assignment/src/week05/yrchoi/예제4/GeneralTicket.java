package week05.yrchoi.예제4;

public class GeneralTicket extends Ticket {
	private boolean payByCredit;


	public GeneralTicket(int number, boolean payByCredit) {
		this(number, 0.0, payByCredit);
		//this.payByCredit = payByCredit;
	}

	public GeneralTicket(int number, double price, boolean payByCredit) {
		super(number, price);
		this.payByCredit = payByCredit;
	}
	
	public boolean isPayByCredit() {
		return payByCredit;
	}

	public void setPayByCredit(boolean payByCredit) {
		this.payByCredit = payByCredit;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		if(this.isPayByCredit())
			return super.getPrice()*1.1;
		else
			return super.getPrice();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = super.toString();
		str += "\n카드결재 : "+this.isPayByCredit();
		str += "\n결재금액 : "+this.getPrice()+"\n";
		return str;
	}
	
}
