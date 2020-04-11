import java.util.Map;

public class VendingMachine {

    public boolean isValid(Coin coin) {
        return coin.getWeight() == 1;
    }
}