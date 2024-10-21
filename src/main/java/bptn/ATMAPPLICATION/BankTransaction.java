package bptn.ATMAPPLICATION;
 import java.util.Date;

 
 class BankTransaction {
	 //Declare variables
	 private String transactionType;
	 private double amount;
	 private Date date;
	 
	 //Constructor is initialized
	 
	 public BankTransaction (String transactionType,double amount) {
		 this.transactionType = transactionType;
		 this.amount = amount;
		 this.date = new Date(); //date of the transaction
		 
	 }
	 
	 @Override 
	 public String toString() {
		 return date + "-" + transactionType + ": $" + amount;
	 }
	 



     public static void main(String[] args) {
    	 BankTransaction bankTransaction = new BankTransaction("Deposit", 500.0);
    	 System.out.println(bankTransaction);
    	 
     }
 }