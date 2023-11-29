package week06.practice1;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Refrigerator rfg1 = new Refrigerator("건국냉장고", 3);
//		rfg1.menu();
//		System.out.println("=============");
//		TV tv = new TV("건국TV", 15);
//		tv.menu();
//		System.out.println("=============");
//		Vacuum vacuum = new Vacuum("건국청소기", 15);
//		vacuum.menu();
		
		Home home = new Home(4);
		home.buyHA(new Refrigerator("건국냉장고1", 3));
		home.buyHA(new Refrigerator("건국냉장고2", 3));
		home.buyHA(new Refrigerator("건국냉장고3", 3));
		home.buyHA(new Refrigerator("건국냉장고4", 3));
		home.buyHA(new Refrigerator("건국냉장고5", 3));
		
		home.open();
		
	}

}
