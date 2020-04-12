import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightToValueTest {

    private static final int DIME = 1;

    @Test
    public void weightToValue() {
        Coin coin = new Coin(DIME);
        WeightToValue weightToValue = new WeightToValue();
        assertEquals(10, weightToValue.get(coin));
    }
}
