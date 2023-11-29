package week05.yrchoi.예제4;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TicketManager ticket1 = new TicketManager("아이유 콘서트",100);
		ticket1.register(new Ticket(1,1000));
		ticket1.register(new GeneralTicket(2,2000.0,true));
		ticket1.register(new GeneralTicket(3,3000.0,false));
		ticket1.register(new AdvanceTicket(4,3000.0,35));
		ticket1.register(new GeneralTicket(5,2000.0,true));
		ticket1.register(new AdvanceTicket(6,3000.0,15));
		
		ticket1.showGeneralTicket(true);
		
		//System.out.println(ticket1);
		
//		Ticket ticket1 = new Ticket(1, 1000);
//		System.out.println(ticket1);
//		ticket1.setPrice(2000);
//		System.out.println(ticket1);

//		GeneralTicket t1 = new GeneralTicket(1,5000.0,false);
//		GeneralTicket t2 = new GeneralTicket(2,2000.0,true);
//		System.out.println(t1);
//		System.out.println(t2);
		
//		AdvanceTicket t1 = new AdvanceTicket(1,1000.0,32);
//		AdvanceTicket t2 = new AdvanceTicket(2,1000.0,15);
//		System.out.println(t1);
//		System.out.println(t2);

	}

}
