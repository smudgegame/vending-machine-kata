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
    private static Coin dime = new Coin(DIME);
    private static Coin penny = new Coin(PENNY);
    private static Coin nickel = new Coin(NICKEL);
    private static Coin quarter = new Coin(QUARTER);
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
        assertTrue(weightTo.isValid(dime));
    }

    @Test
    public void coinValue() {
        assertEquals(10, weightTo.value(dime));
    }

    @Test(expected = IllegalArgumentException.class)
    public void coinValueIfValid() {
        weightTo.value(penny);
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

    @Test
    public void nicklesAreValid() {
        assertTrue(weightTo.isValid(nickel));
    }

    @Test
    public void quartersAreValid() {
        assertTrue(weightTo.isValid(quarter));
    }

}
