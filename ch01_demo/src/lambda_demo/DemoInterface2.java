package lambda_demo;

@FunctionalInterface
public interface DemoInterface2 {

	public void method2() ;
	
	// default 
	default void method3() {
		
	}
	
	// static 
	static void method4() {
		
	}
	
}
