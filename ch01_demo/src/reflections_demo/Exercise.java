package reflections_demo;

import java.util.*;

public class Exercise {
        
    /**
     * Returns all the interfaces that the current input class implements.
     * Note: If the input is an interface itself, the method returns all the interfaces the 
     * input interface extends.
     */
    public static Set<Class<?>> findAllImplementedInterfaces(Class<?> input) {
        Set<Class<?>> allImplementedInterfaces = new HashSet<>();
        
        Class<?>[] inputInterfaces = input.getInterfaces();
        
        for (Class<?> currentInterface : inputInterfaces) {
            allImplementedInterfaces.add(currentInterface);
           
            allImplementedInterfaces.addAll(findAllImplementedInterfaces(currentInterface)); // recursion olmasını burası sağlıyor
        }

        return allImplementedInterfaces;
    }
    
    public static void main (String [] args ) {
    	
    	 List<String> list = new ArrayList<String>();
    	 Class<?> listClass = list.getClass();
    	
    	 Set<Class<?>> listClassInfo = findAllImplementedInterfaces(listClass);    	 
    	 for(Class<?> info : listClassInfo)
    		 System.out.println(info);
    	 
    	 System.out.println("-------------");
    	 
    	 Map<String,Integer> map = new HashMap<>();
    	 Class<?> mapClass = map.getClass();
    	 
    	 Set<Class<?>> mapClassInfo = findAllImplementedInterfaces(mapClass);
    	 for(Class<?> info : mapClassInfo)
    		 System.out.println(info);
    	 
    	 
    }
}