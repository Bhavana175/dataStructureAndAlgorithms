package leetcode.dailyquestion;

import java.util.HashMap;
import java.util.Map;

class DivideArray{

    public static void main(String[] args) {
        int[] nums = {3,2,3,2,4,4};
        System.out.println( divideArray(nums));
    }

    //https://leetcode.com/problems/divide-array-into-equal-pairs/description/?envType=daily-question&envId=2025-03-17
    public static boolean divideArray(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        if(nums.length%2==0){
            for(int i=0; i<nums.length; i++){
                if(map.containsKey(nums[i])){
                    map.remove(nums[i]);
                }else {
                    map.put(nums[i], 1);
                }
            }
            int sum =0;
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                sum+=entry.getValue();
            }
            if(sum ==0 ) {return true;}
            else {return false;}
        }else return false;
    }

}