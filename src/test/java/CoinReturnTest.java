import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    @Test
    public void inReturn() {
        Coin coin = new Coin(1);
        CoinReturn coinReturn = new CoinReturn();
        assertEquals(1, CoinReturn.amountOf(coin));
    }
}
