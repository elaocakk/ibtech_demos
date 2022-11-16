
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
		Customer customer = new Customer("647575434", "atila","ocak");

		AddressDao addressDao = new AddressDao();
		AccountDao accountDao = new AccountDao();
		PhoneDao phoneDao = new PhoneDao();
		
		// ** insert customer
		customerDao.create(customer);
		
		// ** update customer
//      	customerDao.update(customer.getId(),"123456789","elanur", "ocak");
		
		// ** delete customer		
//      	customerDao.deleteNew(customer.getId());
      	
		// ** list customer
//      	System.out.println(customerDao.getCustomers());
		
//		for (Customer cus : customerDao.getCustomers()) {
//			System.out.println("Customer id:" + cus.getId());
//		}
		
//		customerDao.listCustomers();
		
		//--------------------
		
		 //** insert address
		Address address = new Address(customer.getId(),"gebze","8","1","kocaeli");
		addressDao.create(address);
//		
		// ** update address
//		addressDao.update(address.getId(),"gebze/kocaeli","2","3","kocaeli");
		
		// ** delete address
//		addressDao.delete(address.getId());
		
		// ** list address
//		System.out.println(addressDao.getAddresses());
//		
//		for (Address adr : addressDao.getAddresses()) {
//			System.out.println("Address id:" + adr.getId());
//		}
		
//		addressDao.listAddresses();
		
		//--------------------
		
		// ** insert account
		Account account = new Account(customer.getId(),"09658566",2000);
		accountDao.create(account);
		
		// ** update account
//		accountDao.update(account.getId(),"gebze",1500);
		
		// ** delete account
//		accountDao.delete(account.getId());
		
		// ** list account
//		System.out.println(accountDao.getAccounts());
//		
//		for (Account acc : accountDao.getAccounts()) {
//			System.out.println("Account id:" + acc.getId());
//		}
		
//		accountDao.listAccounts();
		
		//--------------------
		
		// ** insert phone
		Phone phone = new Phone(customer.getId(),"5380564847");
		phoneDao.create(phone);
		
		// ** update phone
//		phoneDao.update(phone.getId(),"5380564848");		
		
		// ** delete phone
//		phoneDao.delete(phone.getId());	
		
		// ** list phone
//		System.out.println(phoneDao.getPhones());
//		
//		for (Phone acc : phoneDao.getPhones()) {
//			System.out.println("Phone id:" + acc.getId());
//		}
		
//		phoneDao.listPhones();
		
		
		
		
		
		
		
	}
	

	
	
}
