package leetcode.dailyquestion;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {

       int [] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {

        int product = 1;
        int [] productArr = new int [nums.length];

        for (int i = 0; i < nums.length; i++) {
            product *=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
            productArr[i] = product/nums[i];
            }else {
                int newProduct =1;
                for (int j = 0; j < nums.length; j++) {
                    if(j!=i){
                        newProduct *=nums[j];
                    }
                }
                productArr[i] = newProduct;
            }
        }

        return productArr;
    }
}
