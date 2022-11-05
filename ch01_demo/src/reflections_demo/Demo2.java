package reflections_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo2 {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
		
//		printConstructorData(Person.class);
		
		Person per =  createInstanceWithArguments(Person.class);
		System.out.println(per);
		Address adr = new Address("Gebze",2);
		Person per2 =  createInstanceWithArguments(Person.class, "Elif",16,adr);
		System.out.println(per2);
	}
	
	public static <T> T createInstanceWithArguments (Class<T> classes, Object ... args) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
		
		for (Constructor<?> constructor : classes.getDeclaredConstructors()) {
			if(constructor.getParameterTypes().length == args.length)
				return (T) constructor.newInstance(args);				
		}
		
		return null;
	}
	
	public static void printConstructorData (Class<?> classes) {
		
		Constructor<?>[] constList = classes.getDeclaredConstructors();
		
		System.out.println(String.format("class name : %s \n count of const. : %s ", classes.getSimpleName(),constList.length));
		
		for(int i=0; i < constList.length ; i++) {
			Class<?>[] parameterTypes = constList[i].getParameterTypes();
			
			List<String> parameterTypesName = Arrays.stream(parameterTypes)
					.map(type -> type.getSimpleName()).collect(Collectors.toList());
			
			// burada pre defined fonk. kullanılıyor - lambda using !!
			// stream() da map() fonk.unu için Function(I) kullanılıyordu
//			Function<Class<?>,String> fnc1 = t -> t.getSimpleName() ;
//			String simplename = fnc1.apply(String.class);
	
			System.out.println(parameterTypesName);
			
		}		
		
	}
	
	
	public static class Person {
		private Address addres;
		private String name;
		private int age;
		
		public Person(String name, int age, Address addres) {
			super();
			this.name = name;
			this.age = age;
			this.addres = addres;
		}

		@Override
		public String toString() {
			return "Person [addres=" + addres + ", name=" + name + ", age=" + age + "]";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}		
		
	}	
	
	public static class Address {
		private String street;
		private int number;
				
		public Address(String street, int number) {
			super();
			this.street = street;
			this.number = number;
		}
		
		@Override
		public String toString() {
			return "Address [street=" + street + ", number=" + number + "]";
		}

		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		
	}
	
	
	
	

}
