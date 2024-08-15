package mylearning.com.interviewStrykerHealth;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    /*
    [4:10 PM] Khan, Adnan
Given a string s, sort it in decreasing order based on the frequency of the
 characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.



Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


Input: s = "Aabbb"
Output: "bbbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

[4:10 PM] Khan, Adnan
class Solution {
public static string frequencySort(string s) {

    }
}

     */

    public static void main(String[] args) {

        String input = "tree";
        String input1 = "cccaaa";
        String input2 = "Aabb";
        String input3 = "Aabbb";
        String input4 = "aacccbbb";
        System.out.println(frequencySort(input));
        System.out.println(frequencySort(input1));
        System.out.println(frequencySort(input2));
        System.out.println(frequencySort(input3));
        System.out.println(frequencySort(input4));

    }

    public static String frequencySort(String s) {
        /*
        Input: s = "tree"
        Output: "eert"
         */

        StringBuilder sb = new StringBuilder();
        TreeMap<Character, Integer> map = new TreeMap<>(); // freq for each char
        TreeMap<Integer, Character> map2 = new TreeMap<>((o1,o2)->o2-o1); // count and index des


        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        for (Map.Entry<Character, Integer> mapEntry: map.entrySet()
             ) {
            map2.put(mapEntry.getValue(), mapEntry.getKey());
        }

        // e->2, r->1, t->1
        // map2 2->e, 1->t (r is left) append at last using string

        map2.entrySet().forEach((entry)->{
          int count = entry.getKey();
          while (count!=0){
              sb.append(entry.getValue());
              count--;
          }
        });

        for (int i = 0; i < s.length(); i++) {
            if(sb.indexOf(String.valueOf(s.charAt(i)))<0){
                if(map.containsKey(s.charAt(i))){
                    int count = map.get(s.charAt(i));
                    while (count!=0){
                        sb.append(s.charAt(i));
                        count--;
                    }
                }
            }
        }

     return sb.toString();
    }

    /*
    Write a SQL query to retrieve the total number of customers grouped by their gender from the "customers" table.

    select gender, count(customerId) as c from customers groupby gender having c<5;
    5,7,0



     */

    /*

    Given the following employees table structure:

Column  Type
employee_id INT
name    VARCHAR
department  VARCHAR
salary  DECIMAL
hire_date   DATE
Write an SQL query to find the number of employees in each department who earn a salary greater than 50,000.
The query should return two columns: the department name and the count of high earners in that department.
 The result should be grouped by department.

Expected Output:

department  high_earners
Sales   5
HR  3
IT  7
... ...
The output should list each department and the number of employees in that department whose salary exceeds 50,000.

    select department, count(employee_id)  as high_earners from employees where


     */

}
