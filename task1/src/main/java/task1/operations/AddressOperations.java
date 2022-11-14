package task1.operations;

import task1.model.Customer;
import task1.bag.Bag;
import task1.dao.AddressDao;
import task1.model.Account;
import task1.model.Address;
import task1.model.Customer;

public class AddressOperations implements CrudOperations {

	private AddressDao addressDao;
	private Customer customer;
	
	public AddressOperations() {
		this.addressDao = new AddressDao();
		this.customer = new Customer();
	}

	@Override
	public Bag add(Bag bag) {
		Address address = new Address(customer.getId(),"izmit","7","7","kocaeli");
		addressDao.create(address); 
		return null;
	} 

	@Override
	public Bag update(Bag bag) {
		Address address = new Address(customer.getId(),"izmit","7","7","kocaeli");
		addressDao.create(address); 
		addressDao.update(address.getId(),"izmit","77","88","kocaeli");
		return null;
	}

	@Override
	public Bag list() {
		addressDao.listAddresses();
		return null;
	}

	@Override
	public Bag delete(Bag bag) {
		Address address = new Address(customer.getId(),"test","7","7","test");
		addressDao.create(address);
		
		addressDao.delete(address.getId());
		return null;
	}



}
