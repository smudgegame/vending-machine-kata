import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    private static Inventory inventory;
    private static Map<String, Integer> productStock;

    @BeforeClass
    public static void setUp() {
        String product = "";
        Map<String, Integer> productPrice = new HashMap<>();
        productStock = new HashMap<>();
        inventory = new Inventory(productStock, productPrice, product);
    }

    @Test
    public void setProduct() {
        inventory.setProduct("cola");
        assertEquals("cola", inventory.getProduct());
    }

    @Test
    public void getProduct() {
        inventory.resetSelection();
        assertEquals("", inventory.getProduct());
    }

    @Test
    public void productPrice() {
        inventory.setProduct("cola");
        assertEquals(100, inventory.getPrice());
    }

    @Test
    public void chipsProduct() {
        inventory.setProduct("chips");
        assertEquals(50, inventory.getPrice());
    }

    @Test
    public void candyProduct() {
        inventory.setProduct("candy");
        assertEquals(65, inventory.getPrice());
    }

    @Test
    public void productStock() {
        inventory.stock("cola", 5);
        int inStock = productStock.get("cola");
        assertEquals(5, inStock);
    }

    @Test
    public void productPurchased() {
        inventory.stock("cola", 5);
        inventory.purchase("cola");
        inventory.purchase("cola");
        assertEquals(3, inventory.inStock("cola"));
    }

}
