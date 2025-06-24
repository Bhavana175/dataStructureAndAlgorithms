package leetcode.dailyquestion.dp;

public class SubsetArraySum {
    public static void main(String[] args) {
        System.out.println(subSetArraySum(new int []{2,4,6,8,4}, 10));
    }
    public static boolean subSetArraySum(int [] arr , int sum){

        int n = arr.length;
        boolean [][] t = new boolean[n+1][sum+1];

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }

        for (int index = 1; index < n+1; index++) {
            for (int remSum = 0; remSum < sum+1; remSum++) {
                if(arr[index-1]<= remSum){
                    t[index][remSum] = t[index-1][remSum-arr[index-1]] || t[index-1][remSum];
                }else t[index][remSum] =  t[index-1][remSum];

            }
        }
        return t[n][sum];
    }
}
