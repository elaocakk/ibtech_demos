package ch01_demo;

//import java.util.Scanner;

public class SelamTest {
	
	public static double average(int ... numbers) { // deişen paraamere adetli metot
		
		int sum = 0;
		int i = 0;
		for (int x : numbers) {
			sum += x;
			i++;
		}		
		
		return (double)sum/i ;	
	}
	
	
	public static void main(String[] args) {
		
//		Selam nesne = new Selam();		
//		String cevap = nesne.helloEverybody("Ela");
//		System.out.println(cevap);
//		
//		String cevap2 = nesne.helloEverybody("Eda");
//		System.out.println(cevap2);
//		
//		System.out.println("test" + "'");
//		
//		System.out.println("test2" + '\'');
//		
//		System.out.println(); // ctrl + space
//		
//		Selam nesnetest = new Selam();		
//		String cevaptest = nesnetest.helloEverybody("Ela");
//		System.out.println(cevaptest);
//		
//		String cevap2test = nesnetest.helloEverybody("Eda");
//		System.out.println(cevap2test);
		
		 
//		System.out.println("Bir isim giriniz:");
//		Scanner in = new Scanner(System.in);		
//		String yeniIsim = in.nextLine();
//		String cevaptest2 = nesnetest.helloEverybody(yeniIsim);
//		System.out.println(cevaptest2);
		
		// array demo
//	    int [] intArray = new int [5];
//		int i, j;
//	    
//	    for(i=0 ; i < intArray.length ; i++ ) {	    	
//	    	intArray[i] = i*i;	    	
//	    }
//	    
//	    for(j=0 ; j < intArray.length ; j++ ) {
//	    	System.out.println(intArray[j]);	    	
//	    }
//	 	
//	    System.out.println();
//	    // foreach yapısındaki for
//	    for(int z : intArray) {
//	    	System.out.println(z);	    	
//	    }
		
//		çok boyutlu dizi
//	    System.out.println();
//	   

		
		// main metodu IDE ile argüman vererek çaıştırma
//		if (args.length == 2) {
//			String s1 = args[0];
//			String s2 = args[1];
//		}
//		else {
//			System.out.println("hatalııııı!");
//			System.exit(1);
//		}
//		
//	    int leng = args.length;
//	    for (String tmp : args) {
//	    	System.out.println(tmp);
//	    }
			
		
//		double average1 = average(1,2);
//		System.out.println(average1);
//		
//		double average2 = average(1,2,4,6);
//		System.out.println(average2);
		
			
	}
	
}
