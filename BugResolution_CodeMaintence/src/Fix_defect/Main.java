package Fix_defect;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {

	public static void main(String[] args)  {
		
	//Create List of LoanAccount object
	List<LoanAccount> accounts=new  ArrayList<>();
	//create service class object
	LoanAmountService service=new LoanAmountService();
	
	Calendar cal=Calendar.getInstance();
	//date Overdues
	cal.add(Calendar.DATE, -10);
    Date pastDate = cal.getTime();
    cal.add(Calendar.DATE, -7);
    Date pastDate1 = cal.getTime();
    
    cal.add(Calendar.DATE, -3);
    Date pastDate2 = cal.getTime();
    
    //date not Overdues
    cal.add(Calendar.DATE, +10);
    Date futureDate = cal.getTime();
    		
    //Create sample data
    accounts.add(new LoanAccount(futureDate,5000,"101"));
    accounts.add(new LoanAccount(pastDate,10000,"102"));
    accounts.add(new LoanAccount(pastDate1,80000,"103"));
    accounts.add(null);
    
    /*calling method getOverdueLoans. this method in class LoanAmountService
      this method returns list of LoanAccount of overdues
    */
    List<LoanAccount> overdueLoans = service.getOverdueLoans(accounts);
     
    
    // by using for each loop print data
    
     for(LoanAccount loanAccount:overdueLoans) {
    	 System.out.println("ACCount ID:"+loanAccount.getAccountId()+"\n"+"OverDuesDate:"+loanAccount.dueDate+"\n"+"Balance:"+loanAccount.outstandingBalance+"\n\n");
     }
    
    
	}

}
