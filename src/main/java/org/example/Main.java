package org.example;


import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //make sure there is a way out of this while loop
        //does the while loop need to be in a try catch block?
        while(true){

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
                    System.out.println("Amount");
                    double amountDeposit = scanner.nextDouble();

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
                    System.out.println("Amount");
                    double amountPayment = -scanner.nextDouble();

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


                            Ledger.displayReports();
                            break;

                        default:
                            System.out.println("Please pick a number 1-4");
                            break;

                    }

                case "4":
                    break;

                default:
                    System.out.println("Please pick a number 1-4");
                    break;
            }



            //try catch for weird inputs
//            try {
//                int homeMenuInput = Integer.parseInt(scanner.nextLine());
//            } catch (InputMismatchException ex) {
//                System.out.println("Please type in a number");
//            }

        }
    }
    //we could put some methods here that show us our menus
}
