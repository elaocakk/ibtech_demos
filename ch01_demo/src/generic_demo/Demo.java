package generic_demo;

public class Demo {

	public static void main(String[] args) {
		
		Data<String> d1 = new Data<>("This is d1");		
		System.out.println(d1.toString());		
		
		Data<Integer> d2 = new Data<>(7);
		System.out.println(d2.toString());
		
		IData<String> d3 = new Data<>("Generate Implements");
		System.out.println(d3.getData());
		
		Data<String> d4 = new Data<>("d4 data");
		DataBase<String> b1 = d4 ;
		
	}
	
}
