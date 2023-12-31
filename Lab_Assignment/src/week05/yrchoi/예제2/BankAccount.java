package week05.yrchoi.예제2;

public class BankAccount {
	private static int count=0;
	private int accountNumber; 
	private String customerName;
	private double accountBalance;
	
	{
		this.accountNumber = ++count;
	}
	
	private BankAccount(String customerName) {
		//super();
		this(customerName, 0.0);
		//this.customerName = customerName;
	}

	private BankAccount(String customerName, double accountBalance) {
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

	public static int getCount() {
		return count;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public static BankAccount getInstance(String name, double amount) {
		// TODO Auto-generated method stub
		return new BankAccount(name,amount);
	}
	
}
