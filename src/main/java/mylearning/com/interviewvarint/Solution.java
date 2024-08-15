package mylearning.com.interviewvarint;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        /*
        arr[] = {5,6,7,8,1,2,3,4}, target = 6
        output : [0,4]

        key: 6-5=1 , index
        6-60
         */

        int [] arr = {5,6,7,8,1,2,3,4};
        int target = 6;

        int [] output = getPairIndexForTarget(arr, 10);
        System.out.println(Arrays.toString(output));


    }

    private static int[] getPairIndexForTarget(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int [] output = new int [2];

        for (int i = 0; i < arr.length; i++) {

            if(map.containsKey(arr[i])){
                output[0]=map.get(arr[i]);
                output[1] = i;
                break;
            }else {
                map.put(target-arr[i],i);
            }

        }
        return output;
    }

}
