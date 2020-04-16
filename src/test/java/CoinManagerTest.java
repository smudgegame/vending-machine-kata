import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CoinManagerTest {

    private static final int DIME = 1;

    @Test
    public void holdingCoin() {
        Map<Integer, Integer> coinHolding = new HashMap<>();
        Map<Integer, Integer> coinReturn = new HashMap<>();
        CoinManager coinManager = new CoinManager(coinHolding, coinReturn);
        assertEquals(0, coinManager.holding(DIME));
    }

    @Test
    public void receiveCoin() {
        Map<Integer, Integer> coinHolding = new HashMap<>();
        Map<Integer, Integer> coinReturn = new HashMap<>();
        CoinManager coinManager = new CoinManager(coinHolding, coinReturn);
        coinManager.receiveCoin(DIME);
        assertEquals(1, coinManager.holding(DIME));
    }

    @Test
    public void receiveMultiple() {
        Map<Integer, Integer> coinHolding = new HashMap<>();
        Map<Integer, Integer> coinReturn = new HashMap<>();
        CoinManager coinManager = new CoinManager(coinHolding, coinReturn);
        coinManager.receiveCoin(DIME);
        coinManager.receiveCoin(DIME);
        assertEquals(2, coinManager.holding(DIME));
    }

    @Test
    public void inCoinReturn() {
        Map<Integer, Integer> coinHolding = new HashMap<>();
        Map<Integer, Integer> coinReturn = new HashMap<>();
        CoinManager coinManager = new CoinManager(coinHolding, coinReturn);
        assertEquals(0, coinManager.inCoinReturn(DIME));
    }

    @Test
    public void toCoinReturn() {
        Map<Integer, Integer> coinHolding = new HashMap<>();
        Map<Integer, Integer> coinReturn = new HashMap<>();
        CoinManager coinManager = new CoinManager(coinHolding, coinReturn);
        coinManager.toCoinReturn(DIME);
        assertEquals(1, coinManager.inCoinReturn(DIME));
    }
}
