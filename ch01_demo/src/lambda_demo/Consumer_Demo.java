package lambda_demo;

import java.util.function.Consumer;

public class Consumer_Demo {

	public static void main(String[] args) {
		
		String namesurname = "Elanur Ocak" ;		
		
		sayHi(namesurname);			
		
		System.out.println("------------");
		
		// lambda using 
		Consumer<String> cs = t -> {
			System.out.println("Hello " + t );
		};
		cs.accept(namesurname);
		
	}	
	
	private static void sayHi (String s) {		
		System.out.println("Hello " + s );
	}

}
