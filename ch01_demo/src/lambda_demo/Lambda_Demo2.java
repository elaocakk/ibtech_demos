package lambda_demo;

public class Lambda_Demo2 {

	public static void main(String[] args) {
		
//		LambdaDemo2Class ldc = new LambdaDemo2Class();
//		ldc.interfaceMethod();
		
		// lambda expression example 
		LambdaDemo2Interface ldi = () -> {
			System.out.println("Lambda implements a functional interface!..");
		} ;
		ldi.interfaceMethod();
		
	}

}

@FunctionalInterface
interface LambdaDemo2Interface {
	
	public void interfaceMethod();
	
}


//class LambdaDemo2Class implements LambdaDemo2Interface {
//
//	@Override
//	public void interfaceMethod() {
//		System.out.println("Class implements a functional interface!..");
//		
//	}
//
//}