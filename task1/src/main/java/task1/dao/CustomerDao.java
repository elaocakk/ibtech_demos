package task1.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import task1.model.Account;
import task1.model.Address;
import task1.model.Customer;
import task1.model.Phone;
import task1.util.HibernateUtil;

public class CustomerDao {
	
	public void insert(Customer customer) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(customer); // *
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Customer> getCustomers() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from customer", Customer.class).list();
		}
	}
	
	public void listCustomers() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				List customers = session.createQuery("FROM Customer").list();
				
				for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
					Customer customer = (Customer) iterator.next();
					System.out.print("Id: " + customer.getId());
					System.out.print("TCKN: " + customer.getTckn());
					System.out.print(" Name: " + customer.getName());
					System.out.println(" Surname: " + customer.getSurname());
					System.out.println(" EMail: " + customer.getEmail());
					System.out.println(" Surname: " + customer.getSurname());
					String gender =  ( customer.isGender() == true) ? "Erkek" : "Kadın" ;
					System.out.println(" Gender: " + gender  );
					String statu =  ( customer.isStatuid() == true) ? "Aktif" : "Pasif" ;
					System.out.println(" Statu: " + customer.isStatuid());
				}
				
				transaction.commit();
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	   
	public void update(int customerId, String tckn, String name, String surname, String email, boolean gender, boolean statuid ) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				Customer customer = (Customer) session.get(Customer.class, customerId);
				customer.setTckn(tckn);
				customer.setName(name);
				customer.setSurname(surname);
				customer.setEmail(email);
				customer.setGender(gender);
				customer.setStatuid(statuid);
				session.update(customer);
				transaction.commit();
				
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}
	   
	public void delete(long customerId) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				Customer customer = (Customer) session.get(Customer.class, customerId);
				session.delete(customer);
				transaction.commit();
				
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void deleteNew(int customerId) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				
//				AddresDao addresDao = new AddresDao();
//				List<Addres> addresses = addresDao.getAddresses();
//				for (Addres addres : addresses) {
//					if (addres.getCustomerId() == customerId)
//					{
//						addresDao.delete(addres.getId());
//						//break;
//					}
//				}
//				
////				PhoneDao phoneDao = new PhoneDao();
////				List<Phone> phones = phoneDao.getPhones();
////				for (Phone phone : phones) {
////					if (phone.getCustomerId() == customerId)
////					{
////						phoneDao.delete(phone.getId());
////						//break;
////					}
////				}
//				
//				AccountDao accountDao = new AccountDao();
//				List<Account> accounts = accountDao.getAccounts();
//				for (Account account : accounts) {
//					if (account.getCustomerId() == customerId)
//					{
//						accountDao.delete(account.getId());
//						//break;
//					}
//				}
				
				Customer customer = (Customer) session.get(Customer.class, customerId);
				session.delete(customer);
				transaction.commit();
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}

