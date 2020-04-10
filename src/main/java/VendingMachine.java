import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private int sum = 0;
    private Map<Integer, Integer> coinValue;
    private Map<Integer, Integer> coinReturn;

    public VendingMachine(int sum, Map<Integer, Integer> coinValue, Map<Integer, Integer> coinReturn) {
        this.sum = sum;
        this.coinValue = coinValue;
        this.coinReturn = coinReturn;
    }

    public boolean isValid(int weight) {
        return coinValue.containsKey(weight);
    }

    public void insertCoin(int coinWeight) {
        if (isValid(coinWeight)) {
            sum += coinValue.get(coinWeight);
        }
    }

    public String display() {
        if (sum == 0)
            return "INSERT COIN";
        else return "$" + (double) sum / 100;
    }

    public int toCoinReturn(int weight) {
        int currentCount = coinReturn.getOrDefault(weight, 0);
        coinReturn.put(weight, currentCount + 1);
        return coinReturn.get(weight);
    }

    public void reset() {
        sum = 0;
        coinReturn.clear();
    }
}