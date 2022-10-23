package ch01_demo;

public class SelamTest {
	
	public static void main(String[] args) {
		
		Selam nesne = new Selam();		
		String cevap = nesne.helloEverybody("Ela");
		System.out.println(cevap);
		
		String cevap2 = nesne.helloEverybody("Eda");
		System.out.println(cevap2);
		
		System.out.println("test" + "'");
		
		System.out.println("test2" + '\'');
		
		System.out.println(); // ctrl + space
		
		Selam nesnetest = new Selam();		
		String cevaptest = nesnetest.helloEverybody("Ela");
		System.out.println(cevaptest);
		
		String cevap2test = nesnetest.helloEverybody("Eda");
		System.out.println(cevap2test);
		
	}
	
	
}
