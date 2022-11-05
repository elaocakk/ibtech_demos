package reflections_demo;

import java.lang.reflect.Field;

import web.Person;

public class Demo5 {
	
	
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
				stringBuilder.append(formatPrimitiveValue(field,instance));
			} else if ( field.getType().equals(String.class) ) {
				stringBuilder.append(formatStringValue(field.get(instance).toString()));
			}
			
			if (i!= fields.length - 1 )  {
				stringBuilder.append(",");
			}	
			stringBuilder.append("\n");
			
		}
		stringBuilder.append("}");
		return stringBuilder.toString();
	}
	
	private static  String formatStringValue(String value) {
		return String.format("\"%s\"",value);
	}
	
	private static  String formatPrimitiveValue(Field field, Object parentInstace) throws IllegalArgumentException, IllegalAccessException {
		
		if ( field.getType().equals(boolean.class) || field.getType().equals(short.class) || field.getType().equals(int.class)
			 || field.getType().equals(long.class) )
		{
			return field.get(parentInstace).toString();			
		}
		else if ( field.getType().equals(float.class) || field.getType().equals(double.class) )
		{
			return String.format("%.02f",field.get(parentInstace));	
		}
		 
		throw new RuntimeException(String.format("type %s is not supported",field.getType().getName()));
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