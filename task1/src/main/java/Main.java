
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

		// insert customer
		CustomerDao customerDao = new CustomerDao();
		Customer customer = new Customer("123456789", "ela","ocak");
		customerDao.insert(customer);
		
		
		
		
	}
	

	
	
}
