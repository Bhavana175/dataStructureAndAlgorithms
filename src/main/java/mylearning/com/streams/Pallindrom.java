package mylearning.com.streams;

import java.util.stream.IntStream;


public class Pallindrom {

    public static void main(String[] args) {
        String str1 = "Madam";
        String str = str1.toUpperCase();

        Boolean flag = IntStream.rangeClosed(0,str.length()/2)
                .noneMatch(i->str.charAt(i) !=(str.charAt(str.length()-1-i)));

        System.out.println(flag);

    }

}
