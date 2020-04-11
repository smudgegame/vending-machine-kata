import java.util.Map;

public class CoinReturn {

    private Map<Integer, Integer> coinCount;

    public CoinReturn(Map<Integer, Integer> coinCount) {
        this.coinCount = coinCount;
    }

    public int amountOf(Coin coin) {
        return coinCount.getOrDefault(coin.getWeight(), 0);
    }

    public void toReturn(Coin coin) {
        int currentCount = coinCount.getOrDefault(coin.getWeight(), 0);
        coinCount.put(coin.getWeight(), currentCount + 1);
    }
}
