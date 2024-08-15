package mylearning.com.congnizant;


import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        int num = romanToDecimal("MCMXCIII");
        System.out.println(num);
    }
    public static int romanToDecimal(String str) {
        // code here

        if(str.length()==0){
            return 0;
        }

        int sum=0;
        HashMap<Character,Integer> map = getHashMap();

        for (int i = 0; i < str.length(); i++) {

            if(i==str.length()-1){
                return sum+map.get(str.charAt(i));
            }
            if(map.get(str.charAt(i)) >= map.get(str.charAt(i+1))){
                sum+=map.get(str.charAt(i));
            }else {
                sum-=map.get(str.charAt(i));
            }

        }
        return sum;
    }

    private static HashMap<Character,Integer> getHashMap() {
        HashMap<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',100);
        map.put('M',100);

        return map;
    }

}
