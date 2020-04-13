import java.util.Map;

public class WeightTo {

    private static final int DIME_VALUE = 10;
    private static final int NICKEL_VALUE = 5;
    private static final int QUARTER_VALUE = 25;
    private static final int DIME_WEIGHT = 1;
    private static final int NICKEL_WEIGHT = 3;
    private static final int QUARTER_WEIGHT = 4;
    private Map<Integer, Integer> valueMap;

    public WeightTo(Map<Integer, Integer> valueMap) {
        this.valueMap = valueMap;
        valueMap.put(DIME_WEIGHT, DIME_VALUE);
        valueMap.put(NICKEL_WEIGHT, NICKEL_VALUE);
        valueMap.put(QUARTER_WEIGHT, QUARTER_VALUE);
    }

    public boolean isValid(int weight) {
        return valueMap.containsKey(weight);
    }

    public int value(int weight) {
        if (!isValid(weight)) throw new IllegalArgumentException();
        return valueMap.get(weight);
    }
}
