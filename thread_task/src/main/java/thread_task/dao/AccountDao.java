package thread_task.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import thread_task.model.Account;
import thread_task.util.HibernateUtil;

public class AccountDao {

	public List<Account> getAccountList () {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Account", Account.class).getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void listAccounts() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				List customers = session.createQuery("FROM Account").getResultList();
				for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
					Account account = (Account) iterator.next();
					System.out.print("Id: " + account.getId());
					System.out.print(" Customer Id: " + account.getCustomerId());
					System.out.print(" Account Number: " + account.getAccountNumber());
					System.out.println(" Balance: " + account.getBalance());
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
	  

	public Account getAccount(int accountID) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Account account = (Account) session.get(Account.class, accountID);
			return account;
		}
	}	
	
	public void updateAccount(int accountID, int balance) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				Account account = (Account) session.get(Account.class, accountID);
				account.setBalance(balance);
				session.update(account);
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
	   
	
}
