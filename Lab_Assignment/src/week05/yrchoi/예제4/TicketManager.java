package week05.yrchoi.예제4;

public class TicketManager {
	private String name;
	private final int NUMBER;
	private Ticket[] tickets;
	private int count=0;
	
	public void showGeneralTicket(boolean payByCredit) {
		for(Ticket ticket:tickets) {
			if(ticket!=null && ticket instanceof GeneralTicket) {
				GeneralTicket t = (GeneralTicket)ticket;
				if(t.isPayByCredit()==payByCredit) {
					System.out.println(t);
				}
			}
		}
	}
	
	public TicketManager(String name, int NUMBER) {
		super();
		this.name = name;
		this.NUMBER = NUMBER;
		tickets = new Ticket[this.NUMBER];
	}
	
	
	public void register(Ticket ticket) {
		if(this.count < this.NUMBER) {
			this.tickets[this.count++] = ticket;
		}else {
			System.out.println("티켓 판매 완료");
		}
	}
	
	public double getTotal() {
		double total =0.0;
		for(Ticket ticket:tickets) {
			if(ticket!=null) {
				total += ticket.getPrice();
			}else 
				break;			
		}
		return total;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str ="공연명 : "+this.name+"\n";
		str += "좌석수 : "+ this.NUMBER +"\n";
		str += "총 판매티켓 수 : "+ this.count + "\n";
		for(Ticket ticket:tickets) {
			if(ticket!=null) {
				str += ticket.toString();
				str +="\n-------------\n";
			}else
				break;
		}
		str += "총 티켓 판매 금액 : "+this.getTotal()+"\n";
		return str;
	}
	
}
