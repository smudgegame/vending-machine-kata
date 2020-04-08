import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest {
    private static final int DIME_WEIGHT = 1;
    private static final int PENNY_WEIGHT = 2;
    private static final int NICKLE_WEIGHT = 3;
    private static final int QUARTER_WEIGHT = 4;
    private static final int DIME_VALUE = 10;
    private static final int PENNY_VALUE = 1;
    private static final int NICKLE_VALUE = 5;
    private static final int QUARTER_VALUE = 25;

    private static VendingMachine vendingMachine;

    @BeforeClass
    public static void setUp() {
        Map<Integer, Integer> coinHash = new HashMap<Integer, Integer>();
        coinHash.put(DIME_WEIGHT, DIME_VALUE);
        coinHash.put(PENNY_WEIGHT, PENNY_VALUE);
        coinHash.put(NICKLE_WEIGHT, NICKLE_VALUE);
        coinHash.put(QUARTER_WEIGHT, QUARTER_VALUE);

        vendingMachine = new VendingMachine(0, coinHash);
    }

    @Test
    public void coinWeight() {
        assertEquals(0, vendingMachine.getCoin(0));
    }

    @Test
    public void coinValue() {
        assertEquals(10, vendingMachine.getCoin(1));
    }

    @Test
    public void noCoinDisplay() {
        assertEquals("INSERT COIN", vendingMachine.display(0));
    }

    @Test
    public void displayCoinValue() {
        vendingMachine.reset();
        int sum = vendingMachine.getCoin(1);
        assertEquals("$0.10", vendingMachine.display(sum));
    }

    @Test
    public void pennyValue() {
        assertEquals(1, vendingMachine.getCoin(2));
    }

    @Test
    public void nickleValue() {
        assertEquals(5, vendingMachine.getCoin(3));
    }

    @Test
    public void quarterValue() {
        assertEquals(25, vendingMachine.getCoin(4));
    }

}
