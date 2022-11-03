package lambda_demo;

import java.util.function.Function;

public class Function_Demo {

	public static void main(String[] args) {
		
		String namesurname = "Elanur Ocak" ;		
		
		int result = calcuteStringLength(namesurname);			
		System.out.println(result);
		
		System.out.println("------------");
		
		// lambda using 
		Function<String,Integer> fn = t -> t.length();		
		int length = fn.apply(namesurname);
		System.out.println(length);
		
	}
	
	
	private static int calcuteStringLength (String s) {
		
		return s.length();
	}

}
