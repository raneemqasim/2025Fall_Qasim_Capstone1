package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    //this is a method called readTransactionsFile
    //instead of void, we want it to return a list of transactions, thus List<Transaction>
    //static means we can use this method everywhere
    public static List<Transaction> readTransactionsFile(){
        //empty list
        List<Transaction> allTransactions = new ArrayList<>();

        //file reader
        try{
            java.io.FileReader fr = new FileReader("src/main/resources/transactions.csv");
            BufferedReader reader = new BufferedReader(fr);

            String line;

            while ((line = reader.readLine()) != null) {
                String[] transactionData = line.split("\\|");

                Transaction newTransaction = new Transaction();

                //0 date, 1 time, 2 description, 3 vendor, 4 amount
                newTransaction.setDate(LocalDate.parse(transactionData[0]));
                newTransaction.setTime(LocalTime.parse(transactionData[1]));
                newTransaction.setDescription(transactionData[2]);
                newTransaction.setVendor(transactionData[3]);
                newTransaction.setAmount(Double.parseDouble(transactionData[4]));

                //add the transaction to the allTransactions list
                allTransactions.add(newTransaction);
            }

            //close the reader for security, make sure it is outside the while loop
            reader.close();
        }
        catch(
                FileNotFoundException ex){
            System.out.println("File not found");
        }
        catch(
                IOException ex){
            System.out.println("Problem with file");
        }

        return allTransactions;

    }

    //this is our writeTransactions method
    //make sure there is a transaction argument because we need that
    public static void writeTransactions(Transaction transaction){
        try{
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/main/resources/transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //we are gonna write the transaction that we put in the argument as a string
            bufferedWriter.write("\n" + transaction.toString());

            //close it for security
            bufferedWriter.close();
        }
        catch(IOException ex){
            System.out.println("Something went wrong with the file, try again.");
        }

    }
}
