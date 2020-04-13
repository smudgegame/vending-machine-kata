import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    @Test
    public void productPrice() {
        Map<String, Integer> productPrice = new HashMap<>();
        Inventory inventory = new Inventory(productPrice);
        assertEquals(100, inventory.getPrice("cola"));
    }

}
