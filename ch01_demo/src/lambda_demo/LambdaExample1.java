package lambda_demo;

public class LambdaExample1 {

	public static void main (String[] args) {
		
		LambdaExp1Class lec = new LambdaExp1Class();
		lec.interfacemethod();
		
		System.out.println("-----------------------");
	
		LambdaExp1Interface lec2 = () -> {
			System.out.println("Class call Functional Interface method with lambda exp.");
		};
		lec2.interfacemethod();
			
	}
}


@FunctionalInterface
interface LambdaExp1Interface {
	
	public void interfacemethod() ;
	
}


class LambdaExp1Class implements LambdaExp1Interface {

	@Override
	public void interfacemethod() {
		System.out.println("Class call Functional Interface method with implement ");
		
	}

}