package mylearning.com.interviewLtts;

import java.util.Arrays;
import java.util.List;

public class StockPrice {

    public static void main(String[] args) {

        int [] arr = {200,400,20,500,600};
        List<String> buyAndSell = maxProfit(arr);
        System.out.println(buyAndSell);

        int [] arr1 = {900, 250, 600, 375, 695};
        List<String> buyAndSell1 = maxProfit(arr1);
        System.out.println(buyAndSell1);
    }

    private static List<String> maxProfit(int[] arr) {

        String [] days =  {"Monday", "Tuesday", "Wednesday", "Thursday","Friday"};
        int maxDiff =0;
        String sell ="";
        String buy ="";
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {

                if(arr[i]<arr[j] && maxDiff< arr[j]-arr[i]){
                    maxDiff = arr[j]-arr[i];
                    buy = days[i];
                    sell = days[j];
                }
            }
        }
        return Arrays.asList(buy,sell);
    }
}
