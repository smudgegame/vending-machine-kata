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
    public void coinValue() {
        vendingMachine.reset();
        assertEquals("$0.1", vendingMachine.addCoin(1));
    }

    @Test
    public void noCoinDisplay() {
        vendingMachine.reset();
        assertEquals("INSERT COIN", vendingMachine.addCoin(0));
    }


    @Test
    public void nickleValue() {
        vendingMachine.reset();
        assertEquals("$0.05", vendingMachine.addCoin(3));
    }

    @Test
    public void quarterValue() {
        vendingMachine.reset();
        assertEquals("$0.25", vendingMachine.addCoin(4));
    }

    @Test
    public void rejectPennies() {
        vendingMachine.reset();
        assertEquals("INSERT COIN", vendingMachine.addCoin(2));
    }

}
