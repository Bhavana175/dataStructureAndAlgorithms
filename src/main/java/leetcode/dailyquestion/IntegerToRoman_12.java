package leetcode.dailyquestion;

public class IntegerToRoman_12 {
    public static void main(String[] args) {

        System.out.println(intToRoman(1994));
    }
    public static String intToRoman(int num) {

        int [] intValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String [] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<intValues.length; i++){
            while (num>= intValues[i]){
                num -= intValues[i];
                sb.append(roman[i]);
            }
        }

        return sb.toString();
    }
}
