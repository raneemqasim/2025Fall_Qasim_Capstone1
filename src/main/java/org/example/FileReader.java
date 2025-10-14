package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static void main(String[] args) {
        try{
            java.io.FileReader fr = new java.io.FileReader("src/main/resources/transactions.csv");
            //the file is open, but now we need to go through the file
            //buffered reader can read files efficiently
            BufferedReader reader = new BufferedReader(fr);

            //let's go through the file line by line
            //we made the variable line, it's a placeholder we did not assign it a value
            String line;

            //there is another checked exception for readLine(IOexception)
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

            //close the file when you are done so it's not open to hackers
            //file should only be open for as long as you need to do what you're doing
            //and then immediately close it
            reader.close();
        }
        catch (
                FileNotFoundException ex) {
            System.out.println("Could not find the file.");
        }
        catch(
                IOException ex){
            System.out.println("Something is wrong with the file.");
        }
    }
}
