package bptn.ATMAPPLICATION;



class User {
	private double balance;
	private double depositAmount;
	private double withdrawAmount;	
	
	
	
	//getter to retrieve the users current balance
	public double getBalance() {
		return balance;
	}
	
	
	// getter and setter method for deposit
	public double getDepositAmount() {
		return depositAmount;
	}
	
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	// getter and setter methods for withdrawal and update
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}
	
	// setter to update the balance after a withdrawl or deposit
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
}