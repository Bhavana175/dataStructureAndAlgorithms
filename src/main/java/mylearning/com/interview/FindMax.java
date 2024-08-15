package mylearning.com.interview;

public class FindMax {
//Cognizant
    public static void main(String[] args) {
        int[] arr = {1, 20, 2, 3, 3, 5, 6, 7};

//find max

        int maxVal = 0;
        for (int i = 0; i < arr.length; i++) {

            if (maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }

        System.out.println(maxVal);
    }

}
