package lambda_demo;

public class LambdaExample5 {

	public static void main (String[] args) {		
		
		LambdaExp5Interface le = () -> {
			System.out.println("hiii");
		};
		le.interfacemethod();
		
	}
	
	// static
	public static void method2 () {				
		System.out.println("helloooğ");
	}
	
	// instance
	public void method3 () {				
		System.out.println("yabuseyoo");
	}
	
}


@FunctionalInterface
interface LambdaExp5Interface {
	
	public void interfacemethod() ;
	
}

class LambdaExample5Clas {
	
	public static void main (String[] args) {		
		
		LambdaExp5Interface le2 = LambdaExample5 :: method2 ;				
		le2.interfacemethod();
		
//		LambdaExp5Interface le3 = LambdaExample5 :: method3 ;				
//		le3.interfacemethod();
		
		LambdaExample5 le4 = new LambdaExample5();
		LambdaExp5Interface lei = le4 :: method3 ;
		lei.interfacemethod();
		
		
		
	}
		
}