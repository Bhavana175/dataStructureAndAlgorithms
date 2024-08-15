package mylearning.com.streams;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String[] args) {

        int[] array = new int[] {5, 1, 7, 3, 9, 6};
        int len =array.length-1;

        int[] reversedArray = IntStream
                .rangeClosed(0, len)
                .map(i-> array[len-i])
                .toArray();

        for (int i=0; i<=len/2; i++){
            int temp = array[i];
            array[i] = array[len-i];
            array[len-i] = temp;
        }

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reversedArray));


        //first 10 even num

        IntStream.rangeClosed(1,10).map(i-> i*2).forEach(System.out::println);

    }

}
