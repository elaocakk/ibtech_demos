package reflections_demo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Demo1 {
	
	private static interface Drawable {		
		int getNumberOfCorners();
	}
	
	private static class SquareClass implements Drawable {

		@Override
		public int getNumberOfCorners() {
			return 4;
		}
		
	}
	
	private enum Colors {
		RED,
		GREEN,
		BLUE
	}
	
	private static void printClassesInfo (Class<?> ... classes ) {
		
		for (Class<?> c1: classes) {
			System.out.println("class name : " + c1.getSimpleName());
			System.out.println("class package name : " + c1.getPackageName());			
			
			// interface listesini yazdırma
			Class<?>[] interfaceList = c1.getInterfaces();
			
			for(Class<?> int1 : interfaceList) {
				System.out.println(String.format("class is %s implements : %s", c1.getSimpleName(), int1.getSimpleName())) ;
			}	
			
			
			System.out.println("is array ? " + c1.isArray());	
			System.out.println("is primitive ? " + c1.isPrimitive());	
			System.out.println("is enum ? " + c1.isEnum());	
			System.out.println("is inteface ? " + c1.isInterface());	
			System.out.println("is anonymous class ? " + c1.isAnonymousClass());	
			
			System.out.println("-----");	
			System.out.println();	
		}
		
		
	}
	
	
	public static void main (String [] args)  throws ClassNotFoundException {		
		
		Class<String> stringClass = String.class;
		Map<String,Integer> map1 = new HashMap<>();		
		Class<?> map1Class = map1.getClass();
				
		Class<?> squareClass = Class.forName("reflections_demo.Demo1$SquareClass");
		
		//printClassesInfo(stringClass,map1Class,squareClass);
		
		System.out.println("--------------------");	
		
		// nesne için method un override edilmesi lazım mutlaka !
		var demoObject = new Drawable() 
				{
					@Override
					public int getNumberOfCorners() {
						return 0;
					}
				};
		Class<?> demObjectClass = demoObject.getClass();
		printClassesInfo(Collections.class,int.class, Colors.class, int [][].class, demObjectClass);
		
//		Map<String,Integer> map1 = new HashMap<>();		
//		Class<?> mapClass = map1.getClass();		
//		System.out.println(mapClass);

		
	}

}
