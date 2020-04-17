import java.util.Map;

public class Inventory {

    private static final int COLA_PRICE = 100;
    private static final int CHIPS_PRICE = 50;
    private static final int CANDY_PRICE = 65;
    private Map<String, Integer> productPrice;
    private Map<String, Integer> productStock;
    private String currentProduct;

    public Inventory(Map<String, Integer> productStock, Map<String, Integer> productPrice, String currentProduct) {
        this.productStock = productStock;
        this.productPrice = productPrice;
        this.currentProduct = currentProduct;
        productPrice.put("cola", COLA_PRICE);
        productPrice.put("chips", CHIPS_PRICE);
        productPrice.put("candy", CANDY_PRICE);
        productPrice.put("reset", 0);
    }

    public String getProduct() {
        return currentProduct;
    }

    public int getPrice() {
        return productPrice.get(currentProduct);
    }

    public void setProduct(String product) {
        currentProduct = product.toLowerCase();
    }

    public void stock(String product, int toStock) {
        productStock.put(product, toStock);
    }

    public boolean inStock() {
        return productStock.getOrDefault(currentProduct,0) != 0;
    }

    public void purchase(String product) {
        int currentStock = productStock.get(product);
        productStock.put(product, currentStock - 1);
    }

    public void resetSelection() {
        currentProduct = "";
    }

    public void clearStock() {
        productStock.clear();
    }
}
