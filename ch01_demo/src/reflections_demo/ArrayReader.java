package reflections_demo;

import java.lang.reflect.Array;

public class ArrayReader {
	    
    public static Object getArrayElement(Object array, int index) {
       if(index < 0) {
        	index = Array.getLength(array) + index;
        	getArrayElement(array, index);
        }	        
        return Array.get(array, index);        
    }
	
	public static void main(String[] args) {
		
		int [] input = new int[] {0, 10, 20, 30, 40};
		Object obj1 = getArrayElement(input,3);
		System.out.println(obj1);
		
		String[] names = new String[] {"John", "Michael", "Joe", "David"};
		Object obj2 = getArrayElement(names,-1);
		System.out.println(obj2);
	}

}
