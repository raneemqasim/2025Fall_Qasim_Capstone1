package org.example;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public static void main(String[] args) {
        try{
            //we add true at the end so we don't write over what is in the file already
            //it will append it as in put it at the end
            java.io.FileWriter fileWriter = new java.io.FileWriter("src/main/resources/transactions.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //this \n is to put the info on a new line
            bufferedWriter.write("\n90|Bob Jones|40|10.25");

            //once you are finished writing
            bufferedWriter.close();
        }
        catch(IOException ex){
            System.out.println("Something went wrong with the file, try again.");
        }
    }
}
