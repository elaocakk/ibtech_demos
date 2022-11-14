package task1.operations;

import task1.bag.Bag;

public interface CrudOperations {

	public Bag add(Bag bag);
	
	public Bag update(Bag bag);
	
	public Bag list();
	
	public Bag delete(Bag bag);

	
}
