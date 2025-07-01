package leetcode.dailyquestion;

import java.util.Arrays;
import java.util.List;

public class FindPreFix {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("MyNameShreya", "MyNameShwati", "MyNameShavana");
        System.out.println(prefix(list));
    }

    public static String prefix(List<String> list){

        int n = list.size();
        if(n==1) return list.get(0); //asume size is 0<

        String prefix = list.get(0);
        for (int i = 1; i <n ; i++) {
            String next = list.get(i);
            for (int j = 0; j < prefix.length(); j++) {
                if(prefix.charAt(j) == next.charAt(j)) continue;
                else prefix = prefix.substring(0,j);
            }
        }

        return prefix;
    }
}
