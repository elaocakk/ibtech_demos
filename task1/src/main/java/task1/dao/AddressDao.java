package task1.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import task1.model.Address;
import task1.util.HibernateUtil;

public class AddressDao {
	public void create(Address addres) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(addres);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Address> getAddresses() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Addres", Address.class).list();
		}
	}
	
	public void listAddresses() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				List addresses = session.createQuery("FROM Addres").list();
				for (Iterator iterator = addresses.iterator(); iterator.hasNext();) {
					Address addres = (Address) iterator.next();
					System.out.print("Id: " + addres.getId());
					System.out.print(" Customer Id: " + addres.getCustomerId());
					System.out.print(" City: " + addres.getCity());
					System.out.println(" Disctrict: " + addres.getDisctrict());
					System.out.println(" Address: " + addres.getAddress());
					System.out.println(" Apart No: " + addres.getApartno());					
					
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
	   
	public void update(int addresId, String address, String buildno, String apartno, String city,String disctrict) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				Address addres = (Address) session.get(Address.class, addresId);
				addres.setAddress(address);
				addres.setBuildno(buildno);
				addres.setApartno(apartno);
				addres.setCity(city);	
				session.update(addres);
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
	   
	public void delete(int addresId) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			try {
				transaction = session.beginTransaction();
				Address address = (Address) session.get(Address.class, addresId);
				session.delete(address);
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

