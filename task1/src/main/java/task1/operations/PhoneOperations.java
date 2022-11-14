package task1.operations;

import task1.model.Customer;
import task1.model.Phone;
import task1.bag.Bag;
import task1.dao.AddressDao;
import task1.dao.PhoneDao;
import task1.model.Account;
import task1.model.Address;
import task1.model.Customer;

public class PhoneOperations implements CrudOperations {

	private PhoneDao phoneDao;
	private Customer customer;
	
	public PhoneOperations() {
		this.phoneDao = new PhoneDao();
		this.customer = new Customer();
	}

	@Override
	public Bag add(Bag bag) {
		Phone phone = new Phone(customer.getId(),"5380564848");
		phoneDao.create(phone); 
		return null;
	} 

	@Override
	public Bag update(Bag bag) {
		Phone phone = new Phone(customer.getId(),"5380564848");
		phoneDao.create( phone); 
		phoneDao.update( phone.getId(),"5385554847");
		return null;
	}

	@Override
	public Bag list() {
		phoneDao.listPhones();
		return null;
	}

	@Override
	public Bag delete(Bag bag) {
		Phone phone = new Phone(customer.getId(),"5372568497");
		phoneDao.create(phone);		
		phoneDao.delete(phone.getId());
		
		return null;
	}



}
