package collections_demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;

class Temp {
	
	public String toString () {
		return "temp";
	}
	
	public void finalize() {
		System.out.println("finalize!!!");
	}
		
}


public class HashSetDemo {

	public static void main(String[] args) throws InterruptedException {
	
		HashSet hs = new HashSet(); // size = 16
		
		HashSet hs1 = new HashSet(100);
		
		HashSet hs2 = new HashSet(100,.80f); // %80 i dolunca yeni size = 100 * 2
		
		ArrayList al = new ArrayList();
		HashSet hs3 = new HashSet(al);

		
		System.out.println("-----------------");
		
		LinkedHashSet lhs = new LinkedHashSet(); // size = 16
		LinkedHashSet lhs1 = new LinkedHashSet(30);
		LinkedHashSet lhs2 = new LinkedHashSet(30, 1.00f); // %100 ü dolunca yeni size = 30 *2
		
		
		System.out.println("-----------------");
		
		SortedSet ss = new TreeSet();
		ss.add(1);
		ss.add(3);
		ss.add(7);
		ss.add(12);
		ss.add(6);
		ss.add(4);
		ss.add(10);
		
		System.out.println(ss);
		System.out.println(ss.first());
		System.out.println(ss.last());
		System.out.println(ss.headSet(6));
		System.out.println(ss.tailSet(4));
		System.out.println(ss.subSet(4,10));
		System.out.println(ss.comparator());
		
		System.out.println("-----------------");
		
		NavigableSet <Integer> ns = new TreeSet <Integer>();
		ns.add(100);
		ns.add(300);
		ns.add(700);
		ns.add(1200);
		ns.add(600);
		
		System.out.println(ns);
		
		System.out.println(ns.floor(500));
		System.out.println(ns.lower(300));
		System.out.println(ns.ceiling(600));
		System.out.println(ns.higher(700));
		System.out.println(ns.pollFirst()); // elemanı remove ediyor
		System.out.println(ns.pollLast());  // elemanı remove ediyor
		System.out.println(ns.descendingSet());

		System.out.println("-----------------");
		
		TreeSet ts = new TreeSet();
//		TreeSet ts2 = new TreeSet(Comparator c);		
		SortedSet stEx = new TreeSet();
		TreeSet ts3 = new TreeSet(stEx);
		
		HashSet hsEx = new HashSet();
		TreeSet ts4 = new TreeSet(hsEx);
		
		TreeSet<Integer> ts5 = new TreeSet<Integer> (); // sadece integer
		
		System.out.println("-----------------");
		
		PriorityQueue pq = new PriorityQueue() ; // defalut size = 11
		PriorityQueue pq2 = new PriorityQueue(20) ;
//		PriorityQueue pq3 = new PriorityQueue(int initialCapacity, Comparator c) ;
		SortedSet s = new TreeSet();
		PriorityQueue pq4 = new PriorityQueue(s) ;
		
		List list = new ArrayList();
		PriorityQueue pq5 = new PriorityQueue(list) ;
		
		System.out.println("-----------------");
		
		HashMap hm = new HashMap(); // default size = 16
		Map m1 = new HashMap();
		
		HashMap hm2 = new HashMap(20);
		HashMap hm3 = new HashMap(20,.80f); // load factor = % 80
		HashMap hm4 = new HashMap(m1);
		
		HashMap <String,Integer> hm5 = new HashMap<String,Integer>();
		
		hm5.put("First", 1);
		hm5.put("Second", 2);
		hm5.put("Third", 3);
		
		System.out.println(hm5);
		System.out.println(hm5.get("Second"));
		System.out.println(hm5.keySet());
		System.out.println(hm5.entrySet());
		System.out.println(hm5.values());		
		
		System.out.println("-----------------");

		HashMap <Integer,String> hmis = new HashMap <>(); // default size = 16
		hmis.put(10,"First");
		hmis.put(10,"Second");
		
		System.out.println(hmis);
		
		IdentityHashMap <Integer,String> idmis = new IdentityHashMap<>();
		Integer a1 = new Integer(10); //referansları farklı
		Integer a2 = new Integer(10);
//		idmis.put(10,"First");
//		idmis.put(10,"Second");
		idmis.put(a1,"First");
		idmis.put(a2,"Second");
		System.out.println(idmis);
		
		System.out.println("-----------------");
		
		HashMap hmt = new HashMap(); // default size = 16
		Temp t = new Temp();
		hmt.put(t, "element");
		System.out.println(hmt);
		
		t = null;
		System.gc(); // GCM call
		Thread.sleep(3000);
		
		System.out.println(hmt); // hala temp key olarak duruyor
		
		WeakHashMap hmt2 = new WeakHashMap();
		Temp t2 = new Temp();
		hmt2.put(t2, "element");
		System.out.println(hmt2);
		
		t2 = null;
		System.gc(); // GCM call
		Thread.sleep(3000);
		
		System.out.println(hmt2); // temp key olarak durmuyor
		
		
		System.out.println("-----------------");
		
		TreeMap tm = new TreeMap();
//		TreeMap tm2 = new TreeMap(Comparator c);
		SortedMap sm = new TreeMap();
		TreeMap tm3 = new TreeMap(sm);
		
		Map m11 = new HashMap();
		TreeMap tm4 = new TreeMap(m11);
		
		tm.put(1,"");
		tm.put(2,"");
		tm.put(2,"test");
		tm.put(3,"test2");
		
		System.out.println(tm);
		
		
	}

}
