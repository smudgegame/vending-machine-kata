import java.util.Map;

public class VendingMachine {

    public boolean isValid(Coin coin) {
        return coin.getWeight() == 1;
    }

    public int getValue(Coin coin) {
        if(isValid(coin)) return 10;
        else throw new IllegalArgumentException();
    }

    public String display() {
        return "INSERT COIN";
    }
}