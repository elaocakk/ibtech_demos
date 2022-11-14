package task1.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import task1.cmd.CommandExecuter;
import task1.model.Account;
import task1.model.Address;
import task1.model.Command;
import task1.model.Customer;
import task1.model.Phone;
import task1.util.HibernateUtil;

public class CommandDao {
	
//	public Command runCommands() {
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			try {
//				transaction = session.beginTransaction();
//				transaction.commit();
//				
//				CommandExecuter cmdExecuter = new CommandExecuter();
//				
//				List<Command> commands = session.createQuery("FROM Command").list();
//				
//				for (Command commandItem : commands) {
//					
//					cmdExecuter.execute(commandItem);
//					System.out.println("COMMAND NAME: ---> " + commandItem.getCommand_name());					
//					
//				}
//
//			} finally {
//				session.close();
//			}
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public Command getCommand(String commandName) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				transaction.commit();
				List<Command> commands = session.createQuery("FROM Command").list();

				for (Command commandItem : commands) {
					if (commandItem.getCommand_name().equals(commandName)) {
						return commandItem;
					}
				}

			} finally {
				session.close();
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void create(Command command) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(command); // *
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Command> getCommands() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from commands", Command.class).list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void listCommands() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				List commands = session.createQuery("FROM Customer").list();
				
				for (Iterator iterator = commands.iterator(); iterator.hasNext();) {
					Command command = (Command) iterator.next();
					System.out.print("Command name : " + command.getCommand_name());
					System.out.print("\tCommand description : " + command.getCommand_description());
					System.out.print("\tClass name : " + command.getClass_name());
					System.out.println("\tMethod name: " + command.getMethod_name());			
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
	   
	public void update(int customerId, String tckn, String name, String surname) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				Customer customer = (Customer) session.get(Customer.class, customerId);
				customer.setTckn(tckn);
				customer.setName(name);
				customer.setSurname(surname);
				
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

