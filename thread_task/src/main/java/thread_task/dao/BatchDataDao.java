package thread_task.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import thread_task.util.HibernateUtil;
import thread_task.model.BatchData;

public class BatchDataDao {
	
	public void create(BatchData batchData) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(batchData);
			transaction.commit();
			System.out.println("--> BatchData Record: " + batchData.getSirano());
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<BatchData> getList() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from BatchData", BatchData.class).getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void listBatchData() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				List customers = session.createQuery("FROM BatchData", BatchData.class).list();
				
				for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
					BatchData batch = (BatchData) iterator.next();
					System.out.print("sira no" + batch.getSirano());
					System.out.print("\tstatu: " + batch.getStatus());
					System.out.print("\taccount no: " + batch.getAccountno());
					System.out.println("\transaction type: " + batch.getTransactiontype());
					System.out.println("\tamount: " + batch.getAmount());			
				}
				
				transaction.commit();
			} catch (HibernateException e) {
				if (transaction != null)
					transaction.rollback();
				e.printStackTrace();
			} 
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void updateStatus(int batchDataID, boolean status) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				BatchData batchData = (BatchData) session.get(BatchData.class, batchDataID);
				
				System.out.print("BatchData id:" + batchData.getSirano());
				
				batchData.setStatus(status);
				session.update(batchData);
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

