import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    private static Inventory inventory;

    @BeforeClass
    public static void setUp() {
        String product = "";
        Map<String, Integer> productPrice = new HashMap<>();
        inventory = new Inventory(productPrice, product);
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
    public void chipsProduct(){
        inventory.setProduct("chips");
        assertEquals(50,inventory.getPrice());
    }

}
