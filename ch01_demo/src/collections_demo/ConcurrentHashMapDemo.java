package collections_demo;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;

public class ConcurrentHashMapDemo extends Thread{

//	static HashMap<Integer,String> chm2 = new HashMap<Integer,String>();  // throws ConcurrentModificationsexception
	static ConcurrentHashMap<Integer,String> chm2 = new ConcurrentHashMap<Integer,String>();
	
	public static void main(String[] args) {	
		
		ConcurrentHashMapDemo chmdThread = new ConcurrentHashMapDemo();
		chm2.put(1,"One");
		chm2.put(2,"Two");
		chm2.put(3,"Three");
		
		Iterator<Entry<Integer, String>> itr = chm2.entrySet().iterator();

		chmdThread.start();
		while (itr.hasNext()) {
			Entry entry =  itr.next();
			System.out.println(entry);		
			System.out.println(entry.getKey());		
			System.out.println(entry.getValue());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
		chm2.put(4,"Four");
		chm2.put(5,"Five");
		chm2.put(6,"Six");
		
		
	}

}
