package mylearning.com.exception;


import mylearning.com.interfaces.MyInterface;
import mylearning.com.interfaces.MyInterfaceTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException  extends Exception implements MyInterface, MyInterfaceTwo {


    // Main driver method
    public static void main(String[] args) throws IOException
    {

        // Reading file from path in local directory
        FileReader file = new FileReader("C:\\test\\a.txt");

        // Creating object as one of ways of taking input
        BufferedReader fileInput = new BufferedReader(file);

        // Printing first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++)
            System.out.println(fileInput.readLine());

        // Closing file connections
        // using close() method
        fileInput.close();
    }
}
