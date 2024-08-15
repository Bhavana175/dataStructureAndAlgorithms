package mylearning.com.question;

import java.util.HashMap;

public class TwoSum {

/*       Given an array of integers nums and an integer target, return indices of
        the two numbers such that they add up to target.
          You may assume that each input would have exactly one solution,
         and you may not use the same element twice.
             You can return the answer in any order.
    */

    public static void main(String[] args) {

        int [] nums = new int[]{2,5,5,11};
        int target = 7;
        // getArrayOfIndex(nums, target);
        getArrayOfIndexHashmap(nums, target);

    }

    private static void getArrayOfIndex(int[] nums, int target) {

        int [] index = new int [2];
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j]== target){
                    index[0]=i;
                    index[1]=j;
                    break;
                }
            }
        }
        System.out.println(" "+index[0]+" "+ index[1]);

    }    private static void getArrayOfIndexHashmap(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int [] index = new int [2];

        for (int j=0; j< nums.length; j++){
           if(map.containsKey(target-nums[j])){
               index[0]=j;
               index[1]=map.get(target-nums[j]);
               break;
           }else {
               map.put(nums[j],j);
           }

        }
        System.out.println(" "+index[0]+" "+ index[1]);

    }

}
