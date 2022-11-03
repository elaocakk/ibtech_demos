package lambda_demo;

public class LambdaExample2 {

	public static void main (String[] args) {
		
		LambdaExp2Class lec = new LambdaExp2Class();
		lec.interfacemethod(2,3);
		
		System.out.println("-----------------------");
	
		LambdaExp2Interface lec2 = (a,b) -> { // değişkenler var method da 
			System.out.println("Class call Functional Interface method with lambda exp.");
			System.out.println("Sum :" + (a+b));
		};
		lec2.interfacemethod(5,4);
			
	}
}


@FunctionalInterface
interface LambdaExp2Interface {
	
	public void interfacemethod(int a, int b) ;
	
}


class LambdaExp2Class implements LambdaExp2Interface {

	@Override
	public void interfacemethod(int a, int b) {
		System.out.println("Class call Functional Interface method with implement");
		System.out.println("Sum :" + (a+b));
	}

}