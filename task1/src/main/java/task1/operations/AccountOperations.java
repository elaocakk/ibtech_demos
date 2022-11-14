package task1.operations;

import task1.model.Customer;
import task1.bag.Bag;
import task1.dao.AccountDao;
import task1.dao.CustomerDao;
import task1.model.Account;
import task1.model.Address;
import task1.model.Customer;

public class AccountOperations implements CrudOperations {

	private AccountDao accountDao;
	private Customer customer;
	
	public AccountOperations() {
		this.accountDao = new AccountDao();
		this.customer = new Customer();
	}

	@Override
	public Bag add(Bag bag) {
		Account account = new Account(customer.getId(),"gebze",2000);
		accountDao.create(account); 
		return null;
	} 

	@Override
	public Bag update(Bag bag) {
		Account account = new Account(customer.getId(),"gebze",2000);
		accountDao.create(account); 
		accountDao.update(account.getId(),"izmit",1200);
		return null;
	}

	@Override
	public Bag list() {
		accountDao.listAccounts();
		return null;
	}

	@Override
	public Bag delete(Bag bag) {
		Account account = new Account(customer.getId(), "ela",1200);
		accountDao.create(account);
		
		accountDao.delete(account.getId());
		return null;
	}


}
