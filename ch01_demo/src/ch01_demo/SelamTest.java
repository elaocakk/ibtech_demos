package ch01_demo;

public class SelamTest {
	
	public static void main(String[] args) {
		
		Selam nesne = new Selam();		
		String cevap = nesne.helloEverybody("Ela");
		System.out.println(cevap);
		
		String cevap2 = nesne.helloEverybody("Eda");
		System.out.println(cevap2);
		
	}
	
	
}
