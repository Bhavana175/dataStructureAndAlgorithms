package leetcode.dailyquestion.practice;

public class SearchInRotatedSortedArray33 {

    public static void main(String[] args) {

        int [] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }


    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;

        while (l <= r) {
            int mid = (r + l) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if(nums[l]<= nums[mid]){
                //left sorted
                if(nums[l]<= target && target <nums[mid]){
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }else {
                //right sorted
                if(nums[mid]< target && target<= nums[r]){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }


        }
        return -1;
    }

}
