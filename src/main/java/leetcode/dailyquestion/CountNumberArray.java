package leetcode.dailyquestion;

import java.util.Arrays;
import java.util.HashMap;

public class CountNumberArray {

    public static void main(String[] args) {
        int [] nums = {8,2,4,5,7,8,9};
        CountNumberArray obj = new CountNumberArray();
        System.out.println( Arrays.toString(obj.countNumberLessThnNum(nums)));
    }

    public int[] countNumberLessThnNum(int [] nums){
        int n = nums.length;
        int [] output = new int [n];
        int [] temp = Arrays.copyOf(nums,n);
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(temp);

        for (int i = 0; i < n; i++) {
            if(!map.containsKey(temp[i])){
                map.put(temp[i],i);
            }
        }

        for (int i = 0; i < n; i++) {
            output[i]= map.get(nums[i]);
        }

        return output;
    }
}
