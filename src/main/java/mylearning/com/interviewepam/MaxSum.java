package mylearning.com.interviewepam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSum {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //-2,1,-3,4,-1,2,1,-5,4

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int output = maxSum(nums);
        System.out.println(output);

      /*  list of strings --> apple, banana, cherry

        use java8 streams and apply any intermediate or terminal ops
        and capitalise the first letter of each word in that list

        output: Apple, Banana, Cherry

        */

        List<String> list = Arrays.asList("apple", "banana", "cherry");
        List<String> list1 = list.stream().map((str) -> str.substring(0, 1).toUpperCase()
                        + str.substring(1))
                .collect(Collectors.toList());

        System.out.println(list1);

    }

    private static int maxSum(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < maxSum) {
                while (sum < maxSum && start < i) {
                    sum = sum - nums[start];
                    start++;
                }
            }
        }
        return maxSum;
    }

    @Test
    public void testMaxSum() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = MaxSum.maxSum(nums);
      //  assertthat(result,6);
    }

}
