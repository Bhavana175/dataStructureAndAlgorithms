package mylearning.com.programs;

public class BinaryGap {

    public static void main(String args[]) {
        BinaryGap binaryGap = new BinaryGap();
        int gap = binaryGap.solution(1041);
        System.out.println("longest binary gap " + gap);
    }

    public int solution(int number) {
        // write your code in Java SE 8

        int dividend;
        int i = 0;
        int[] binaryArr = new int[32];
        boolean flag = true;
        int countGap = 0;
        do {
            dividend = number % 2;
            binaryArr[i] = dividend;
            number = number / 2;
            if (number > 0) {
                flag = true;

            } else {
                flag = false;
            }
            i++;
        } while (flag);

        int max = 0;
        //find gap binary gap
        for (int j = 0; j < i; j++) {
                     //find 1 first
            if (binaryArr[j] == 1) {
                for (int k = j + 1; k < i; k++) {
                       //count zeros
                    if (binaryArr[k] == 0) {
                        countGap++;
                    } else {
                        //found 1
                        //check for longest gap
                        if (max < countGap) {
                            max = countGap;
                        }
                        //reset count
                        countGap = 0;
                        break;
                    }

                }

            }
        }

        return max;
    }

}
