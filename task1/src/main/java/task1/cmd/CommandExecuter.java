package task1.cmd;

import java.lang.reflect.Method;

import task1.bag.Bag;
import task1.dao.CommandDao;
import task1.model.Command;

public class CommandExecuter {
	
	public static Bag executeString(String commandString, Bag bag) throws Exception {
		try {
			CommandDao commandDao = new CommandDao();
			Command command = commandDao.getCommand(commandString);
			if (!isValue(command)) {
				throw new Exception("CommandString not found!");
			}

			Class<?> c = Class.forName("com.dbbank.task.operation." + command.getClass_name());
			Object obj = c.newInstance();
			Method method;
			Bag dbBag;
			if (!bag.getMap().isEmpty()) {
				method = c.getDeclaredMethod(command.getMethod_name(), Bag.class);
				dbBag = (Bag) method.invoke(obj, bag);

			} else {
				method = c.getDeclaredMethod(command.getMethod_name());
				dbBag = (Bag) method.invoke(obj);
			}
			System.out.println("-> Execute method runed");
			return dbBag;

		} catch (Exception e) {
			System.out.println("-> Execute method failed");
			e.printStackTrace();
			throw e;
		}
	}

	private static boolean isValue(Command command) {
		if (command == null) {
			System.out.println("*** NOT FOUND ***");
			return false;
		}
		System.out.println("-> Command Information; \n\t" + command.getCommand_name() + "\n\t"
				+ command.getCommand_description() + "\n\t" + command.getClass_name() + "\n\t" + command.getMethod_name());
		return true;
	}
	
	
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
