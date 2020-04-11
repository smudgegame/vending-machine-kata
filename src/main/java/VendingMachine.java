import java.util.Map;

public class VendingMachine {

    private int sum;
    private CoinReturn coinReturn;

    public VendingMachine(int sum, CoinReturn coinReturn) {
        this.sum = sum;
        this.coinReturn = coinReturn;
    }

    public boolean isValid(Coin coin) {
        return coin.getWeight() == 1 || coin.getWeight() == 3;
    }

    public int getValue(Coin coin) {
        if (isValid(coin)) return 10;
        throw new IllegalArgumentException();
    }

    public String display() {
        if (sum == 0) return "INSERT COIN";
        return "$" + (double) sum / 100;
    }

    public void insertCoin(Coin coin) {
        if (!isValid(coin)) coinReturn.toReturn(coin);
        else sum += getValue(coin);
    }

    public void reset() {
        sum = 0;
    }
}