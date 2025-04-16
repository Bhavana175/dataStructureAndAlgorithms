package leetcode.dailyquestion;

public class CountGoodNumbers1922 {


    public static long modulo = 1000000007;

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(4));
    }

    public static int countGoodNumbers(long n) {
        //even (0,2,4,6,8) => 5 , ood => prime (2,3,5,7) 4 , if n=5 , 5*5*5*4*4 , 5power3, * 4 power 2
        long op = ((findPower(5, (n + 1) / 2) * (findPower(4, (n) / 2))) % modulo);
        return (int) op;
    }

    public static long findPower(int num, long pow) {

        if (pow == 0) {
            return 1;
        }

        long half = findPower(num, pow / 2);
        long result = (half * half) % modulo;
        if (pow % 2 == 1) {
            result = (result * num) % modulo;
        }

        return result;
    }
}
