package bptn.ATMAPPLICATION;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Atm {

    public static void main(String[] args) {
        System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Welcome, Please Enter Your Pin."+ ConsoleColors.RESET);
        
        int pin = 1234; //The predefined pin

        //initialize a Scanner
        Scanner scanner = new Scanner(System.in); 
        try {                                // Using try catch block to make sure user input is an int.and also checking if the pin is correct
           
        	// User is asked to enter an integer as the pin
        	int atmPin = scanner.nextInt();
           if (atmPin != pin) {
               System.out.println("Invalid Pin,EXITING.");
               System.exit(0);
           }

           } catch (InputMismatchException e) { //In case user enters a non integer 
        System.out.println("Invalid PIN,EXITING.");
        System.exit(0);
           }
       

        AtmService atmService = new AtmService(); //AtmService class is initialized to handle operations

        //  loop runs continousley until user exits.
        while (true) {
        	
        	//ATM menu options is displayed for users
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT + "\nATM Menu:" + ConsoleColors.RESET);
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. View Full Transaction History");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.println("Enter Choice");
            int choice = scanner.nextInt();

            if (choice == 1) {
            	// Display current balance
                atmService.getbalance();
                
            } else if (choice == 2) {
            	// Withdraw money
                System.out.println("Enter amount to withdraw ");
                double amount = scanner.nextDouble();
                atmService.withdrawAmount(amount);//call withdraw method in AtmService
                
            } else if (choice == 3) {
            	// Deposit money
                System.out.println("Enter amount to deposit ");
                double amount = scanner.nextDouble();
                atmService.depositAmount(amount); // Call deposit method
                
            } else if (choice == 4) {
            	// View full transaction history and save to file
                atmService.viewTransactions(); //Console view
                atmService.saveTransactionsToFile(); // Save transactions to file
                
            } else if (choice == 5) {
            	// View specific transaction using transaction number
            	System.out.println("Enter transaction number you would like to view "); 
            	Integer num = scanner.nextInt();
            	if (atmService.transactionNumbers.containsKey(num)) { 
            		System.out.println(atmService.transactionNumbers.get(num)); //Specific transaction is printed
            	} else {
            		System.out.println("That transaction number does not exist");
            	}
            }
            else if (choice == 6) {
            	// Exit the application
                System.out.println("Please collect your card before leaving.");
                break;  // Break the loop to exit
            } else {  // Handles any invalid choice
                System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close(); // Close the scanner once the loop is done
    }
}

