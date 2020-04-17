import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CoinManagerTest {

    private static final int DIME = 1;
    private static CoinManager coinManager;
    @BeforeClass
    public static void setUp() {
        Map<Integer, Integer> coinHolding = new HashMap<>();
        Map<Integer, Integer> coinReturn = new HashMap<>();
        coinManager = new CoinManager(coinHolding, coinReturn);
    }

    @Test
    public void holdingCoin() {
        coinManager.reset();
        assertEquals(0, coinManager.holding(DIME));
    }

    @Test
    public void receiveCoin() {
        coinManager.reset();
        coinManager.receiveCoin(DIME);
        assertEquals(1, coinManager.holding(DIME));
    }

    @Test
    public void receiveMultiple() {
        coinManager.reset();
        coinManager.receiveCoin(DIME);
        coinManager.receiveCoin(DIME);
        assertEquals(2, coinManager.holding(DIME));
    }

    @Test
    public void inCoinReturn() {
        coinManager.reset();
        assertEquals(0, coinManager.inCoinReturn(DIME));
    }

    @Test
    public void toCoinReturn() {
        coinManager.reset();
        coinManager.toCoinReturn(DIME);
        assertEquals(1, coinManager.inCoinReturn(DIME));
    }

}
