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
    private static CoinReturn coinReturn;
    private static WeightTo weightTo;

    @BeforeClass
    public static void setUp() {
        Map<Integer, Integer> coinCount = new HashMap<>();
        Map<Integer, Integer> valueMap = new HashMap<>();
        weightTo = new WeightTo(valueMap);
        coinReturn = new CoinReturn(coinCount);
        vendingMachine = new VendingMachine(0, coinReturn, weightTo);
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
        assertEquals(1, coinReturn.amountOf(PENNY));
    }

    @Test
    public void nicklesAreValid() {
        assertTrue(weightTo.isValid(NICKEL));
    }

    @Test
    public void quartersAreValid() {
        assertTrue(weightTo.isValid(QUARTER));
    }

}
