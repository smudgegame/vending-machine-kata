import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WeightToTest {

    private static final int DIME_WEIGHT = 1;
    private static final int NICKEL_WEIGHT = 3;
    private static final int QUARTER_WEIGHT = 4;

    @Test
    public void weightToValue() {
        Map<Integer, Integer> valueMap = new HashMap<>();
        WeightTo weightTo = new WeightTo(valueMap);
        assertEquals(10, weightTo.value(DIME_WEIGHT));
    }

    @Test
    public void newCoinValue() {
        Map<Integer, Integer> valueMap = new HashMap<>();
        WeightTo weightTo = new WeightTo(valueMap);
        assertEquals(5, weightTo.value(NICKEL_WEIGHT));
    }

    @Test
    public void quarterValue() {
        Map<Integer, Integer> valueMap = new HashMap<>();
        WeightTo weightTo = new WeightTo(valueMap);
        assertEquals(25, weightTo.value(QUARTER_WEIGHT));
    }

    @Test
    public void isValidWeight() {
        Map<Integer, Integer> valueMap = new HashMap<>();
        WeightTo weightTo = new WeightTo(valueMap);
        assertTrue(weightTo.isValid(QUARTER_WEIGHT));
    }

}
