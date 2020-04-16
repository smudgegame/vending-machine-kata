import java.util.Map;

public class CoinManager {

    private final Map<Integer, Integer> coinHolding;

    public CoinManager(Map<Integer, Integer> coinHolding) {
        this.coinHolding = coinHolding;
    }


    public int holding(int weight) {
        return coinHolding.getOrDefault(weight,0);
    }
}
