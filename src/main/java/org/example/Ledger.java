package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

public class Ledger {

    //1) All - print allTransactions list
    public static void displayAll() {
        //we are creating a new list, using what the readTransactions method returns
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for (Transaction transaction : transactionList) {
            System.out.println(transaction.toString());
        }
    }

    //2) Deposits - Display only deposits
    public static void displayDeposits() {
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for (Transaction transaction : transactionList) {
            if (transaction.getAmount() > 0) {
                System.out.println(transaction);
            }
        }
    }

    //3) Payments - Display only negative entries/payments
    public static void displayPayments() {
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for (Transaction transaction : transactionList) {
            if (transaction.getAmount() < 0) {
                System.out.println(transaction);
            }
        }
    }


    //4) Reports - A new screen that allows the user to run pre-defined reports or to run a custom search
    public static void monthToDate() {
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for (Transaction transaction : transactionList) {

            LocalDate dateOfTransaction = transaction.getDate();
            Month monthOfTransaction = transaction.getDate().getMonth();

            LocalDate currentDate = LocalDate.now();
            Month currentMonth = currentDate.getMonth();

            // and is && or is ||
            if ((dateOfTransaction.isBefore(currentDate) || dateOfTransaction.equals(currentDate)) && currentMonth == monthOfTransaction) {
                System.out.println(transaction.toString());
            }
        }
    }

    public static void previousMonth() {
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for (Transaction transaction : transactionList) {

            Month monthOfTransaction = transaction.getDate().getMonth();

            LocalDate currentDate = LocalDate.now();
            Month previousMonth = currentDate.minusMonths(1).getMonth();

            if (monthOfTransaction == previousMonth) {
                System.out.println(transaction);
            }
        }
    }

    public static void yearToDate() {
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for (Transaction transaction : transactionList) {

            Year yearOfTransaction = Year.of(transaction.getDate().getYear());

            LocalDate currentDate = LocalDate.now();
            Year currentYear = Year.of(currentDate.getYear());

            if (yearOfTransaction.equals(currentYear)) {
                System.out.println(transaction);
            }
        }
    }

    public static void previousYear() {
        List<Transaction> transactionList = FileManager.readTransactionsFile();

        for (Transaction transaction : transactionList) {

            Year yearOfTransaction = Year.of(transaction.getDate().getYear());

            LocalDate currentDate = LocalDate.now();
            Year previousYear = Year.of(currentDate.minusYears(1).getYear());

            if (yearOfTransaction.equals(previousYear)) {
                System.out.println(transaction);
            }
        }
    }
}
