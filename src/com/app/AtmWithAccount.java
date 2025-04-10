package com.app;

import java.util.Scanner;

public class AtmWithAccount {
    public static void main(String[] args) {
        ATM atm = new ATM(10);
        Account currentAccount = null;
        int choice;
        Scanner sc = new Scanner(System.in);

        while (true) {
            if (currentAccount == null) {
                System.out.println("Welcome to this ATM");
                System.out.println("1 Create Account");
                System.out.println("2 Login");
                System.out.println("3 Login with userid");
                System.out.println("4 Exit");
                System.out.println("Choose an option:");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter account no:");
                        int accountNumber = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.println("Enter userid:");
                        String userid = sc.nextLine();
                        System.out.println("Enter pin:");
                        int pin = sc.nextInt();
                        System.out.println("Enter amount to deposit:");
                        double amount = sc.nextDouble();
                        atm.createAccount(accountNumber, userid, pin, amount);
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
                        sc.nextLine(); // consume newline
                        System.out.println("Enter userid:");
                        userid = sc.nextLine();
                        System.out.println("Enter pin:");
                        pin = sc.nextInt();
                        currentAccount = atm.login(userid, pin);
                        if (currentAccount == null) {
                            System.err.println("Invalid account or pin");
                        } else {
                            System.out.println("Login successful");
                        }
                        break;

                    case 4:
                        System.out.println("Thank you! Goodbye.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid option! Try again.");
                        break;
                }
            } else {
                atm.AccountsByUserId(currentAccount.getUserId());
                System.out.println("Enter the account number you want to use:");
                int accountChoice = sc.nextInt();
               
                Account acc = atm.getAccount(accountChoice);
                if (acc == null) {
                    System.out.println("Invalid account number, please select a valid account");
                    continue;
                }
                System.out.println("Enter PIN to log in:");
                int pin = sc.nextInt();
                if (acc.getPin() == pin) {
                    System.out.println("Login successful!");
                } else {
                    System.err.println("Invalid PIN. Login failed.");
                }
               
                while (true) {
                    System.out.println("----------------------------");
                    System.out.println("ATM Menu");
                    System.out.println("1. Balance");
                    System.out.println("2. Deposit");
                    System.out.println("3. Withdraw");
                    System.out.println("4. Transaction history");
                    System.out.println("5. Logout");
                    System.out.println("----------------------------");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            atm.displayBalance(acc);
                            break;
                        case 2:
                            System.out.println("Enter amount to deposit");
                            double depositAmount = sc.nextDouble();
                            atm.deposit(acc, depositAmount);
                            break;
                        case 3:
                            System.out.println("Enter amount to Withdraw");
                            double withdrawAmount = sc.nextDouble();
                            atm.withdraw(acc, withdrawAmount);
                            break;
                        case 4:
                            atm.showTransactions();
                            break;
                        case 5:
                            System.out.println("Logout successfully");
                            currentAccount = null;
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    if (currentAccount == null) {
                        break;
                    }
                }
            }
        }
    }
}
