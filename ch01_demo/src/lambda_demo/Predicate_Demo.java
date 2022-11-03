package lambda_demo;

import java.util.function.Predicate;

public class Predicate_Demo {

	public static void main(String[] args) {
		
		int salary = 3000 ;
		
		
		boolean result = salaryCheck(salary);			
		System.out.println(result);
		
		// lambda using 
		Predicate<Integer> pr = (t) -> {
			if ( t >= 4000) 
				return true;
			return false;
		};
		pr.test(salary);
		
	}
	
	
	private static boolean salaryCheck(int slry) {
		if ( slry >= 4000) 
			return true;
		return false;
	}

}
