import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    @Test
    public void inReturn() {
        Coin coin = new Coin(1);
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        assertEquals(0, coinReturn.amountOf(coin));
    }

    @Test
    public void toReturn() {
        Coin coin = new Coin(1);
        Map<Integer, Integer> coinCount = new HashMap<>();
        CoinReturn coinReturn = new CoinReturn(coinCount);
        coinReturn.toReturn(coin);
        assertEquals(1, coinReturn.amountOf(coin));
    }

}
