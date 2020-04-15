import java.util.Map;

public class Inventory {

    private static final int COLA_PRICE = 100;
    private static final int CHIPS_PRICE = 50;
    private static final int CANDY_PRICE = 65;
    private Map<String, Integer> productPrice;
    private String currentProduct;

    public Inventory(Map<String, Integer> productPrice, String currentProduct) {
        this.productPrice = productPrice;
        this.currentProduct = currentProduct;
        productPrice.put("cola", COLA_PRICE);
        productPrice.put("chips", CHIPS_PRICE);
        productPrice.put("candy", CANDY_PRICE);
    }

    public String getProduct() {
        return currentProduct;
    }

    public int getPrice() {
        return productPrice.getOrDefault(currentProduct, 0);
    }

    public void setProduct(String product) {
        currentProduct = product.toLowerCase();
    }

    public void resetSelection() {
        currentProduct = "";
    }
}
