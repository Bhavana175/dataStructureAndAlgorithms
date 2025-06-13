package leetcode.dailyquestion;

public class FindMissingElementSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println(findMissingNumber(nums));
    }

    public static int findMissingNumber(int[] arr) {

        int l=0, r= arr.length-1;

        while (l<r){
            int mid = (l+r)/2;

            if(arr[mid]==mid+1){
                l = mid+1;
            }else
                r = mid-1;
        }
        return r+1;

    }
}
