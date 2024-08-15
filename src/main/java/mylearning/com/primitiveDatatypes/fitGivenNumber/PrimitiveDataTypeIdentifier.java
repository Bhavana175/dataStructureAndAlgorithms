package mylearning.com.primitiveDatatypes.fitGivenNumber;
import java.lang.Math.*;
import java.util.Scanner;


/*
Question:
For each input variable  and appropriate primitive ,
 you must determine if the given primitives are capable of storing it. If yes, then print:
       =====================================
        n can be fitted in:
        * dataType
        ======================================
        If there is more than one appropriate data type,
         print each one on its own line and order them by size (i.e.: ).

        If the number cannot be stored in one of the four aforementioned primitives,
         print the line:
         ===========================
        n can't be fitted anywhere.
        ==========================

-150 can be fitted in:
* short
* int
* long
150000 can be fitted in:
* int
* long
1500000000 can be fitted in:
* int
* long
213333333333333333333333333333333333 can't be fitted anywhere.
-100000000000000 can be fitted in:
* long

*/

public class PrimitiveDataTypeIdentifier {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        identifyDataTypes(sc.nextInt());

    }

    private static void identifyDataTypes(Integer n) {

        //byte 8 bit , short 16 bit, int 32 bit, long 64 bit

        try
        {
            long x=n;
            System.out.println(x+" can be fitted in:");
            if(x>=-128 && x<=127)System.out.println("* byte");
            if(-Math.pow(2,15)<=x && x<=(Math.pow(2,15)-1))System.out.println("* short");
            if(-Math.pow(2,31)<=x && x<=(Math.pow(2,31)-1))System.out.println("* int");
            if(-Math.pow(2,63)<=x && x<=(Math.pow(2,63)-1))System.out.println("* long");
        }
        catch(Exception e)
        {
            System.out.println(n+" can't be fitted anywhere.");
        }

    }

}
