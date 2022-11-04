package streams_demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsDemo1 {

	public static void main (String [] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		System.out.println(list);
		System.out.println("---------------");
		
		ArrayList<Integer> newlist = new ArrayList<Integer>();
		for (Integer i : list) {
			if (i >= 30)
				newlist.add(i);
		}
		
		System.out.println(newlist);
		System.out.println("---------------");
	 // streams
	 // filter
	//	List<Integer> li = list.stream().filter(predicate object) // predicate has only booelan test(T t) method
        Predicate<Integer> pr = (i) -> { 
        	if (i >= 30)
        		return true;
			return false;
        };
		List<Integer> li = list.stream().filter(i -> i >= 30 ).collect(Collectors.toList()) ;
		System.out.println(li);
		System.out.println("---------------");
		
	// map
	// List<Integer> li = list.stream().filter(function object) // function has only R apply(T t) method
		Function<Integer,Integer> fn = (i) -> {
				return i * 2;
        };
		List<Integer> li2 = list.stream().map( i -> i * 2 ).collect(Collectors.toList()) ;
		System.out.println(li2);
		System.out.println("---------------");
		
	//count 
		long cnt =  list.stream().filter(i -> i >= 30 ).count();
		System.out.println(cnt);
		System.out.println("---------------");
		
		
	// default natural sorting - sorted()	
		List<Integer> li3 = list.stream().sorted().collect(Collectors.toList()) ;
		System.out.println(li3);
		System.out.println("---------------");		
		
	// custom sorting - sorted(Comparator c)
		Comparator<Integer> c = (i1,i2) ->{
			if (i1 >= i2)
				return i1;
			return i2;			
		};
		List<Integer> li4 = list.stream().sorted( (i1,i2) -> i2.compareTo(i1) ).collect(Collectors.toList()) ;
		System.out.println(li4);
		System.out.println("---------------");		
		
		
		
	}
	
}
