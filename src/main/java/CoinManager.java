import java.util.Map;

public class CoinManager {

    private final Map<Integer, Integer> coinHolding;
    private Map<Integer, Integer> coinReturn;

    public CoinManager(Map<Integer, Integer> coinHolding, Map<Integer, Integer> coinReturn) {
        this.coinHolding = coinHolding;
        this.coinReturn = coinReturn;
    }

    public int holding(int weight) {
        return coinHolding.getOrDefault(weight, 0);
    }

    public void receiveCoin(int weight) {
        int currentCount = coinHolding.getOrDefault(weight, 0);
        coinHolding.put(weight, currentCount + 1);
    }

    public int inCoinReturn(int weight) {
        return coinReturn.getOrDefault(weight, 0);
    }

    public void toCoinReturn(int weight) {
        int currentCount = coinReturn.getOrDefault(weight, 0);
        coinReturn.put(weight, currentCount + 1);
    }

    public void reset() {
        coinReturn.clear();
        coinHolding.clear();
    }

}
