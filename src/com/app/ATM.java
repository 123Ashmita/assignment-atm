package com.app;

public class ATM {
   private Account[] accounts;
   private int accountCount;
   private double[] transactions;
   private int tcount;
   
   public ATM(int maxAccounts) {
	accounts = new Account[maxAccounts];
	accountCount = 0;
	transactions = new double[100];
	tcount = 0;
   }
   public void createAccount(int accountNumber,String userid,int pin,double balance) {
	   for(int i=0;i<accountCount;i++) {
	   if(accountNumber==accounts[i].getAccountNumber()) {
		   System.out.println("Account Cannot Created !! Account number already registered");
		   return;
	   }
	 }
	   if(accountCount<accounts.length) {
		      Account account=new Account(accountNumber,userid,pin,balance);
		      accounts[accountCount++]=account;
		      System.out.println("Account Created Successfully");
	       	} else {
		      System.out.println("Acount limit reached"); 	
		      }
	     }
   public Account login(int accountNumber,int pin) {
	  for(int i=0;i<accountCount;i++) {
		  if(accounts[i].getAccountNumber()==accountNumber && accounts[i].getPin()==pin)
		  {
			  return accounts[i];
		  }
	  }
	return null;
   }
   public void displayBalance(Account account) {
		if(account!=null) {
			System.out.println("your current balance "+account.getBalance());
		}
		else {
			System.out.println("invalid account");
		}
		
	}
	public void deposit(Account account,double amount) {
		if(account!=null) {
			transactions[tcount++]=amount;
			account.setBalance(account.getBalance()+amount);
			System.out.println("Deposit Successfully ! current balance "+account.getBalance());
		}
		else {
			System.out.println("invalid");
		}
	}
	public void withdraw(Account account,double amount) {
		if(account!=null) {
			if (amount > account.getBalance()) {
				System.out.println("insufficient balance");
			}
			else {
			transactions[tcount++]=-amount;
			account.setBalance(account.getBalance()-amount);
			System.out.println("Withdraw Successfully ! current balance"+account.getBalance());	
		} 
		} else {
			System.out.println("invalid");
		}
    }
        public void showTransactions() {		
	      System.out.println("Transactions history");
	      for(int i=0;i<tcount;i++) {
		    if(transactions[i]>0) { 
			System.out.println("deposit "+transactions[i]);
		    } else {
			System.out.println("withdraw "+(-transactions[i]));
		}
	 }
}
       public Account login(String userid, int pin) {
    	     for (int i = 0; i < accountCount; i++) {	   
    			  if(accounts[i].getUserId().equals(userid) && accounts[i].getPin()==pin)
    			  {
    				  return accounts[i];
    			  }
    		  }
		return null;
       }
       
       public void AccountsByUserId(String userid) {
           boolean found = false;
           System.out.println("User ID: " + userid);
           for (int i = 0; i < accountCount; i++) {
               if (accounts[i].getUserId().equals(userid)) {
                   System.out.println("Account Number: " + accounts[i].getAccountNumber());
                   found = true;
               }
           }
           if (!found) {
               System.out.println("No accounts found for this User ID.");
           }
       }
       
       public Account getAccount(int accountNumber) {
           for (int i = 0; i < accountCount; i++) {
               if (accounts[i].getAccountNumber() == accountNumber) {
                   return accounts[i];
               }
           }
           return null;
       }
       
}

   