package org.example;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //homeMenu
        while(true){
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

                    new Transaction(LocalDate.now(), LocalTime.now(), descriptionDeposit, vendorDeposit, amountDeposit);

                    //file writer to write the transaction object?

                case "2":
                    //make payment
                    System.out.println("Please fill out the following info:");
                    System.out.println("Description");
                    String descriptionPayment = scanner.nextLine();
                    System.out.println("Vendor");
                    String vendorPayment = scanner.nextLine();
                    System.out.println("Amount");
                    double amountPayment = -scanner.nextDouble();

                    new Transaction(LocalDate.now(), LocalTime.now(), descriptionPayment, vendorPayment, amountPayment);

                    //how do we add to the file???

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
                            //some arraylist that shows all entries
                        case "2":
                            //an if statement and array list of only deposits, if greater than 0
                        case "3":
                            //if statement and  array list of payments, if less than 0
                        case "4":
                            //reports lollll
                    }

                case "4":
                    break;
            }

            //try catch for weird inputs
            //switch case inputs

//            try {
//                int homeMenuInput = Integer.parseInt(scanner.nextLine());
//            } catch (InputMismatchException ex) {
//                System.out.println("Please type in a number");
//            }

        }
    }
}