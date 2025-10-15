package org.example;

import java.util.List;

public class Ledger {

    //this method is going to 1) All - Display all entries, print allTransactions list
    public static void displayAll(){
        //we are creating a new list, using what the readTransactions method returns
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for(Transaction transaction: transactionList){
            System.out.println(transaction.toString());
        }
    }

    //2) Deposits - Display only the entries that are deposits into the account, print if amount above 0 in allTransactions
    public static void displayDeposits(){
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for(Transaction transaction: transactionList){
            if(transaction.getAmount() > 0){
                System.out.println(transaction.toString());
            }
        }
    }

    //3) Payments - Display only the negative entries (or payments), print if below 0 on allTransactions
    // if less than 0
    public static void displayPayments(){
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for(Transaction transaction: transactionList){
            if(transaction.getAmount() < 0){
                System.out.println(transaction.toString());
            }
        }
    }

    //make 3 new methods for the different reports you are gonna run
    //4) Reports - A new screen that allows the user to run pre-defined reports or to run a custom search
    public static void displayReports(){
        //menu
        //
    }

}
