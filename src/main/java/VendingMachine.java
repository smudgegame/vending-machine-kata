import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private static final int DIME = 1;
    private static final int NICKEL = 3;

    private int sum = 0;
    private Map<Integer, Integer> coinValue;

    public VendingMachine(int sum, Map<Integer, Integer> coinValue) {
        this.sum = sum;
        this.coinValue = coinValue;

        coinValue.put(DIME,10);
        coinValue.put(NICKEL,5);
    }

    public boolean isValid(int weight) {
        return coinValue.containsKey(weight);
    }

    public int insertCoin(int coinWeight) {
        if (isValid(coinWeight)) {
            sum += coinValue.get(coinWeight);
        }
        return coinValue.getOrDefault(coinWeight,0);
    }

    public String display() {
        if (sum == 0)
            return "INSERT COIN";
        else return "$" + (double) sum / 100;
    }
}