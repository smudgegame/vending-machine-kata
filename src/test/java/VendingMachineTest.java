import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final int DIME = 1;
    private static final int PENNY = 2;
    private static Coin dime = new Coin(DIME);
    private static Coin penny = new Coin(PENNY);
    private static VendingMachine vendingMachine;
    private static CoinReturn coinReturn;

    @BeforeClass
    public static void setUp() {

        Map<Integer, Integer> coinCount = new HashMap<>();
        coinReturn = new CoinReturn(coinCount);
        vendingMachine = new VendingMachine(0, coinReturn);
    }

    @Test
    public void validCoin() {
        assertTrue(vendingMachine.isValid(dime));
    }

    @Test
    public void coinValue() {
        assertEquals(10, vendingMachine.getValue(dime));
    }

    @Test
    public void coinValueIfValid() {
        assertEquals(0, vendingMachine.getValue(penny));
    }

    @Test
    public void insertCoinDisplay() {
        vendingMachine.reset();
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void insertCoin() {
        vendingMachine.insertCoin(dime);
        assertEquals("$0.1", vendingMachine.display());
    }

    @Test
    public void invalidCoinToReturn() {
        vendingMachine.insertCoin(penny);
        assertEquals(1, coinReturn.amountOf(penny));
    }

}
