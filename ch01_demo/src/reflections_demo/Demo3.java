package reflections_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void initConfiguration () throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Constructor<ServerConfigurations> constructor = ServerConfigurations.class.getDeclaredConstructor(int.class,String.class);
	
		constructor.setAccessible(true);
		constructor.newInstance(8080,"Demo3");
	
	}

}
