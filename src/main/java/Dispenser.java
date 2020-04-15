import java.util.Map;

public class Dispenser {

    private String product;
    private Map<Integer, Integer> coinCount;

    public Dispenser(String product, Map<Integer, Integer> coinCount) {
        this.product = product;
        this.coinCount = coinCount;
    }

    public String inDispenser() {
        return product;
    }

    public void dispense(String product) {
        this.product = product;
    }

    public int inCoinReturn(int weight) {
        return coinCount.getOrDefault(weight, 0);
    }

    public void toCoinReturn(int weight) {
        int currentCount = coinCount.getOrDefault(weight, 0);
        coinCount.put(weight, currentCount + 1);
    }
}
