package mylearning.com.intervieworacle;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        /*
        The user will input a string and we need to find the
        count of each character of the string and display it on console.
        We won’t be counting space character.
        input: hello world;
        output:
        h – 1
        e – 1
        l – 3
        o – 2
        w – 1
        r – 1
        d – 1
         */

        String input  = "Hello world";
        displayFrequencyForChar(input);


    }

    private static void displayFrequencyForChar(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
       // String s = str.replaceAll("\\s","");

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
        }
        map.forEach((k,v)-> System.out.println(k+" - "+v));

    }

}
/*

     Need to implement internal chat system for company
     1. last online
     2. one to one messaging

     Non- Functional Requirement
     1. scalable
     2. secure

    Functional Requirement
     1. last online
     2. one to one messaging.

     secure system , chat functionality

     Actor
     1. users




 */
