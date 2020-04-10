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

    @BeforeClass
    public static void setUp() {
        Map<Integer, Integer> coinValue = new HashMap<>();
        coinValue.put(DIME, 10);
        coinValue.put(NICKEL, 5);
        coinValue.put(QUARTER, 25);
        Map<Integer, Integer> coinReturn = new HashMap<>();
        vendingMachine = new VendingMachine(0, coinValue, coinReturn);
    }

    @Test
    public void isValidCoin() {
        assertTrue(vendingMachine.isValid(DIME));
    }

    @Test
    public void insertCoinDisplay() {
        vendingMachine.reset();
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void oneCoinValueDisplayed() {
        vendingMachine.reset();
        vendingMachine.insertCoin(DIME);
        assertEquals("$0.1", vendingMachine.display());
        //TODO this should read $0.10
    }

    @Test
    public void twoCoinValueDisplayed() {
        vendingMachine.reset();
        vendingMachine.insertCoin(DIME);
        vendingMachine.insertCoin(DIME);
        assertEquals("$0.2", vendingMachine.display());
        //TODO this should read $0.20
    }

    @Test
    public void acceptOtherValidCoin() {
        assertTrue(vendingMachine.isValid(NICKEL));
    }

    @Test
    public void toCoinReturn() {
        vendingMachine.insertCoin(PENNY);
        assertEquals(1, vendingMachine.inCoinReturn(PENNY));
    }

    @Test
    public void test() {
        vendingMachine.reset();
        vendingMachine.insertCoin(PENNY);
        vendingMachine.insertCoin(PENNY);
        assertEquals(2,vendingMachine.inCoinReturn(PENNY));
    }

}
