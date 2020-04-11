import java.util.Map;

public class VendingMachine {

    private int sum;

    public VendingMachine(int sum) {
        this.sum = sum;
    }

    public boolean isValid(Coin coin) {
        return coin.getWeight() == 1;
    }

    public int getValue(Coin coin) {
        if (isValid(coin)) return 10;
        else throw new IllegalArgumentException();
    }

    public String display() {
        if (sum == 0) return "INSERT COIN";
        return "$" + (double) sum / 100;
    }

    public void insertCoin(Coin coin) {
        sum += getValue(coin);
    }
}