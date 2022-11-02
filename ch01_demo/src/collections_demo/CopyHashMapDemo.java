package collections_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyHashMapDemo {

	static ArrayList<String> aList = new ArrayList<String> ();
	static CopyOnWriteArrayList<String> cowaList = new CopyOnWriteArrayList<String> ();
	public static void main(String[] args) {
	
	   aList.add("One");
	   aList.add("Two");
	   aList.add("Three");
		
	   Iterator itr = aList.iterator();
	   
	   while(itr.hasNext()) {
		   String itrValue = (String) itr.next();
	
		   if (itrValue.equals("Three")) {
			   itr.remove();
		   }
	   }
	   
	   System.out.println(aList);
	   System.out.println("--------------------");	   
	   
	   cowaList.add("One");
	   cowaList.add("Two");
	   cowaList.add("Three");
		
	   Iterator itr2 = cowaList.iterator();
	   
	   while(itr2.hasNext()) {
		   String itrValue = (String) itr2.next();
	
		   if (itrValue.equals("Three")) {
//			   itr.remove(); // throws IllegalStateException
		   }
	   }
	   
	   System.out.println(cowaList);
	   
	   
	}

}
