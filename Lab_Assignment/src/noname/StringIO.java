package noname;

import java.io.IOException;

public class StringIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.err.println("Hello World!");
		
		int keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);

		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode : " + keyCode);
	}

}
