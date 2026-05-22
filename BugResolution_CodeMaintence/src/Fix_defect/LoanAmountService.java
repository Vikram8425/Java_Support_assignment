package Fix_defect;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LoanAmountService {
	
	public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
	    List<LoanAccount> result = new ArrayList<>();
	    
	    	
	    
	 
	    for (LoanAccount account : accounts) {
	    	
	    	if(account!=null) {
	    		if (account.getDueDate().before(new Date())) {
		            if (account.getOutstandingBalance() > 0) {
		                result.add(account);
		            }
		        }	
	    		
	    	}
	        
	    }
	    return result;
	}
		// create objetc of AtomicInteger which thread safe in nature 
        private AtomicInteger processedCount=new AtomicInteger(0);
	 
	    public void process(List<StatementRecord> records) throws InterruptedException {
	        ExecutorService executor = Executors.newFixedThreadPool(10);
	 
	        for (StatementRecord record : records) {
	            executor.submit(() -> {
	                processRecord(record);
	                processedCount.incrementAndGet();  // <-- consistent in production
	            });
	        }
	        executor.shutdown();
	        executor.awaitTermination(5, TimeUnit.MINUTES);
	    }
	 
	    public int getProcessedCount() {
	        return processedCount.get();
	    }
	
	
	//In assignment process record method was not written
	private void processRecord(StatementRecord record) {
		
	}
	
}
	



