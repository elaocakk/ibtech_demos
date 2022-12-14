
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import thread_task.dao.AccountDao;
import thread_task.dao.BatchDataDao;
import thread_task.model.Account;
import thread_task.model.BatchData;
import thread_task.model.XBatch;
import thread_task.util.HibernateUtil;

public class Main {

	public static void main(String[] args)
    {
 
		// önce otomatik olarak db ye batch data ekleme
		
		Random r=new Random(); 
	    
		AccountDao accountDao = new AccountDao();
		BatchDataDao batchDataDao = new BatchDataDao();
		
		List<Account> accountList =  accountDao.getAccountList();			
		int siraNo = 0 ;
		for (Iterator iterator = accountList.iterator(); iterator.hasNext();) {
			Account account = (Account) iterator.next();			
			
//			System.out.println("---> account id: " + account.getId());
//			System.out.println("--> account balance:" + account.getBalance());
			
			for (int j = 1; j <= 10 ; j++) { // her account için on adet işlem kaydı yapılıyor 
//				int siraNo = r.nextInt(100) + 1 ; //sira no otomatik atılıyor
				
				int newAccountNo = account.getId() ;
				char newTransactionType = j % 2 == 0 ? 'A' : 'B' ;
				BatchData batchData = new BatchData(siraNo,false, newAccountNo , newTransactionType , (j*j*100) );
				batchDataDao.create(batchData);				
				siraNo ++;
			}
			siraNo ++;
		}
			
		int threadCount = accountList.size();
		int commitCount = 10;
		
		//  static method
		XBatch.execute(threadCount, commitCount);
		
		
    }
	
}
