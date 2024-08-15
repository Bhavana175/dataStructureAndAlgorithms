package mylearning.com.question;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        Integer [] arr = {-1, 5, 0,3, -2, -7, 5, 11, 6};
      ///  sortArrayElement(arr);
        Solution solution = new Solution();
        solution.usingSingleArray(arr);
    }

    private void usingSingleArray(Integer[] arr) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        for (int i = 0; i < lastIndex; i++) {
            if (arr[i] < 0) {
                if (arr[lastIndex]>0) {
                    int tempVar = arr[lastIndex];
                    arr[lastIndex] = arr[i];
                    arr[i] = tempVar;
                    lastIndex--;
                }
            }
        }   for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        System.out.println(firstIndex);

        List<Integer> ls = Arrays.asList(arr);
        ls.forEach(x -> System.out.println("element of list "+x));

    }

    public static int sortArrayElement(int[] arr) {
        int index = 0;
        int negativeIndex = 0;
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[index] = arr[i];
                index++;
            } else {
                temp[arr.length - 1 - negativeIndex] = arr[i];
                negativeIndex++;
            }

        }
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + ",");
        }
        System.out.println();
        System.out.println(index);
        return index;
    }

}
