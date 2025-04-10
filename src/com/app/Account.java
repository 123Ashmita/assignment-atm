package com.app;

public class Account {
    private int accountNumber;
    private String userid;
    private int pin;
    private double balance;
    
    public Account(int accountNumber,String userid,int pin,double balance) {
    	this.accountNumber=accountNumber;
    	this.userid=userid;
    	this.pin=pin;
    	this.balance=balance;
    }

	public int getAccountNumber() {
		return accountNumber;
	}
	public String getUserId() {
		return userid;
	}
	public int getPin() {
		return pin;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	
    
    
}
