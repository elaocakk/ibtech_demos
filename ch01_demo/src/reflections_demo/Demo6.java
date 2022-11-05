package reflections_demo;

import java.lang.reflect.Array;

public class Demo6 {

	public static void inspectArrayObject(Object arrayObject) {
		
		Class<?> objClass = arrayObject.getClass();
		System.out.println("object is array : " + objClass.isArray());		
		
		Class<?> arrayComponentType = objClass.getComponentType();
		System.out.println("array component type is : " + arrayComponentType.getTypeName());		
		
	}	
	
	
	public static void inspectArrayValues(Object arrayObject) {
		int arrLength = Array.getLength(arrayObject);
		
		System.out.print("[");	
		
		for (int i = 0 ; i < arrLength ; i ++)  {
			Object element =  Array.get(arrayObject,i);
			
			if (element.getClass().isArray()) { // çok boyutlu dizilerde hat olmasın diye eklendi burası
				inspectArrayValues(element);
			} else {			
				System.out.print(element);	
			}
			
			if( i != arrLength - 1) {
				System.out.print(",");
			}			
		}
		
		System.out.print("]");			
	}
	
	public static void main (String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException {
	
		int [] array1 = { 1,2};
		inspectArrayObject(array1) ;
		System.out.println();
		
		int [] array2 = { 1,2,5,7,3,5,1,8,7};
		inspectArrayValues(array2);
		System.out.println();
		
		int [][] array3 = { {1,2,5},{7,4,6,}};
		inspectArrayValues(array3) ;
		
	}
	
}
