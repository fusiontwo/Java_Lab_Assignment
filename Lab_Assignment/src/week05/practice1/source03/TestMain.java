package week05.practice1.source03;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Ticket ticket1 = new Ticket(1, 1000);
//		System.out.println(ticket1);
//		ticket1.setPrice(2000);
//		System.out.println(ticket1);

//		GeneralTicket t1 = new GeneralTicket(1,5000.0,false);
//		GeneralTicket t2 = new GeneralTicket(2,2000.0,true);
//		System.out.println(t1);
//		System.out.println(t2);
		
		AdvanceTicket t1 = new AdvanceTicket(1,1000.0,32);
		AdvanceTicket t2 = new AdvanceTicket(2,1000.0,15);
		System.out.println(t1);
		System.out.println(t2);

	}

}
