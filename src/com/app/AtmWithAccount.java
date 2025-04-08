package com.app;

import java.util.Scanner;

public class AtmWithAccount {
   public static void main(String[] args) {
	   ATM atm=new ATM(10);    
	    Account currentAccount=null;
	    int choice;
	    Scanner sc= new Scanner(System.in);
	    
	    while(true) {
	    	if(currentAccount==null) {
	    		System.out.println("Welcome to this ATM");
                System.out.println("1 Create Account");
                System.out.println("2 Login");
                System.out.println("3 Exit");
                System.out.println("Choose an option:");
                choice = sc.nextInt();
                
                switch (choice) {
                case 1:
                    System.out.println("Enter account no:");
                    int accountNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter username:");
                    String username = sc.nextLine();
                    System.out.println("Enter pin:");
                    int pin = sc.nextInt();    
                    System.out.println("Enter amount to deposit:");
                    double amount = sc.nextDouble();
                    atm.createAccount(accountNumber,username, pin, amount);
                    break;

                case 2:
                    System.out.println("Enter account no:");
                    accountNumber = sc.nextInt();
                    System.out.println("Enter pin:");
                    pin = sc.nextInt();
                    currentAccount = atm.login(accountNumber, pin);
                    if (currentAccount == null) {
                        System.err.println("Invalid account or pin");
                    } else {
                        System.out.println("Login successful");
                    }
                    break;

                case 3:
                    System.out.println("Thank you! Goodbye.");
                    sc.close();
                    return;  

                default:
                    System.out.println("Invalid option! Try again.");
                    break;
            }
        } else {
        	System.out.println("----------------------------");
            System.out.println("ATM Menu");
            System.out.println("1. Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction history");
            System.out.println("5. Logout");
            System.out.println("----------------------------");
            choice = sc.nextInt();
            
            switch(choice) {
            
            case 1:  atm.displayBalance(currentAccount);
                     break;
                     
            case 2:  System.out.println("Enter amount to deposit");
                     double amount=sc.nextDouble();
                     atm.deposit(currentAccount, amount);
                     break;
                     
            case 3: System.out.println("Enter amount to Withdraw");
                    double amn=sc.nextDouble();
                    atm.withdraw(currentAccount, amn);
                     break; 
                     
            case 4: atm.showTransactions();
                    break;
                    
            case 5:  System.out.println("Logout successfully");
                     currentAccount = null;
                     break;

            default: System.out.println("Invalid option");
                     break;        
            }
            
	    	}
	    }
}
}
