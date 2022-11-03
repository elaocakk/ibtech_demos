package lambda_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaWithCollectionsDemo {

	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		
		// liste asc sıralanıyor	
//		System.out.println(list);
		
//		Collections.sort(list); // liste asc sıralanıyor		
//		System.out.println(list);
//		
		System.out.println("--------------------");
		
		// liste desc sıralanıyor	
//		Collections.sort(list,new Democomparator()); 
		
		// liste desc sıralanıyor	
		Collections.sort(list, 
				(o1,o2) -> 
				{
					if (o1 > o2) {
						return -1;
					}
					if (o1 < o2) {
						return 1;
					}	
					return 0;
						
				} ); 
		
		System.out.println(list);
		
	}

}


class Democomparator implements Comparator<Integer> {
	
	@Override
	public int compare(Integer o1, Integer o2) {
		
		if (o1 > o2) {
			return -1;
		}
		if (o1 < o2) {
			return 1;
		}
		
		return 0;
	}
	
}
