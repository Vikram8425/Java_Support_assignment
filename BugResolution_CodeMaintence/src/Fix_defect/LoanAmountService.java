package Fix_defect;

import java.util.*;

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

}
