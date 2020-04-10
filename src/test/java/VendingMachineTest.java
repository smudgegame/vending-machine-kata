import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final int DIME = 1;
    private static final int NICKEL = 3;

    private static VendingMachine vendingMachine;

    @BeforeClass
    public static void setUp() {
        Map<Integer, Integer> coinValue = new HashMap<>();
        coinValue.put(DIME,10);
        coinValue.put(NICKEL,5);
        vendingMachine = new VendingMachine(0, coinValue);
    }

    @Test
    public void isValidCoin() {
        assertTrue(vendingMachine.isValid(DIME));
    }

    @Test
    public void insertCoin() {
        assertEquals(10, vendingMachine.insertCoin(DIME));
    }

    @Test
    public void insertCoinDisplay() {
        VendingMachine vendingMachine = new VendingMachine(0, new HashMap<>());
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void oneCoinValueDisplayed() {
        Map<Integer, Integer> coinValue = new HashMap<>();
        coinValue.put(DIME,10);
        VendingMachine vendingMachine = new VendingMachine(0, coinValue);
        vendingMachine.insertCoin(DIME);
        assertEquals("$0.1", vendingMachine.display());
        //TODO this should read $0.10
    }

    @Test
    public void twoCoinValueDisplayed() {
        Map<Integer, Integer> coinValue = new HashMap<>();
        coinValue.put(DIME,10);
        VendingMachine vendingMachine = new VendingMachine(0, coinValue);
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
    public void coinValueHash() {
        Map<Integer, Integer> coinValue = new HashMap<>();
        coinValue.put(DIME,10);
        VendingMachine vendingMachine = new VendingMachine(0, coinValue);
        assertEquals(10, vendingMachine.insertCoin(DIME));
    }

}
