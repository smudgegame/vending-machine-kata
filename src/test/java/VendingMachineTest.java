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


    private static VendingMachine vendingMachine;

    @BeforeClass
    public static void setUp() {
        Map<Integer, Integer> coinHash = new HashMap<Integer, Integer>();

        vendingMachine = new VendingMachine(0);
    }


    @Test
    public void coinValue() {
        vendingMachine.reset();
        assertEquals("$0.1", vendingMachine.insertCoin(1));
    }

    @Test
    public void noCoinDisplay() {
        vendingMachine.reset();
        assertEquals("INSERT COIN", vendingMachine.insertCoin(0));
    }


    @Test
    public void nickleValue() {
        vendingMachine.reset();
        assertEquals("$0.05", vendingMachine.insertCoin(3));
    }

    @Test
    public void quarterValue() {
        vendingMachine.reset();
        assertEquals("$0.25", vendingMachine.insertCoin(4));
    }

    @Test
    public void rejectPennies() {
        vendingMachine.reset();
        assertEquals("INSERT COIN", vendingMachine.insertCoin(2));
    }

}
