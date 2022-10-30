package collections_demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class HashSetDemo {

	public static void main(String[] args) {
	
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
		
		
	}

}
