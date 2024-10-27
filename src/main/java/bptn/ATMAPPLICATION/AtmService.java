package bptn.ATMAPPLICATION;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class AtmService {
	
	User user = new User(); // User object to access and modify the users account balance
	
	// collections for storage
	ArrayList<String>transactions= new ArrayList<>();
	HashMap<Integer,String>transactionNumbers = new HashMap<>();
	
	Integer count = 1; //count for each transaction
	
	// method to display users current balance
	public void getbalance() {
		System.out.println("Available balance is:" + user.getBalance());
	}
	
	// method to withdraw
	public void withdrawAmount(double amount) {
		if (amount % 5 != 0) {
			System.out.println("Please enter amount which are multiples of 5");
			return;
		}
		if (amount > user.getBalance()) {
			System.out.println("Insufficient balance!!");
			return;
		}
		// if checks are passed transaction history is updated and amount is deducted from balance
		
		transactions.add("Withdraw: $" + amount); 
		transactionNumbers.put(count,"Withdraw: $" + amount);
		count++;
		user.setBalance(user.getBalance()- amount);
		System.out.println("Take your cash:" + amount);
		System.out.println("Updated balance: $" + user.getBalance());		
	
	}
	   // Method to deposit into the users account
	public void depositAmount(double amount) {
		user.setBalance(user.getBalance()+ amount);
		System.out.println("Successfully deposited:" + amount);
		
		transactions.add("Deposit: $" + amount); //record transaction
		transactionNumbers.put(count,"Deposit: $" + amount);
		count++;
		System.out.println("Updated balance: $" + user.getBalance());
		
	}
	
	// Method to view complete transactions history 
	public void viewTransactions() {
		for(String entry:transactions) {
			System.out.println(entry);
	}

	}
	
    // Method to save transactions history to a text file	
	public void saveTransactionsToFile() {
	File file = new File("Transactions.txt");
    			if (file.exists()) {
    				file.delete();
    				
    			}
    	try {
    		FileWriter writer = new FileWriter("Transactions.txt"); // File writer to write transaction history to file
    		writer.write("************************************************** \n"
    			     + "*                  TRANSACTION HISTORY           *\n"
    			     + "**************************************************\n");
    		int count =1;
    		for(String transactions: transactions) {
    			writer.write("Transactions " + count + ": " + transactions + "\n"); // writes each transaction
    			count++;
    		}System.out.println("Your Transaction History File Has Been Created ");
    		writer.close(); // close the file writer to save the file
    	}
        catch(IOException e) {
        	System.out.println("Something went wrong when creating the file");//Handle I/O exceptions
        }
    }
}




