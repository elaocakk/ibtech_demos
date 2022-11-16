package thread_task.model;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import thread_task.dao.BatchDataDao;
import thread_task.operation.Operation;

public class XBatch {
	
	
	public static void execute(int threadCount, int commitCount) {
		
		BatchDataDao batchDataDao = new BatchDataDao();
		// tüm batch data'ları listele
		List<BatchData> batchDatas = batchDataDao.getList();
		
		// status false olanları listele
		List<BatchData> batchDataProcessesList = batchDatas.stream().filter(x -> !(x.getStatus()) ).collect(Collectors.toList());
		
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		for (int i = 0; i < threadCount; i++) {
			// start number  = (i * commitCount) + 1 -> 0 dan başlıyoruz diye
			// end number  = ( (i+1) * commitCount) -> 0 dan başlıyoruz diye
			Runnable worker = new Operation( (i * commitCount) + 1 , (i + 1) * commitCount, batchDataProcessesList);
			executor.execute(worker);
			
			System.out.println(i + " thread başladı.... ");
		}
		
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("------------------------İŞLEM TAMAMLANDI----------------------------");
		

		
	}
	
	
	
	
	
	
	

}
