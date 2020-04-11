import java.util.Map;

public class VendingMachine {

    public boolean isValid(Coin coin) {
        return coin.getWeight() == 1;
    }

    public int getValue(Coin coin) {
        return 10;
    }
}