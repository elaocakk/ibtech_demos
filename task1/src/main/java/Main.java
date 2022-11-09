
import task1.dao.AccountDao;
import task1.dao.AddressDao;
import task1.dao.CustomerDao;
import task1.dao.PhoneDao;
import task1.model.Account;
import task1.model.Address;
import task1.model.Customer;
import task1.model.Phone;

public class Main {

	public static void main(String[] args) {

		// **
		CustomerDao customerDao = new CustomerDao();
		Customer customer = new Customer("123456789", "ela","ocak");

		AddressDao addressDao = new AddressDao();
		AccountDao accountDao = new AccountDao();
		PhoneDao phoneDao = new PhoneDao();
		
		// ** insert customer
//		customerDao.create(customer);
		
		// ** update customer
//      	customerDao.update(customer.getId(),"123456789","elanur", "ocak");
		
		// ** delete customer		
//      	customerDao.deleteNew(customer.getId());
      	
		// ** list customer
//      	System.out.println(customerDao.getCustomers());
		
//		for (Customer cus : customerDao.getCustomers()) {
//			System.out.println("Customer id:" + cus.getId());
//		}
		
		customerDao.listCustomers();
		
		//--------------------
		
		// ** insert address
		Address address = new Address(customer.getId(),"gebze/kocaeli","8","1","kocaeli");
//		addressDao.create(address);
		
		// ** update address
		addressDao.update(customer.getId(),"gebze/kocaeli","2","3","kocaeli");
		// ** delete address
		// ** list address
		
		
		//--------------------
		
		// ** insert account
		// ** update account
		// ** delete account
		// ** list account
		
		//--------------------
		
		// ** insert phone
		// ** update phone
		// ** delete phone
		// ** list phone

		
	}
	

	
	
}
