package reflections_demo;

import java.lang.reflect.Field;

import web.AccountSummary;

public class ObjectSizeCalculator {
    private static final long HEADER_SIZE = 12;
    private static final long REFERENCE_SIZE = 4;
    
    public static long sizeOfObject(Object input) {
    	Field[] fields = input.getClass().getDeclaredFields();
    	long sizeAccountSummary = HEADER_SIZE  + REFERENCE_SIZE ;
    	long fieldSize = 0 ;
    	
    	for(int i=0 ; i < fields.length ; i ++ ) { 
    		Field field = fields[i];
			field.setAccessible(true);
			
    		if ( field.getType().isPrimitive() ) {
    			fieldSize = sizeOfPrimitiveType(field.getType());
    		} else if (field.getType().equals(String.class)) {
    			fieldSize = sizeOfString(field.toString());
    		}
    		sizeAccountSummary = sizeAccountSummary + fieldSize ;
    	}    	
		return  sizeAccountSummary ;        
    }    
     
    private static long sizeOfPrimitiveType(Class<?> primitiveType) {
        if (primitiveType.equals(int.class)) {
            return 4;
        } else if (primitiveType.equals(long.class)) {
            return 8;
        } else if (primitiveType.equals(float.class)) {
            return 4;
        } else if (primitiveType.equals(double.class)) {
            return 8;
        } else if (primitiveType.equals(byte.class)) {
            return 1;
        } else if (primitiveType.equals(short.class)) {
            return 2;
        }
        throw new IllegalArgumentException(String.format("Type: %s is not supported", primitiveType));
    }
    
    private static long sizeOfString(String inputString) {
        int stringBytesSize = inputString.getBytes().length;
        return HEADER_SIZE + REFERENCE_SIZE + stringBytesSize;
    }  
 
    public static void main(String[] args) {    	
    	
    	AccountSummary ac = new AccountSummary("Ela","ocak",(short) 24,1);
    	long objectSize = 0;
		try {
			objectSize = ObjectSizeCalculator.sizeOfObject(ac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println(objectSize);
    	
    }
    
}