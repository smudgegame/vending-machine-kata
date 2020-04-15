import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculateTest {

    private static final int DIME_WEIGHT = 1;
    private static final int NICKEL_WEIGHT = 3;
    private static final int QUARTER_WEIGHT = 4;

    private static Calculate calculate;

    @BeforeClass
    public static void setUp() {
        String product = "";

        Map<Integer, Integer> coinCount = new HashMap<>();
        Dispenser dispenser = new Dispenser(product, coinCount);

        Map<String, Integer> productPrice = new HashMap<>();
        Inventory inventory = new Inventory(productPrice, product);

        Map<Integer, Integer> valueMap = new HashMap<>();
        calculate = new Calculate(0, valueMap, inventory, dispenser);
    }

    @Test
    public void weightToValue() {
        assertEquals(10, calculate.value(DIME_WEIGHT));
    }

    @Test
    public void newCoinValue() {
        assertEquals(5, calculate.value(NICKEL_WEIGHT));
    }

    @Test
    public void quarterValue() {
        assertEquals(25, calculate.value(QUARTER_WEIGHT));
    }

    @Test
    public void isValidWeight() {
        assertTrue(calculate.isValid(QUARTER_WEIGHT));
    }
}
