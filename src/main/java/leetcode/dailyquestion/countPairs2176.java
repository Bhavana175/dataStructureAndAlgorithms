package leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class countPairs2176 {

    public static void main(String[] args) {
       int [] nums = {3,1,2,2,2,1,3};
       int  k = 2;

        System.out.println(countPairs(nums, k));
    }

    public static int countPairs(int[] nums, int k) {

        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        int count=0;

        for (int i = 0; i < nums.length; i++) {
         freq.computeIfAbsent(nums[i], (j)-> new ArrayList<>() ).add(i);
        }

        for (Map.Entry<Integer, List<Integer>> entry : freq.entrySet()){
            List<Integer> indexes = entry.getValue();
            for (int i = 0; i < indexes.size()-1; i++) {
                int j=i+1;
                while (j<indexes.size()){
                    if((indexes.get(i)*indexes.get(j))%k==0){
                        count++;
                    }
                    j++;
                }
            }
        }

        return count;
    }
}
