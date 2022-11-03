package lambda_demo;

public class Lambda_Demo {
	
	public static void main (String [] args) {	
		
	}
	

	// type 1 	
	public void myName() {
		System.out.println("Ela");
	}
	
//	() -> {
//		System.out.println("Ela");
//	 }
     
//	() -> System.out.println("Ela");

	
	// type 2
	public void add(int a, int b  ) {
		System.out.println(a+b);
	}
	 
//	( a,  b  ) -> {
//		System.out.println(a+b);
//	}
	
//   (a, b  ) -> System.out.println(a+b);
	
	 
	// type 2
	public int addTo(int a, int b  ) {
		 return (a+b);
	}
	
//	( a,  b  ) -> {
//		 return (a+b);
//	}
	
//	( a,  b  ) -> (a+b);

	
	
	

}
