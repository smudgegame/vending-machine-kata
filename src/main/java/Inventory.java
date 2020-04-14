import java.util.Map;

public class Inventory {

    private static final int COLA_PRICE = 100;
    private Map<String, Integer> productPrice;
    private String currentProduct;


    public Inventory(Map<String, Integer> productPrice, String currentProduct) {
        this.productPrice = productPrice;
        this.currentProduct = currentProduct;
        productPrice.put("cola", COLA_PRICE);
    }

    public String getProduct() {
        return currentProduct;
    }

    public int getPrice() {
        return productPrice.getOrDefault(currentProduct,0);
    }

    public void setProduct(String product) {
        currentProduct = product.toLowerCase();
    }

    public void resetSelection() {
        currentProduct = "";
    }
}
