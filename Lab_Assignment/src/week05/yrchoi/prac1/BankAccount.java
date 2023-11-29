package week05.yrchoi.prac1;

public class BankAccount {
	public static int count = 0;  // 계좌 번호 (static으로 선언 -> 생성되는 모든 객체가 공유하는 변수)
	public int accountNumber;  // 계좌 번호
	public String customerName;  // 고객 이름
	public double accountBalance;  // 잔액
	
	// 인스턴스 초기화 블록
	{
		this.accountNumber = ++count;
	}
	// 생성자 (오버로딩)
	public BankAccount(String customerName) {
//		super();  // Object 클래스의 생성자임. (상속에서 쓰임.)
		this(customerName, 0.0);  // 클래스 안의 다른 생성자를 호출하여 실행문을 수행
//		this.customerName = customerName;
	}
	// 생성자 (오버로딩)
	public BankAccount(String customerName, double accountBalance) {
//		super();  // Object 클래스의 생성자임. (상속에서 쓰임.)
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public void deposit(double amount) {  // 입금
		this.accountBalance += amount;
	}
	
	public void withdraw(double amount) {  // 출금
		if (this.accountBalance >= amount) {
			this.accountBalance -= amount;
		}
		else {
			System.out.println("출금 잔액 부족");
		}
	}
	
	public void transfer(BankAccount account, double amount) {  // 이체
		if(this.accountBalance >= amount) {
			this.withdraw(amount);  // 내 것에서 출금
			account.deposit(amount);  // account에는 입금
		}
		else {
			System.out.println("출금 잔액 부족");
		}
	}
	
	// Source - Override/Implement Methods - toString() 선택
	// 자동 완성 후 원하는 형태로 수정
	@Override  // 부모 클래스(Object 클래스)에서 정의했던 메서드를 재정의했다는 표시
	public String toString() {
		// TODO Auto-generated method stub
		String str = "고객이름 : " + this.customerName;
		str += "\n계좌번호 : " + this.accountNumber;
		str += "\n잔액 : " + this.accountBalance;
		return str;  // 직접 만든 str 문자열을 리턴함.
	}
	
	
}
