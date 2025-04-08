package com.app;

public class Account {
    private int accountNumber;
    private String username;
    private int pin;
    private double balance;
    
    public Account(int accountNumber,String username,int pin,double balance) {
    	this.accountNumber=accountNumber;
    	this.username=username;
    	this.pin=pin;
    	this.balance=balance;
    }

	public int getAccountNumber() {
		return accountNumber;
	}
	public String getUserName() {
		return username;
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
