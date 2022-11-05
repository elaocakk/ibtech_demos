package reflections_demo;

import java.lang.reflect.Field;

public class Demo4 {
	
	public static void main (String [] args) throws IllegalArgumentException, IllegalAccessException {
//		printDeclaredFieldInfo(Movie.class);
		
//		printDeclaredFieldInfo(Movie.MovieStats.class);
//		printDeclaredFieldInfo(Category.class);
		
		Movie mv = new Movie ("Your Name ", 2016, true, Category.ROMANTIC , 77);
		
		printDeclaredFieldInfo(mv.getClass(),mv);
	}

	public static <T> void printDeclaredFieldInfo(Class<? extends T> classes, T instance) throws IllegalArgumentException, IllegalAccessException {
		
		for(Field fi : classes.getDeclaredFields()) {
			System.out.println("field name: " + fi.getName() );
			System.out.println("field type name: " + fi.getType().getName());
			System.out.println("field is synthetic : " + fi.isSynthetic());
			System.out.println("field value : " + fi.get(instance));
			System.out.println();
		}
		
	}
	
	public static class Movie extends Product {
		public static final double MINİMUM_PRICE = 10.99;
		
		private boolean isReleased ;
		private Category category;
		private double actualPrice;
		
		public Movie(String name, int year, boolean isReleased, Category category, double actualPrice) {
			super(name, year);
			this.isReleased = isReleased;
			this.category = category;
			this.actualPrice = actualPrice;
		}
		
		// nested class
		public class MovieStats {
			private double timesWatched ;

			public MovieStats(double timesWatched) {
				this.timesWatched = timesWatched;
			}
			
			public double getRevenue () {
				 return  timesWatched = actualPrice; 
			}
			
			
		}
		
	}
	
	public static class Product {
		protected String name;
		protected int year;
		protected double actualPrice;
		
		public Product(String name, int year) {
			super();
			this.name = name;
			this.year = year;
		}		
		
	}
	
	
	public enum Category {
		ADVENTURE,
		ACTION,
		COMEDY,
		ROMANTIC
	}
}
