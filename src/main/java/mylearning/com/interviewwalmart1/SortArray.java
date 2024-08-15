package mylearning.com.interviewwalmart1;

import java.util.Arrays;
//walmart
public class SortArray {

    public static void main(String[] args) {

        /*
input: - 16,9,18,128,3,27,15,64,21,2
Output - 2,8,16,64,128,3,9,15,21,27

Split array - 2,8,16,64,128   3,9,15,21,27

         */
        int [] input = {16,9,18,128,3,27,15,64,21,2};
        int [] output = sortArray(input);
        System.out.println(Arrays.toString(output));
    }

    private static int[] sortArray(int[] input) {

        int [] multipleOf2 = new int [input.length];
        int index1=0, index2=0;
        int [] multipleOf3 = new int [input.length];
// {16,9,18,128,3,27,15,64,21,2};
        for (int i = 0; i < input.length; i++) {
            if(input[i]%2==0){
                multipleOf2[index1] = input[i]; // 16,18, 128,64,2,/9 ,3,27,15,21
                index1++; //5
            }else if(input[i]%3==0){
                multipleOf3[index2] = input[i]; // 9,3,27,15,21
                index2++; // 5
            }
        }

        //Arrays.sort(multipleOf2);
       // Arrays.sort(multipleOf3);

        for (int i = index1, j=0; i < multipleOf2.length; i++, j++) {
            multipleOf2[i]= multipleOf3[j];
        }
        return multipleOf2;
    }

}
// id , name and age  --1, atul, 30, 1, atul,30, 1,bhavana,30, 3 atul,42

// select unique(id, name, age) from table;
