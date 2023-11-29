package week05.yrchoi.예제4;

public class Ticket {
    protected int number;
    protected double price;

//	public Ticket() {
//		this(0, 0.0);
//	}

	public Ticket(int number) {
		this(number, 0.0);		
	}

	public Ticket(int number, double price) {				
		this.number = number;
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
    public String toString() {
        return "티켓번호: " + this.number + "\n"+"티켓가격: " + this.price;
    }
}
