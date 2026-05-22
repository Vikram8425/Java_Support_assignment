package Fix_defect;

import java.util.Date;

public class LoanAccount {

	Date dueDate;
	double outstandingBalance;
	String accountId;
	
	public LoanAccount(Date dueDate, double outstandingBalance, String accountId) {
		super();
		this.dueDate = dueDate;
		this.outstandingBalance = outstandingBalance;
		this.accountId = accountId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "LoanAccount [dueDate=" + dueDate + ", outstandingBalance=" + outstandingBalance + ", accountId="
				+ accountId + "]";
	}
	
	
	
	
}
