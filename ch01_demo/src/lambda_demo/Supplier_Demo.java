package lambda_demo;

import java.util.function.Supplier;

public class Supplier_Demo {
	public static String namesurname = "Elanur Ocak" ;		
	

	public static void main(String[] args) {
		
		String newString = sayHello();	
		System.out.println(newString);
		System.out.println("------------");
		
		// lambda using 
		Supplier<String> fn = () -> "Hellooo" + namesurname ;	
		String newString2 = fn.get();
		System.out.println(newString2);
		
	}
	
	
	private static String sayHello () {		
		return "Hellooo" + namesurname ;
	}

}
