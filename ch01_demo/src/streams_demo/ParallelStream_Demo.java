package streams_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream_Demo {

	public static void main(String[] args) {
		
		long time1, time2 ;
		long time11, time22 ;
		
		List<Employee> list = new ArrayList<Employee>();
		
		for(int i = 0 ; i < 100 ; i ++) {
			list.add(new Employee("Ela",10000));
			list.add(new Employee("Doğu",2000));
			list.add(new Employee("Elif",3000));
			list.add(new Employee("Nazo",400));
			list.add(new Employee("Atila",50000));
		}
		
		// Sequential processing
		time1 = System.currentTimeMillis();
		System.out.println("Sequential stream count: " + list.stream().filter(i -> i.getSalary() > 3000).count() );
		
		List<Employee> list2 = list.stream().filter(i -> i.getSalary() > 2000).collect(Collectors.toList());
//		for (Employee e: list2)
//			System.out.println(e.getEmployeeInfo());		
		
		time2 = System.currentTimeMillis();
		System.out.println("Sequential stream time : " + ( time2 - time1) );
		
		System.out.println("------------------------------");
				
		// Parallel processing 
		time11 = System.currentTimeMillis();
		System.out.println("Parallel stream count: " + list.parallelStream().filter(i -> i.getSalary() > 3000).count() );
		
		List<Employee> list3 = list.parallelStream().filter(i -> i.getSalary() > 2000).collect(Collectors.toList());
//		for (Employee e: list3)
//			System.out.println(e.getEmployeeInfo());	
	
		time22 = System.currentTimeMillis();
		System.out.println("Parallel stream time : " + ( time22 - time11) );
		
		
	}

}
