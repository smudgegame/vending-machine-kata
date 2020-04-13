import java.util.Map;

public class CoinReturn {

    private Map<Integer, Integer> coinCount;

    public CoinReturn(Map<Integer, Integer> coinCount) {
        this.coinCount = coinCount;
    }

    public int amountOf(int weight) {
        return coinCount.getOrDefault(weight, 0);
    }

    public void toReturn(int weight) {
        int currentCount = coinCount.getOrDefault(weight, 0);
        coinCount.put(weight, currentCount + 1);
    }
}
