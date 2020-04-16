import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CoinManagerTest {

    private static final int DIME = 1;

    @Test
    public void holdingCoin() {
        Map<Integer, Integer> coinHolding = new HashMap<>();
        CoinManager coinManager = new CoinManager(coinHolding);
        assertEquals(0, coinManager.holding(DIME));
    }

    @Test
    public void receiveCoin() {
        Map<Integer, Integer> coinHolding = new HashMap<>();
        CoinManager coinManager = new CoinManager(coinHolding);
        coinManager.receiveCoin(DIME);
        assertEquals(1, coinManager.holding(DIME));
    }
}
