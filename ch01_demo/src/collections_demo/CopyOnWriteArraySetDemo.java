package collections_demo;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.ArrayList;
import java.util.Iterator;

public class CopyOnWriteArraySetDemo {

	public static void main(String[] args) {	
		
		CopyOnWriteArraySet<String> cowas = new CopyOnWriteArraySet();
		ArrayList<String> aList = new ArrayList<String>();
		aList.add("One");
		aList.add("Two");
		aList.add("Three");
		aList.add("Three"); // allowed duplicate
		
		Iterator itr1 = aList.iterator();

		while (itr1.hasNext()) {
			String itrValue = (String) itr1.next();
			System.out.println(itrValue);	
			
		}
		
		System.out.println("-------");	
		
		cowas.add("One");
		cowas.add("Two");
		cowas.add("Three");
		cowas.add("Three"); // not allowed duplicate
		
		Iterator itr = cowas.iterator();

		while (itr.hasNext()) {
			String itrValue = (String) itr.next();
			System.out.println(itrValue);	
			
		}
		
		
	}
	
	
}
