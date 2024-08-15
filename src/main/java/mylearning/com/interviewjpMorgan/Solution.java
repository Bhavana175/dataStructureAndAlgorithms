package mylearning.com.interviewjpMorgan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    /*


    String array
    {"1","2",""--- "str1", "str10", "str1"} with duplicates
    print string and how many times it appear
     */

    public static void main(String[] args) {

        List<String> list = Arrays.asList("str1", "str2","str3","str1","str1","str5","str10","str10"  );

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i),0)+1);
        }
        map.entrySet().forEach((e)-> System.out.println(e.getKey() +" :"+e.getValue()));

        System.out.println(isPallindrome("madam1"));
        //list of strings using stream
        // pass str3
        String input = "str3";

        System.out.println(list.indexOf(input));

        list.stream().filter((s)->s.equalsIgnoreCase(input)).findFirst()
                .ifPresentOrElse((ss)->{System.out.println(list.indexOf(ss));}, ()-> System.out.println("not found"));

                //.anyMatch((s)->{s.equalsIgnoreCase(input);});

    }

    private static boolean isPallindrome(String str) {

        int len = str.length();

        for (int i = 0; i <len/2; i++) {
            if(str.charAt(i)!= str.charAt(len-1-i)){
                return false;
            }
        }


       // ((()))

        return true;
    }



    /*
    microservice

react js
rest call-> controller-> hibernate-> oracle db

transfer to different account

2 table update in Db

---------------------

Audit Service

table 1 --> update -> post rest audit service -> user,






select loan, date, flag from table where loan="123" and flag =Y;


update flag='N' from table
(select loan, date, flag from table
rank over partition by(loan) order by date) rank
where rank >1;


emp
A,
B
C
D
E
F
G
H
I
J
K
L

manager
B,
-
A
B
A
C
D
C
F
L
D
A

HashMap<Manger, list<emp>>

B  [A,D]
A  [ C,E, L]
top [B]

-------
queue<>

queue.add(map.get(top))
B
---------

D C, E, L
while(!queue.isEmpty){


 String curr = queue.poll();
 curr =A

 if(map.contains(curr)){

 List<String> empList = map.get(curr); A,D

 forEach(String emp : empList){

 queue.add(emp);

 print (curr)

 }



 }

}
     */
}
