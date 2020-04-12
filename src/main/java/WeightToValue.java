import java.util.Map;

public class WeightToValue {

    private static final int DIME_VALUE = 10;
    private static final int NICKEL_VALUE = 5;
    private static final int DIME_WEIGHT = 1;
    private static final int NICKEL_WEIGHT = 3;
    private Map<Integer, Integer> valueMap;

    public WeightToValue(Map<Integer, Integer> valueMap) {
        this.valueMap = valueMap;
        valueMap.put(DIME_WEIGHT, DIME_VALUE);
        valueMap.put(NICKEL_WEIGHT, NICKEL_VALUE);
    }

    public int get(Coin coin) {
        return valueMap.getOrDefault(coin.getWeight(), 0);
    }
}
