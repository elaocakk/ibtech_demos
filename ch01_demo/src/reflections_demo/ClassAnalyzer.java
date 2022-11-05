package reflections_demo;

import java.util.*;

public class ClassAnalyzer {
    private static final List<String> JDK_PACKAGE_PREFIXES =
                Arrays.asList("com.sun.", "java", "javax", "jdk", "org.w3c", "org.xml");
                
    public static PopupTypeInfo createPopupTypeInfoFromClass(Class<?> inputClass) {
        PopupTypeInfo popupTypeInfo = new PopupTypeInfo();
        
        /** Complete the Code **/       
        
        popupTypeInfo.setPrimitive( isPrimitive(inputClass))
            .setInterface(isInterface(inputClass))
            .setEnum(isEnum(inputClass))
            .setName(getName(inputClass))
            .setJdk(isJdkClass(inputClass))
            .addAllInheritedClassNames(getAllInheritedClassNames(inputClass));
        
        return popupTypeInfo;
    }
    
    private static String getName(Class<?> inputClass) {
		return inputClass.getSimpleName();
	}

	private static boolean isInterface(Class<?> inputClass) {
		return inputClass.isInterface();
	}

	private static boolean isEnum(Class<?> inputClass) {
		return inputClass.isEnum();
	}

	private static boolean isPrimitive(Class<?> inputClass) {		
		return inputClass.isPrimitive();
	}

	/*********** Helper Methods ***************/
    
    public static boolean isJdkClass(Class<?> inputClass) {
        return JDK_PACKAGE_PREFIXES.contains(inputClass.getPackage());
    }
    
    public static String[] getAllInheritedClassNames(Class<?> inputClass) {
		
    	Class<?>[] interfaceList = inputClass.getInterfaces(); // tüm interfacelerin listesi çekiliyor
    
    	String[] allInheritedClassNames = new String[interfaceList.length] ;
    	int c = 0;
    	for(Class<?> int1 : interfaceList) {
//    		System.out.println(int1);
    		allInheritedClassNames[c] = int1.getSimpleName();
    		c++;
		}		
    	return allInheritedClassNames;   
    }
    
    
    public static void main (String [] args)  throws ClassNotFoundException {		
				
    	System.out.println("Demo 1: ");
    	Class<?> stringClass = Class.forName("reflections_demo.PopupTypeInfo");
    	PopupTypeInfo popupDemo =  createPopupTypeInfoFromClass(stringClass);
    	System.out.println(popupDemo.toString());
    	
    	System.out.println("-------------");
    	
    	System.out.println("Demo 2:");
    	Map<String,Integer> map1 = new HashMap<>();		
		Class<?> map1Class = map1.getClass();
    	
    	PopupTypeInfo popupDemo2 =  createPopupTypeInfoFromClass(map1Class);
    	System.out.println(popupDemo2.toString());
    
    }
    
}