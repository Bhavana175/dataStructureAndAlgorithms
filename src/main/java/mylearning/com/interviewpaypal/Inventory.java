package mylearning.com.interviewpaypal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

public class Inventory {

    //Data structure HashMap<id, product>
    /*
    functional requirement
    1. isProductPresent() pId
    2. int availableQuantityForProduct() pId
    4. reserveQuantity()
    3. subtractQuantityForProduct() //after shipment
    4. load product //Already present
     */
    private HashMap<Integer, Product> productInventory;

    public Inventory(HashMap<Integer, Product> productInventory) {
        this.productInventory = productInventory;
    }

    public boolean isProductPresent(int productId) {
        return productInventory.containsKey(productId);
    }

    public int getAvailableQuantityForProduct(int productId) {
        if (isProductPresent(productId)) {
            Product p = productInventory.get(productId);
            return p.getSupply() - p.getDemand();
        }
        return 0;
    }

    //reserve quantity till shipment is out
    //method will be called after order is placed

    public boolean reserveQuantityForProduct(int productId, int orderQuantity) {
        Product product = productInventory.get(productId);
        if (getAvailableQuantityForProduct(productId) >= orderQuantity) {
            product.setDemand(product.getDemand() + orderQuantity);
            return true;
        } else {
            return false;
        }
    }

    //after shipment
    public void shipProductWithQuantity(int productId, int orderQuantity) { //TODO: shipProduct/dispatchProduct

        Product product = productInventory.get(productId);
        product.setSupply(product.getSupply() - orderQuantity);
        product.setDemand(product.getDemand() - orderQuantity);

    }

    public void listInventoryProducts() {
        productInventory.entrySet().stream().forEach((e) -> System.out.println(e.getValue()));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Product {

    private int productId;

    private String productName;

    private int supply;

    private int demand;

}
