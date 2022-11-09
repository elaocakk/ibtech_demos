package hibernate_conn;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.Test;

import net.jtask.hibernate.models.Customer;

public class Main {

	@Test
    public void crud() {
        SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
         
        create(session);
        read(session);
         
        update(session);
        read(session);
         
        delete(session);
        read(session);
         
        session.close();
    }
     
    private void delete(Session session) {
        System.out.println("Deleting mondeo record...");
        Customer mondeo = (Customer) session.get(Customer.class, "mondeo");
         
        session.beginTransaction();
        session.delete(mondeo);
        session.getTransaction().commit();
    }
     
    private void update(Session session) {
        System.out.println("Updating mustang price...");
        Customer mustang = (Customer) session.get(Customer.class, "mustang");
        mustang.setName("mustang");
        mustang.setSurname("test");
         
        session.beginTransaction();
        session.saveOrUpdate(mustang);
        session.getTransaction().commit();
    }
 
    private void create(Session session) {
        System.out.println("Creating Customer records...");
        Customer mustang = new Customer();
        mustang.setName("ela");
        mustang.setSurname("ocak");
         
        Customer mondeo = new Customer();
        mondeo.setName("elif");
        mondeo.setSurname("ocak");
         
        session.beginTransaction();
        session.save(mustang);
        session.save(mondeo);
        session.getTransaction().commit();
    }
     
    private void read(Session session) {
        Query q = session.createQuery("select * from Customer ");
         
        List<Customer> customers = q.list();
         
        System.out.println("Reading Customer records...");
        System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
        for (Customer c : customers) {
            System.out.printf("%-30.30s  %-30.30s%n", c.getName(), c.getSurname());
        }
    }
	
	
	
}
