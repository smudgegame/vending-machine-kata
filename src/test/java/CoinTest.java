import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    @Test
    public void getWeight() {
        Coin coin = new Coin(1);
        assertEquals(1, coin.getWeight());
    }


}
