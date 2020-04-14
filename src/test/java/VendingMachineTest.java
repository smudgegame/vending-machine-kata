import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final int DIME = 1;
    private static final int PENNY = 2;
    private static final int NICKEL = 3;
    private static final int QUARTER = 4;
    private static VendingMachine vendingMachine;
    private static Dispenser dispenser;
    private static WeightTo weightTo;
    private static Inventory inventory;

    @BeforeClass
    public static void setUp() {
        Map<Integer, Integer> valueMap = new HashMap<>();
        weightTo = new WeightTo(valueMap);

        Map<String, Integer> inDispenser = new HashMap<>();
        Map<Integer, Integer> coinCount = new HashMap<>();
        dispenser = new Dispenser(inDispenser, coinCount);

        String product = "";
        Map<String, Integer> productPrice = new HashMap<>();
        inventory = new Inventory(productPrice, product);
        vendingMachine = new VendingMachine(0, dispenser, weightTo, inventory);
    }

    @Test
    public void validCoin() {
        assertTrue(weightTo.isValid(DIME));
    }

    @Test
    public void coinValue() {
        assertEquals(10, weightTo.value(DIME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void coinValueIfValid() {
        weightTo.value(PENNY);
    }

    @Test
    public void insertCoinDisplay() {
        vendingMachine.reset();
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void insertCoin() {
        vendingMachine.insertCoin(DIME);
        assertEquals("$0.1", vendingMachine.display());
    }

    @Test
    public void invalidCoinToReturn() {
        vendingMachine.insertCoin(PENNY);
        assertEquals(1, dispenser.inCoinReturn(PENNY));
    }

    @Test
    public void nicklesAreValid() {
        assertTrue(weightTo.isValid(NICKEL));
    }

    @Test
    public void quartersAreValid() {
        assertTrue(weightTo.isValid(QUARTER));
    }

    @Test
    public void selectProduct() {
        vendingMachine.select("cola");
        assertEquals("cola", inventory.getProduct());
    }

}
