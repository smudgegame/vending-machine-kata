import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    @Test
    public void productPrice() {
        String product = "";
        Map<String, Integer> productPrice = new HashMap<>();
        Inventory inventory = new Inventory(productPrice, product);
        assertEquals(100, inventory.getPrice("cola"));
    }

    @Test
    public void getProduct() {
        String currentProduct = "cola";
        Map<String, Integer> productPrice = new HashMap<>();
        Inventory inventory = new Inventory(productPrice, currentProduct);
        assertEquals("cola", inventory.getProduct());
    }

}
