package org.example;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Welcome to the Accounting App!");
            System.out.println("Please pick from the following options:");
            System.out.println("1) Add Deposit" +
                    "\n 2) Make Payment (Debit)" +
                    "\n 3) Ledger" +
                    "\n 4) Exit");

            //try catch for weird inputs
            //switch case inputs

            try {
                int menuHomeInput = Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException ex) {
                System.out.println("Please type in a number");
            }

        }
    }
}