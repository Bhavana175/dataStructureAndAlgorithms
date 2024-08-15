package mylearning.com.interviewMicrosoft;

import java.util.HashMap;

public class Solution {


    /*
    pair of shoes
    based on color return number of pairs shoes sale
    based on size
    based on both

     */

    public static void main(String[] args) {
        double size =6.0;
        String color = "brown";
       // int numberOfShoes = fetchNumberOfShoesForSale(size);
       // int numberOfShoes1 = fetchNumberOfShoesForSaleForColor(color);

        HashMap<String, Integer> colorCatalogMap = new HashMap<>();
        //colorCatalogMap.put("",)
    }



/*
    private int fetchNumberOfShoesForSaleForColor(String color,double size ) {

        //left and right count should match to sell the shoes
    */
/*
    count : based on color : 55 green
    from 55 shoes
    left shoe : 20
    right shoe: 35
    return min(left, right);
     *//*



    }

    private int fetchNumberOfShoesForSale(double size) {
    }
*/

}

class Shoes{

    String color;
    String size;

    public Shoes(String color, String size) {
        this.color = color;
        this.size = size;
    }
}
