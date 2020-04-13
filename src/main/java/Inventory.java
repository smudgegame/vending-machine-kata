import java.util.Map;

public class Inventory {

    private static final int COLA_PRICE = 100;
    private final Map<String, Integer> productPrice;


    public Inventory(Map<String, Integer> productPrice) {
        this.productPrice = productPrice;
        productPrice.put("cola",COLA_PRICE);
    }

    public int getPrice(String product) {
        return productPrice.get(product.toLowerCase());
    }
}
