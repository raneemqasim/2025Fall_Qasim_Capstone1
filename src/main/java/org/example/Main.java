package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while(running){

            //homeMenu
            System.out.println("Welcome to the Accounting App!");
            System.out.println("Please pick from the following options:");
            System.out.println("1) Add Deposit");
            System.out.println("2) Make Payment (Debit)");
            System.out.println("3) Ledger");
            System.out.println("4) Exit");
            String homeMenuInput = scanner.nextLine();

            switch (homeMenuInput){
                case "1":
                    //add deposit
                    System.out.println("Please fill out the following info:");
                    System.out.println("Description");
                    String descriptionDeposit = scanner.nextLine();
                    System.out.println("Vendor");
                    String vendorDeposit = scanner.nextLine();
                    System.out.println("Amount (with 2 decimal places)");
                    double amountDeposit = Double.parseDouble(scanner.nextLine());

                    Transaction deposit =  new Transaction(LocalDate.now(), LocalTime.now(), descriptionDeposit, vendorDeposit, amountDeposit);
                    FileManager.writeTransactions(deposit);

                    System.out.println("Your deposit has been added to the file!");

                    break;

                case "2":
                    //make payment
                    System.out.println("Please fill out the following info:");
                    System.out.println("Description");
                    String descriptionPayment = scanner.nextLine();
                    System.out.println("Vendor");
                    String vendorPayment = scanner.nextLine();
                    System.out.println("Amount (with 2 decimal places)");
                    double amountPayment = -Double.parseDouble(scanner.nextLine());

                    Transaction payment =  new Transaction(LocalDate.now(), LocalTime.now(), descriptionPayment, vendorPayment, amountPayment);
                    FileManager.writeTransactions(payment);

                    System.out.println("Your payment has been added to the file!");

                    break;

                case "3":
                    //ledger
                    System.out.println("Here are your ledger options:");
                    System.out.println("1) Display all entries");
                    System.out.println("2) Deposits");
                    System.out.println("3) Payments");
                    System.out.println("4) Reports");
                    System.out.println("0) Home");
                    String ledgerInput = scanner.nextLine();

                    switch(ledgerInput){
                        case "1":
                            Ledger.displayAll();
                            break;

                        case "2":
                            Ledger.displayDeposits();
                            break;

                        case "3":
                            Ledger.displayPayments();
                            break;

                        case "4":
                            //reports menu
                            System.out.println("Please select from the following reports:");
                            System.out.println("1) Month to Date");
                            System.out.println("2) Previous Month");
                            System.out.println("3) Year to Date");
                            System.out.println("4) Previous Year");
                            System.out.println("0) Go back");
                            String reportsInput = scanner.nextLine();

                            switch (reportsInput){
                                case "1":
                                    Ledger.monthToDate();
                                    break;

                                case "2":
                                    Ledger.previousMonth();
                                    break;

                                case "3":
                                    Ledger.yearToDate();
                                    break;

                                case "4":
                                    Ledger.previousYear();
                                    break;

                                case "0":
                                    break;

                                default:
                                    System.out.println("Please pick a number from 0-4");
                                    break;
                            }

                            break;

                        case "0":
                            break;

                    default:
                        System.out.println("Please pick a number 0-4");
                        break;
                    }
                    break;

                case "4":
                    running = false;
                    break;

                default:
                    System.out.println("Please pick a number 1-4");
                    break;
            }
        }
    }
    //we could put some methods here that show us our menus
}
