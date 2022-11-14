package task1.operations;

import task1.model.Customer;

import java.util.List;

import task1.bag.Bag;
import task1.bag.BagKey;
import task1.dao.CustomerDao;

public class CustomerOperations implements CrudOperations {

	private CustomerDao customerDao;

	public CustomerOperations() {
		this.customerDao = new CustomerDao();
	}

	@Override
	public Bag add(Bag bag) {
		String tckn = (String) bag.getValue(BagKey.TCKN);
		String name = (String) bag.getValue(BagKey.NAME);
		String surname = (String) bag.getValue(BagKey.SURNAME);
		
		Customer customer = new Customer(tckn,name, surname);
		Customer createdCustomer = customerDao.create(customer);		
		
		Bag createdCustomerBag = new Bag();
		createdCustomerBag.put(BagKey.ID, createdCustomer.getId());
		createdCustomerBag.put(BagKey.TCKN, createdCustomer.getTckn());
		createdCustomerBag.put(BagKey.NAME, createdCustomer.getName());
		createdCustomerBag.put(BagKey.SURNAME, createdCustomer.getSurname());
		
		return createdCustomerBag;
	}

	@Override	
	public Bag update(Bag bag) {
		
		int id = (int) bag.getValue(BagKey.ID);
		String tckn = (String) bag.getValue(BagKey.TCKN);
		String name = (String) bag.getValue(BagKey.NAME);
		String surname = (String) bag.getValue(BagKey.SURNAME);	
		
		Customer customer = customerDao.update(id, tckn, name, surname);
		Bag updatedCustomerBag = new Bag();
		updatedCustomerBag.put(BagKey.ID, customer.getId());
		updatedCustomerBag.put(BagKey.TCKN, customer.getTckn());
		updatedCustomerBag.put(BagKey.NAME, customer.getName());
		updatedCustomerBag.put(BagKey.SURNAME, customer.getSurname());
		
		return updatedCustomerBag;
	}

	@Override
	public Bag list() {		
		List<Customer> customers = customerDao.getCustomers();
		Bag bag = new Bag();
		bag.put(BagKey.LIST, customers);
		return bag;
	}

	@Override
	public Bag delete(Bag bag) {
		int id = (int) bag.getValue(BagKey.ID);
		customerDao.delete(id);
		
		Bag deletedCustomerBag = new Bag();
		deletedCustomerBag.put(BagKey.ID, id);
		deletedCustomerBag.put(BagKey.ISSUCCESSFULL, true);
		deletedCustomerBag.put(BagKey.MESSAGE, "Customer Delete Successful!");
		
		return deletedCustomerBag;
	}


}
