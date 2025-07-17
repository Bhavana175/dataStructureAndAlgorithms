package leetcode.dailyquestion.booking_practice;

public class IntegerToRoman_12 {
    public static void main(String[] args) {
        int num = 3749;
        System.out.println(intToRoman(num));
        /*
        I	1
        V	5
        X	10
        L	50
        C	100
        D	500
        M	1000
        */
    }

    public static String intToRoman(int num) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XD", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] intValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < intValues.length; i++) {
            while (num>= intValues[i]){
                num-=intValues[i];
                sb.append(roman[i]);
            }
        }

        return sb.toString();
    }
}
