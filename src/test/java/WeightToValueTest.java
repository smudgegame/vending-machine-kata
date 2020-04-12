import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WeightToValueTest {

    private static final int DIME_WEIGHT = 1;
    private static final int NICKEL_WEIGHT = 3;

    @Test
    public void weightToValue() {
        Coin coin = new Coin(DIME_WEIGHT);
        Map<Integer, Integer> valueMap = new HashMap<>();
        WeightToValue weightToValue = new WeightToValue(valueMap);
        assertEquals(10, weightToValue.get(coin));
    }

    @Test
    public void newCoinValue() {
        Coin coin = new Coin(NICKEL_WEIGHT);
        Map<Integer, Integer> valueMap = new HashMap<>();
        WeightToValue weightToValue = new WeightToValue(valueMap);
        assertEquals(5, weightToValue.get(coin));
    }
}
