package mylearning.com.interviewpaypal;

import java.util.HashMap;

public class Solution {
//paypal
/*
  Build in-memory inventory management system only for order processing.
  Inventory management refers to the process of ordering, storing,
  using, and selling a company's inventory.
- Assume stocks are already loaded and not need to implement APIs for stock loading.
- Assume utility methods are already available for payment processing.

*/

/*
functional requirement
inventory magmt system
// order product A, 5 quantity
1. isProductPresent
2. isQuantityAvailable
3. get Available quantity (supply-demand) order
4. placeInventoryOrder //subtract quantity
5. loadInventory method already available
6. shipFromInventory // supply-1, demand-1
 */

    public static void main(String[] args) {

        Product p1= new Product(1,"Pen",20,0);
        Product p2= new Product(2,"Pencil",20,0);
        Product p3= new Product(3,"Water Bottle",20,0);
        Product p4= new Product(4,"Watch",20,0);
        Product p5= new Product(5,"Books",20,0);
        Product p6= new Product(6,"Bag",20,0);
        Product p7= new Product(7,"Tie",20,0);

        HashMap<Integer, Product> productHashMap = new HashMap<>();

        productHashMap.put(p1.getProductId(), p1);
        productHashMap.put(p2.getProductId(), p2);
        productHashMap.put(p3.getProductId(), p3);
        productHashMap.put(p4.getProductId(), p4);
        productHashMap.put(p5.getProductId(), p5);
        productHashMap.put(p6.getProductId(), p6);
        productHashMap.put(p7.getProductId(), p7);

        Inventory inventory = new Inventory(productHashMap);
        inventory.listInventoryProducts();
        inventory.reserveQuantityForProduct(1,9);
        inventory.reserveQuantityForProduct(1,1);
        System.out.println("****************************");
        inventory.listInventoryProducts();
        System.out.println("****************************");
        System.out.println(inventory.isProductPresent(1));
        System.out.println(inventory.getAvailableQuantityForProduct(1));
        inventory.shipProductWithQuantity(1,8);
        System.out.println("****************************");
        inventory.listInventoryProducts();
    }

}
