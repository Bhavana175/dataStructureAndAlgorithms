package mylearning.com.interviewfreshworks1round;

public class MaxSubArraySum {


    /*
        Input : arr[] = {100,200,300,400}, k =2
        Output : 700
        Input : arr[] = {1,4,2,10,23,3,1,0,20}, k = 4
        Output : 39
        {4,2,10,23}
     */

    public static void main(String[] args) {

        int [] arr  = {100,200,300,400}; int k =2;
        int [] arr2 = {1,4,2,10,23,3,1,0,20}; int k2 = 4;

        int output = maxSumForKElements(arr, k);
        System.out.println(output);


        int output2 = maxSumForKElements(arr2, k2);
        System.out.println(output2);
    }

    private static int maxSumForKElements(int[] arr, int k) {

        int maxSum = Integer.MIN_VALUE;
        int start =0;
        int sum=0;
        for (int i = 0; i < arr.length; i++) {

            //{1,4,2,10,23,3,1,0,20}, k = 4
             while (i<start+k){
                 sum= sum+arr[i];
                 i++;
             }
             maxSum = Math.max(maxSum, sum);
             sum = sum - arr[start]+arr[i];
             maxSum = Math.max(maxSum, sum);
             start++;

        }

        return maxSum;
    }

}
