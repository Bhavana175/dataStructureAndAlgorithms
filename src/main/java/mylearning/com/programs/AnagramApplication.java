package mylearning.com.programs;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AnagramApplication {

    public static void main(String[] args) {

        //SpringApplication.run(LearningApplication.class, args);
Integer num = 10;
num++;
        System.out.println(num);
        String str1 = "list";
        String str2 = "silent";
        int removedItems = getRemovedItemsBigOofMN(str1, str2);
        System.out.println(removedItems);
        int removedItemsFromAnagram = getRemovedItemsBigOofN(str1, str2);
        System.out.println(removedItemsFromAnagram);
    }

    private static int getRemovedItemsBigOofN(String str1, String str2) {

        Map<Character, Integer> anagramElements = new HashMap<>();
        int count = 0;

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        for (char c : array1) {
            if (anagramElements.containsKey(c)) {
                anagramElements.put(c, anagramElements.get(c) + 1);
            } else {
                anagramElements.put(c, 1);
            }
        }

        for (char key : array2) {
            if (anagramElements.containsKey(key)) {
                anagramElements.put(key, anagramElements.get(key) - 1);
            } else {
                anagramElements.put(key, 1);
            }
        }

        Collection<Integer> values = anagramElements.values();
        for (Integer i : values) {
            count = count + i;
        }
        return count;

    }

    private static int getRemovedItemsBigOofMN(String str1, String str2) {
        boolean flag = false;
        int removedItems = 0;
        for (int i = 0; i < str1.length(); i++) {
            flag = false;
            for (int j = 0; j < str2.length(); j++) {
                if ((str2.charAt(j)) == str1.charAt(i)) {
                    str2 = str2.substring(0, j) + str2.substring(j + 1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                removedItems++;
            }
        }
        removedItems = removedItems + str2.length();
        return removedItems;
    }

}
