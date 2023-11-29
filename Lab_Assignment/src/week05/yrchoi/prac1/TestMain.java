package week05.yrchoi.prac1;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acc1 = new BankAccount("홍길동", 1000);
		BankAccount acc2 = new BankAccount("고길동");
		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println("========================");
		acc1.deposit(1000);
		acc1.withdraw(3000);  // 잔액이 부족해서 출금이 되지 않음.
		System.out.println(acc1);
		acc1.transfer(acc2,  1000);
		System.out.println("========================");
		System.out.println(acc1);
		System.out.println(acc2);
	}
}
