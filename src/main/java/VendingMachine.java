import java.util.Map;

public class VendingMachine {

    private int sum;
    private CoinReturn coinReturn;
    private WeightToValue weightToValue;

    public VendingMachine(int sum, CoinReturn coinReturn, WeightToValue weightToValue) {
        this.sum = sum;
        this.coinReturn = coinReturn;
        this.weightToValue = weightToValue;
    }


    public int getValue(Coin coin) {
        if (weightToValue.isValid(coin)) return weightToValue.get(coin);
        throw new IllegalArgumentException();
    }

    public String display() {
        if (sum == 0) return "INSERT COIN";
        return "$" + (double) sum / 100;
    }

    public void insertCoin(Coin coin) {
        if (!weightToValue.isValid(coin)) coinReturn.toReturn(coin);
        else sum += getValue(coin);
    }

    public void reset() {
        sum = 0;
    }
}