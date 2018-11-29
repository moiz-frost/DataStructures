package com.company;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        HashTable table = new HashTable(75000);

        try {
            // Open the file that is the first
            // command line parameter
            // https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
            FileInputStream fstream = new FileInputStream("/home/ams-pc/Personal/Java/FileReadDictionary/Dictionary.txt");

            // Get the object of DataInputStream
            // https://docs.oracle.com/javase/tutorial/essential/io/datastreams.html
            DataInputStream in = new DataInputStream(fstream);

            // https://docs.oracle.com/javase/tutorial/essential/io/buffers.html
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;

            // Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the contents on the console
                String[] words = strLine.split("\\s+");
                String word = words[0];
                String meaning = "";
                for (int i = 1; i < words.length; i++) {
                    meaning = meaning + words[i];
                }
                table.insert(new Dictionary(word, meaning));
                System.out.println(words[0]);
            }

            in.close(); // Close the input stream
        } catch (Exception e) { // Catch exception if any
             System.err.println("Error: " + e.toString());
        }

    }

}
