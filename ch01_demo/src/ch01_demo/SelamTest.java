package ch01_demo;

import java.util.Scanner;

public class SelamTest {
	
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
//		System.out.println(cevaptes
		
		// array demo
//	    int [] intArray = new int [5];
		int i, j;
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
	    int [][] intdoubleArray = new int [4][3];    
	    for(i=0 ; i < intdoubleArray.length ; i++ ) {	  
	    	for(j=0 ; j < intdoubleArray[i].length ; j++ ) {	  
	    		intdoubleArray[i][j] = i*j;	    	
	    	}
	    }
	    
	    System.out.println();
    	for(i=0 ; i < intdoubleArray.length ; i++ ) {	  
	    	for(j=0 ; j < intdoubleArray[i].length ; j++ ) {	  
	    		System.out.print(intdoubleArray[i][j]);	    	
	    	}
	    	System.out.println();
    	}
	    
	    
		
	}
	
	
}
