package mylearning.com.question.arrays;

public class SumSubArrayMin {

    public static void main(String[] args) {

        int[] arr= {2,1,3};
        SumSubArrayMin obj =new SumSubArrayMin();

        System.out.println("output : "+obj.sumSubarrayMins(arr));

    }

    public int sumSubarrayMins(int[] arr) {

        int sum =0;

        for(int i=0; i<arr.length; i++){

            //single sub array
            sum= sum+arr[i];
            //double sub array min value
            if(i+1<arr.length ){
                if( arr[i]<arr[i+1]) {
                    sum = sum + arr[i];
                }else {
                    sum=sum+arr[i+1];
                }
            }


        }




        return sum;

    }
}
