package task1.cmd;

import java.lang.reflect.Method;

import task1.bag.Bag;
import task1.model.Command;

public class CommandExecuter {
	
	public static Bag execute(Command command, Bag bag) {
		
		try {
			
			Class<?> c = Class.forName("task1.operations." + command.getClass_name());
			Object obj = c.newInstance();
			Method method;
			Bag dbBag = null ;
			
			if (!bag.getMap().isEmpty()) {
				method = c.getDeclaredMethod(command.getMethod_name(), Bag.class);
				dbBag = (Bag) method.invoke(obj, bag);
				
			} else {
				method = c.getDeclaredMethod(command.getMethod_name());
				dbBag = (Bag) method.invoke(obj);
			}
			
			System.out.println("-> Execute method worked\n\n");
			return dbBag;

		} catch (Exception e) {
			System.out.println("-> Execute method failed\\n\\n");
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
//	public static void execute(Command command) {
//		try {
//			System.out.println("command:" + command);
//			System.out.println("command class:" + command.getClass_name());
//			
//			Class<?> c = Class.forName("task1.operations." + command.getClass_name());
//			Object obj = c.newInstance();
//			
//			for (Method method : c.getMethods()  ) {
//				
//				if (method.getParameterCount() > 0 ) {				
//					method.invoke(obj, null);
//				}
//				else {
//					method.invoke(obj, null);
//				}
//			}			
//			
////			Method method = c.getDeclaredMethod(command.getMethod_name(), null);
////			
////			if (method.getParameterCount() > 0 ) {				
////				method.invoke(obj, null);
////			}
////			else {
////				method.invoke(obj, null);
////			}				
//			
//			System.out.println("CommandExecuter run");
//			System.out.println("");
//			System.out.println("***************************************************************");
//
//		} catch (Exception e) {
//			System.out.println("CommandExecuter failed!");
//			e.printStackTrace();
//		}
//	}
//	
	
	
	
	
	
	
}
