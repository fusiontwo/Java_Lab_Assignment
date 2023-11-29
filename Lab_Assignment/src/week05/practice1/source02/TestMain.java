package week05.practice1.source02;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankManager bank1 = new BankManager("건국은행", 10);
		BankManager bank2 = new BankManager("대학은행", 20);
		
		System.out.println("========건국은행========");
		bank1.createAccount();
//		bank1.createAccount();
//		bank1.deposit();
//		bank1.withdraw();
//		bank1.transfer();
		System.out.println(bank1);
		
		System.out.println("========대학 은행========");
		bank2.createAccount();
		System.out.println(bank2);
		
		
//		BankAccount acc1 = new BankAccount("홍길동", 1000);
//		BankAccount acc2 = new BankAccount("고길동");
//		System.out.println(acc1);
//		System.out.println(acc2);
//		System.out.println("=======================");
//		acc1.deposit(1000);
//		acc1.withdraw(3000);
//		System.out.println(acc1);
//		acc1.transfer(acc2, 1000);
//		System.out.println("=======================");
//		System.out.println(acc1);
//		System.out.println(acc2);
	}

}
