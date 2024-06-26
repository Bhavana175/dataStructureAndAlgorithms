package com.workspace.learning.interviews.epampractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplit {

    public static void main(String[] args) {


        String sentence = "My name is Bhavana Karde";

        List<String> output = implementSplit(sentence);
        System.out.println(output);

    }

    private static  List<String>  implementSplit(String sentence) {

        List<String> list= new ArrayList<>();
        int start =0;
        for (int i = 0; i < sentence.length(); i++) {

            if(sentence.charAt(i)== ' '){
                list.add(sentence.substring(start,i));
                start = i+1;
            }
        }

        return list;
    }

}
