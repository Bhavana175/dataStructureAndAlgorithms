package leetcode.dailyquestion.practice.amazon;

public class LargestSumArray_K {
    public static void main(String[] args) {
        int [] arr = {-2, -3, -4, -1, -2, -1, -5, -3};
        System.out.println(findLargestSum(arr));
    }
    public static int findLargestSum(int [] arr){
        int maxSum = Integer.MIN_VALUE;
        int currSum =0;

        for (int i = 0; i < arr.length; i++) {
            currSum +=arr[i];
            maxSum = Math.max(maxSum, currSum);
            if(currSum<0){
                currSum =0;
            }
        }
        return maxSum;
    }
}
