import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CalculateTest {

    private static final int DIME = 1;
    private static final int PENNY = 2;
    private static final int NICKEL = 3;
    private static final int QUARTER = 4;

    private static Calculate calculate;
    private static Inventory inventory;

    @BeforeClass
    public static void setUp() {
        String product = "";
        Dispenser dispenser = new Dispenser(product);

        Map<String, Integer> productPrice = new HashMap<>();
        inventory = new Inventory(productPrice, product);

        Map<Integer, Integer> valueMap = new HashMap<>();
        calculate = new Calculate(0, valueMap, inventory, dispenser);
    }

    @Test
    public void validCoin() {
        assertTrue(calculate.isValid(DIME));
    }

    @Test
    public void coinValue() {
        assertEquals(10, calculate.value(DIME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void coinValueIfValid() {
        calculate.value(PENNY);
    }

    @Test
    public void nicklesAreValid() {
        assertTrue(calculate.isValid(NICKEL));
    }

    @Test
    public void quartersAreValid() {
        assertTrue(calculate.isValid(QUARTER));
    }

    @Test
    public void weightToValue() {
        assertEquals(10, calculate.value(DIME));
    }

    @Test
    public void newCoinValue() {
        assertEquals(5, calculate.value(NICKEL));
    }

    @Test
    public void quarterValue() {
        assertEquals(25, calculate.value(QUARTER));
    }

    @Test
    public void isValidWeight() {
        assertTrue(calculate.isValid(QUARTER));
    }

    @Test
    public void credit() {
        calculate.setSum(100);
        inventory.setProduct("candy");
        assertEquals(35, calculate.credit(inventory.getPrice()));
    }

    @Test
    public void makeChange() {
        calculate.setSum(105);
        inventory.setProduct("candy");
        List<Integer> change = new ArrayList<>();
        change.add(QUARTER);
        change.add(DIME);
        change.add(NICKEL);
        assertEquals(change, calculate.change());
    }

}
