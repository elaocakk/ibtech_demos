package collections_demo;

public class ArrayDemo {

	public static void main(String[] args) {

		int[] x = new int[1000];
//		System.out.println(x.getClass().getName());
		
		//Zero as size
		int[] y = new int[0];
		
		//character as size
		int[] z = new int['a'];
		//allowed data types for an int array: byte,short,char and int
		
		//negative array size
//		int[] p = new int[-1];
		
		//size of an int array cannot be more than this:214748364
		int[] q = new int[214748364];
		//214748364*4 memory required to create this array.
		
//		int[] test = new int["ela"]; (( convert hatası veriyor
	
		int [][] multiDemArray = new int [4][] ;
		multiDemArray[0] = new int[2];
		multiDemArray[1] = new int[5];
		multiDemArray[2] = new int[4];
		multiDemArray[3] = new int[3];		
		
		int [][][] multiDemArray2 = new int [3][][] ;
		multiDemArray2[0] = new int[2][];
		multiDemArray2[1] = new int[4][];
		multiDemArray2[2] = new int[3][];
		
		multiDemArray2[0][0] = new int[7];
		multiDemArray2[0][1] = new int[2];
		
		multiDemArray2[1][0] = new int[3];
		multiDemArray2[1][1] = new int[3];
		multiDemArray2[1][2] = new int[3];
		multiDemArray2[1][3] = new int[3];
		
		int[] x1 ;
//		x1 = { 1,2,3 };
		int[] y1 = { 1,2,3,4,5,6,7 };
//		for (int arrayVar : y1 ) {
//			System.out.println(arrayVar);
//		}
		
		int[][] z1 = { {1,2,3,4},{5,6,7} };		
		
		for (int [] z1Arrays : z1 ) {
			for (int z1ArrayVar : z1Arrays ) {
				System.out.println(z1ArrayVar);
			}
		}		
		
		for (int [] z1Arrays : z1 ) {
				System.out.println(z1Arrays); // referans oldukları için adresleri geliyor listede
		}
		
	}

}
