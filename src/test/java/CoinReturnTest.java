import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    @Test
    public void inReturn() {
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        assertEquals(0, coinReturn.amountOf(1));
    }

    @Test
    public void toReturn() {
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        coinReturn.toReturn(1);
        assertEquals(1, coinReturn.amountOf(1));
    }

}
