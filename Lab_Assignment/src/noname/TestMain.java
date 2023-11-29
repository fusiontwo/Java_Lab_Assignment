package noname;

public class TestMain {

	static final int COFFEE = 100;  // static이 붙은 멤버 변수는 클래스에 대해 메모리에 한 번만 할당된다.
	static final int MILK = 50;
	static final int WATER = 10;
	
	public int getCost(int price, int num) {
		return price*num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//COFFEE=200;
		
		int coffee =5;
		int milk =3;
		int water =1;
		coffee=6;
		
		TestMain test1 = new TestMain();
		TestMain test2 = new TestMain();
		TestMain test3 = new TestMain();
		
		int coffeeCost = test1.getCost(COFFEE, coffee);
		int milkCost = test2.getCost(MILK, milk);
		int waterCost = test3.getCost(WATER, water);
		
		int totalCost = coffeeCost+milkCost+waterCost;
		System.out.println("지불할 총 금액 : "+totalCost);
		
	}

}





