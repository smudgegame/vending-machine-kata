import java.util.Map;

public class VendingMachine {

    private int sum;
    private CoinReturn coinReturn;

    public VendingMachine(int sum, CoinReturn coinReturn) {
        this.sum = sum;
        this.coinReturn = coinReturn;
    }

    public boolean isValid(Coin coin) {
        return coin.getWeight() == 1;
    }

    public int getValue(Coin coin) {
        if (isValid(coin)) return 10;
        else {
            coinReturn.toReturn(coin);
            return 0;
        }

    }

    public String display() {
        if (sum == 0) return "INSERT COIN";
        return "$" + (double) sum / 100;
    }

    public void insertCoin(Coin coin) {
        sum += getValue(coin);
    }
}