import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {

    private static final int DIME = 1;
    private static final int PENNY = 2;

    @Test
    public void validCoin() {
        Coin coin = new Coin(DIME);
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        VendingMachine vendingMachine = new VendingMachine(0, coinReturn);
        assertTrue(vendingMachine.isValid(coin));
    }

    @Test
    public void coinValue() {
        Coin coin = new Coin(DIME);
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        VendingMachine vendingMachine = new VendingMachine(0, coinReturn);
        assertEquals(10, vendingMachine.getValue(coin));
    }

    @Test
    public void coinValueIfValid() {
        Coin coin = new Coin(PENNY);
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        VendingMachine vendingMachine = new VendingMachine(0, coinReturn);
        assertEquals(0, vendingMachine.getValue(coin));
    }

    @Test
    public void insertCoinDisplay() {
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        VendingMachine vendingMachine = new VendingMachine(0, coinReturn);
        assertEquals("INSERT COIN", vendingMachine.display());
    }

    @Test
    public void insertCoin() {
        Coin dime = new Coin(DIME);
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        VendingMachine vendingMachine = new VendingMachine(0, coinReturn);
        vendingMachine.insertCoin(dime);
        assertEquals("$0.1", vendingMachine.display());
    }

    @Test
    public void invalidCoinToReturn() {
        Coin penny = new Coin(PENNY);
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        VendingMachine vendingMachine = new VendingMachine(0, coinReturn);
        vendingMachine.insertCoin(penny);
        assertEquals(1, coinReturn.amountOf(penny));
    }

}
