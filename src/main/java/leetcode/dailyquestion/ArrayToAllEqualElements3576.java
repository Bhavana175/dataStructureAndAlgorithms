package leetcode.dailyquestion;

public class ArrayToAllEqualElements3576 {

    public static void main(String[] args) {

    }

    public static boolean canMakeEqual(int[] nums, int k) {

        return canMakeEqual(nums, 1, k) || canMakeEqual(nums, -1, k);

    }

    public static boolean canMakeEqual(int[] nums, int tar, int k) {

        int [] arr = nums.clone();
        int n = arr.length;
        int changeCount =0;

        for (int i = 0; i < n-1; i++) {
            if(arr[i]!=tar){
                arr[i]= -arr[i];
                arr[i+1]= -arr[i+1];
                changeCount++;
            }
            if(changeCount>k){
                return false;
            }
        }
        return arr[n-1]==tar && changeCount<=k;
    }
}
