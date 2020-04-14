import java.util.Map;

public class Dispenser {

    private Map<String, Integer> inDispenser;
    private Map<Integer, Integer> coinCount;

    public Dispenser(Map<String, Integer> inDispenser, Map<Integer, Integer> coinCount) {
        this.inDispenser = inDispenser;
        this.coinCount = coinCount;
    }

    public int amountOf(String product) {
        return inDispenser.getOrDefault(product, 0);
    }

    public int inCoinReturn(int weight) {
        return coinCount.getOrDefault(weight, 0);
    }

    public void toCoinReturn(int weight) {
        int currentCount = coinCount.getOrDefault(weight, 0);
        coinCount.put(weight, currentCount + 1);
    }
}
