package lambda_demo;

public class LambdaExample3 {

	public static void main (String[] args) {
		
		LambdaExp3Class lec = new LambdaExp3Class();
		String welcome1 = lec.interfacemethod("Ela");
		System.out.println(welcome1);
		
		System.out.println("-----------------------");
	
		LambdaExp3Interface lec2 = (name) -> {
			System.out.println("Class call Functional Interface method with lambda exp.");
			String sNew = "Hellooo " + name;
			return sNew;
		};
		String welcome2 = lec2.interfacemethod("Elaa");
		System.out.println(welcome2);
		
	
		System.out.println("-----------------------");
		
		LambdaExp3Interface2 lec3 = (number) -> number*number; 
		int number2 = lec3.interfacemethod2(7);
		System.out.println(number2);
		
	}
}


@FunctionalInterface
interface LambdaExp3Interface {
	
	public String interfacemethod(String s) ;
	
}

@FunctionalInterface
interface LambdaExp3Interface2 {
	
	public int interfacemethod2(int s) ;
	
}

class LambdaExp3Class implements LambdaExp3Interface {

	@Override
	public String interfacemethod(String s ) {
		System.out.println("Class call Functional Interface method with implement");
		String sNew = "Hello " + s;
		return sNew;
	}

}