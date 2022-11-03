package lambda_demo;

public class LambdaExample4 {

	public static void main (String[] args) {
		
		LambdaExp4Class lec = new LambdaExp4Class();
		int number1 = lec.interfacemethod(4);
		System.out.println(number1);
		
		System.out.println("-----------------------");
	
		LambdaExp4Interface lec2 = (val) -> {
			System.out.println("Class call Functional Interface method with lambda exp.");
			int valNew = val * val * val ;
			return valNew;
		};
		int number2 = lec2.interfacemethod(7);
		System.out.println(number2);	
		
	}
}


@FunctionalInterface
interface LambdaExp4Interface {
	
	public int interfacemethod(int i) ;
	
}


class LambdaExp4Class implements LambdaExp4Interface {

	@Override
	public int interfacemethod(int i) {
		System.out.println("Class call Functional Interface method with implement");
		int iNew = i * i * i ;
		return iNew;
	}

}