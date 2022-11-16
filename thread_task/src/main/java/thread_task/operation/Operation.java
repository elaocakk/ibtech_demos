package thread_task.operation;

import java.util.List;

import thread_task.dao.AccountDao;
import thread_task.dao.BatchDataDao;
import thread_task.model.Account;
import thread_task.model.BatchData;

public class Operation implements Runnable {

	private int startNumber;
	private int endNumber;
	private List<BatchData> batchDataList;
	
	public Operation(int startNumber, int endNumber, List<BatchData> batchDataList) {
		super();
		this.startNumber = startNumber;
		this.endNumber = endNumber;
		this.batchDataList = batchDataList;
	}
	
	@Override
	public void run() {
		// batch data listesinden start ile end arasındakileri getir diyoryz 
		
		BatchDataDao batchDataDao = new BatchDataDao();
		AccountDao accountDao = new AccountDao();

		for (int i = startNumber; i < endNumber; i++) {
			
			BatchData batchData = batchDataList.get(i);
			Account account = accountDao.getAccount(batchData.getAccountno());
				
			if(batchData.getAccountno() == account.getId()) {	
				
				if(batchData.getTransactiontype() == 'A' ) {
					accountDao.updateAccount(account.getId(), account.getBalance() + batchData.getAmount()); // alacak
				}
				
				if(batchData.getTransactiontype() =='B' ) {
					accountDao.updateAccount(account.getId(), account.getBalance() - batchData.getAmount()); // borç
				}
				
				batchDataDao.updateStatus(batchData.getID(), true);

			}

			System.out.println("--> " + i + ". batch data yapıldı -->> " + Thread.currentThread().getName());
			
		}	
		
		
	}

	
	
	

	
	
}
