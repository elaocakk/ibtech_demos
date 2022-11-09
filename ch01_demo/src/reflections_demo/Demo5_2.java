package reflections_demo;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import web.Person;

public class Demo5_2 {
	
	
	public static String objectToJson(Object instance, int indentSize) throws  IllegalAccessException {
		Field[] fields = instance.getClass().getDeclaredFields();
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(indent(indentSize));
		stringBuilder.append("{");
		stringBuilder.append("\n");
		
		for(int i=0 ; i < fields.length ; i ++ ) {
			
			Field field = fields[i];
			field.setAccessible(true);
			
			if (field.isSynthetic()) {
				continue;
			}
			
			stringBuilder.append(indent(indentSize + 1));
			stringBuilder.append(formatStringValue(field.getName()));
			stringBuilder.append(":");
			
			if ( field.getType().isPrimitive() ) {
				stringBuilder.append(formatPrimitiveValue(field.get(instance),field.getType()));
			} else if ( field.getType().equals(String.class) ) {
				stringBuilder.append(formatStringValue(field.get(instance).toString()));
			} else if ( field.getType().isArray() ) {
				stringBuilder.append(arrayToJson(field.get(instance),indentSize + 1 ));
			} else {
				stringBuilder.append(objectToJson(field.get(instance), indentSize + 1));
			}
			
			if (i!= fields.length - 1 )  {
				stringBuilder.append(",");
			}	
			stringBuilder.append("\n");
			
		}
		stringBuilder.append("}");
		return stringBuilder.toString();
	}
	
	private static Object arrayToJson(Object arrayObject, int indentSize) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder stringBuilder = new StringBuilder();
		int arrayLenght = Array.getLength(arrayObject);
		
		Class<?> componentType = arrayObject.getClass().getComponentType();
		stringBuilder.append("{");
		stringBuilder.append("\n");
		
		for(int i=0 ; i < arrayLenght ; i ++ ) {
			Object element = Array.get(arrayObject, i) ;
			
			if ( componentType.isPrimitive() ) {
				stringBuilder.append(indent(indentSize + 1));
				stringBuilder.append(formatPrimitiveValue(element,componentType));
			} else if ( componentType.equals(String.class) ) {
				stringBuilder.append(indent(indentSize + 1));
				stringBuilder.append(formatStringValue(element.toString()));
			} else {
				stringBuilder.append(objectToJson(element, indentSize + 1));
			}
			
			if (i!= arrayLenght - 1 )  {
				stringBuilder.append(",");
			}				
			stringBuilder.append("\n");
		}
				
		stringBuilder.append("}");
		stringBuilder.append(indent(indentSize));
		
		return stringBuilder.toString();
	}

	private static  String formatStringValue(String value) {
		return String.format("\"%s\"",value);
	}
	
	private static  String formatPrimitiveValue(Object parentInstace, Class<?> type ) throws IllegalArgumentException, IllegalAccessException {
		
		if ( type.equals(boolean.class) || type.equals(short.class) || type.equals(int.class)
			 || type.equals(long.class) )
		{
			return parentInstace.toString();			
		}
		else if ( type.equals(float.class) || type.equals(double.class) )
		{
			return String.format("%.02f",parentInstace);	
		}
		 
		throw new RuntimeException(String.format("type %s is not supported",type.getName()));
	}
	
	private static String indent (int indentSize) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0; i < indentSize ; i ++ ) {
			stringBuilder.append("\t");
		}
		return stringBuilder.toString();
	}
	
	public static void main (String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException {
		
//		Class<?> personClass = Person.class;
//		personClass.getClass().getDeclaredConstructor().setAccessible(true);
				
		Person person = new Person("Ela",true,24,14.f);	
		String json = 	objectToJson(person,0);
		
		System.out.println(json);
	}

	
	
}