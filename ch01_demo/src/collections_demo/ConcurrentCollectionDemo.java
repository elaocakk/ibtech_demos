package collections_demo;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentCollectionDemo  extends Thread {

	private static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		
			ConcurrentCollectionDemo ccdThread = new ConcurrentCollectionDemo();
			list.add("Ela");
			list.add("Doğu");
			list.add("Elif");
			list.add("Nazo");

			Iterator itr = list.iterator();
			
			ccdThread.start(); // thread start
			while(itr.hasNext() ) {
				String name = (String) itr.next();
				System.out.println("Name is : " + name);
				
				try {
					Thread.sleep(3000); // 3 sn beklenip öyle çalışıyor, aynı anda da başka thread erişmeye çalıştığı için nesneye ConcurrentModificationsException hatası veriyor !!!!!!
				} 
//				catch (InterruptedException e)		
				catch (Exception e)		
				{
					e.printStackTrace();
				}
				
			}
			
			
	}	
	
	public void run() {
		try {
			Thread.sleep(100); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		list.add("ThreadTest1"); // aynı anda hem yazdırıp hem de listeye bişiler ekleniyor - aynı objelerde farklı threadler !!!!!!!!!!
		list.add("ThreadTest2");
		list.add("ThreadTest3");		
		
	}
	
	

}
