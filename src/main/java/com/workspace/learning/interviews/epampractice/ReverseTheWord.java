package com.workspace.learning.interviews.epampractice;

import java.util.Stack;

public class ReverseTheWord {

    public static void main(String[] args) {

        String str = "I am from india";
        //output = india from am I
        String output = reverseTheWord(str);
        System.out.println(output);
        String output1 = reverseTheWordStack(str);
        System.out.println(output1);


    }

    private static String reverseTheWord(String str) {
        StringBuilder sb = new StringBuilder();
        String [] arr = str.split(" ");

        for (int i = arr.length-1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    private static String reverseTheWordStack(String str) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String [] arr = str.split(" ");

        for (int i = 0; i < arr.length; i++) {
           stack.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(stack.pop()).append(" ");
        }

        return sb.toString();
    }

}
