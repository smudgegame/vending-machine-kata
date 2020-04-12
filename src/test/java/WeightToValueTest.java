import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class WeightToValueTest {

    private static final int DIME_WEIGHT = 1;
    private static final int NICKEL_WEIGHT = 3;
    private static final int QUARTER_WEIGHT = 4;

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

    @Test
    public void quarterValue() {
        Coin coin = new Coin(QUARTER_WEIGHT);
        Map<Integer, Integer> valueMap = new HashMap<>();
        WeightToValue weightToValue = new WeightToValue(valueMap);
        assertEquals(25, weightToValue.get(coin));
    }


}
