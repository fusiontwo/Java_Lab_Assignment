package week05.practice1.source01;

public class BankAccount {
	public static int count=0;
	public int accountNumber; 
	public String customerName;
	public double accountBalance;
	
	{
		this.accountNumber = ++count;
	}
	
	public BankAccount(String customerName) {
		//super();
		this(customerName, 0.0);
		//this.customerName = customerName;
	}

	public BankAccount(String customerName, double accountBalance) {
		//super();
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public void deposit(double amount) {
		this.accountBalance += amount;
	}
	
	public void withdraw(double amount) {
		if(this.accountBalance>=amount) {
			this.accountBalance -= amount;
		}else {
			System.out.println("출금 잔액 부족");
		}
	}
	
	public void transfer(BankAccount account, double amount) {
		if(this.accountBalance>=amount) {
			this.withdraw(amount);
			account.deposit(amount);
		}else {
			System.out.println("출금 잔액 부족");
		}
	}

	@Override
	public String toString() {
		String str = "고객이름 : "+this.customerName;
		str += "\n계좌번호 : " + this.accountNumber;
		str += "\n잔   액 : " + this.accountBalance;				
		return str;
	}

}
